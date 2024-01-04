package hu.orszaggyules.feladat.service;

import hu.orszaggyules.feladat.dal.domain.SzavazasEntity;
import hu.orszaggyules.feladat.dal.domain.SzavazatEntity;
import hu.orszaggyules.feladat.dal.repository.KepviseloRepository;
import hu.orszaggyules.feladat.dal.repository.SzavazasRepository;
import hu.orszaggyules.feladat.service.domain.Szavazas;
import hu.orszaggyules.feladat.service.domain.Szavazat;
import hu.orszaggyules.feladat.service.util.SzavazasIdGenerator;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import javax.management.InvalidAttributeValueException;
import java.security.InvalidParameterException;
import java.util.List;

@AllArgsConstructor
@Service
public class SzavazasService {
    private static final Integer SZAVAZAS_ID_LENGTH = 6;
    private static final Integer SZAVAZAS_ID_GENERATION_RETRY_COUNT = 5;
    private ConversionService conversionService;
    private SzavazasRepository szavazasRepository;
    private KepviseloRepository kepviseloRepository;
    private SzavazasIdGenerator szavazasIdGenerator;

    @Transactional
    public String save(Szavazas szavazas) {
        validateKepviselos(szavazas);
        SzavazasEntity szavazasEntity = conversionService.convert(szavazas, SzavazasEntity.class);
        assignUniqueIdToSzavazas(szavazasEntity);
        System.out.println("NOT ENTITY: "+szavazas);
        System.out.println("ENTITY: "+szavazasEntity);
        SzavazasEntity saved = szavazasRepository.save(szavazasEntity);
        return conversionService.convert(saved, String.class);
    }

    private void validateKepviselos(Szavazas szavazas) {
        List<String> kepviseloIds = szavazas.getSzavazatok()
                .stream()
                .map(kepviselo -> kepviselo.getKepviselo().getId())
                .toList();
        System.out.println("[!] "+kepviseloIds);
        if (!kepviseloRepository.existsAllByIdIn(kepviseloIds))
        {
            throw new InvalidParameterException("There are kepviselos who are not present in the db!");
        }
    }

    private void assignUniqueIdToSzavazas(SzavazasEntity szavazasEntity) {
        int counter = 0;
        while (counter < SZAVAZAS_ID_GENERATION_RETRY_COUNT && szavazasEntity.getId() == null) {
            counter++;
            String generatedId = szavazasIdGenerator.generateSzavazasId(SZAVAZAS_ID_LENGTH);
            if (!szavazasRepository.existsById(generatedId)) {
                szavazasEntity.setId(generatedId);
                szavazasEntity.getSzavazatok().forEach(szavazat -> {
                    szavazat.getId().setSzavazasId(generatedId);
                    szavazat.getSzavazas().setId(generatedId);
                });
            }
        }
    }
}
