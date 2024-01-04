package hu.orszaggyules.feladat.service;

import hu.orszaggyules.feladat.dal.domain.SzavazasEntity;
import hu.orszaggyules.feladat.dal.domain.SzavazatEntity;
import hu.orszaggyules.feladat.dal.domain.SzavazatIdEntity;
import hu.orszaggyules.feladat.dal.repository.KepviseloRepository;
import hu.orszaggyules.feladat.dal.repository.SzavazasRepository;
import hu.orszaggyules.feladat.dal.repository.SzavazatRepository;
import hu.orszaggyules.feladat.service.domain.Szavazas;
import hu.orszaggyules.feladat.service.domain.SzavazasEredmeny;
import hu.orszaggyules.feladat.service.domain.SzavazatTipus;
import hu.orszaggyules.feladat.service.result.SzavazasResultCalculatorManager;
import hu.orszaggyules.feladat.service.util.SzavazasIdGenerator;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

@AllArgsConstructor
@Service
public class SzavazasService {
    private static final Integer SZAVAZAS_ID_LENGTH = 6;
    private static final Integer SZAVAZAS_ID_GENERATION_RETRY_COUNT = 5;
    private ConversionService conversionService;
    private SzavazasRepository szavazasRepository;
    private SzavazatRepository szavazatRepository;
    private KepviseloRepository kepviseloRepository;
    private SzavazasResultCalculatorManager szavazasResultCalculatorManager;
    private SzavazasIdGenerator szavazasIdGenerator;

    @Transactional
    public String save(Szavazas szavazas) {
        validateKepviselos(szavazas);
        SzavazasEntity szavazasEntity = conversionService.convert(szavazas, SzavazasEntity.class);
        assignUniqueIdToSzavazas(szavazasEntity);
        SzavazasEntity saved = szavazasRepository.save(szavazasEntity);
        return conversionService.convert(saved, String.class);
    }

    public SzavazatTipus getKepviseloSzavazatOnSzavazas(String szavazasId, String kepviseloId) {
        SzavazatIdEntity szavazatIdEntity = SzavazatIdEntity.builder()
                .kepviseloId(kepviseloId)
                .szavazasId(szavazasId)
                .build();
        SzavazatEntity szavazat = szavazatRepository.findById(szavazatIdEntity)
                .orElseThrow(EntityNotFoundException::new);
        return conversionService.convert(szavazat.getSzavazat().getTipus(), SzavazatTipus.class);
    }

    public SzavazasEredmeny getSzavazasEredmeny(String szavazasId) {
        return szavazasResultCalculatorManager.getSzavazasResult(szavazasId);
    }

    private void validateKepviselos(Szavazas szavazas) {
        List<String> kepviseloIds = szavazas.getSzavazatok()
                .stream()
                .map(kepviselo -> kepviselo.getKepviselo().getId())
                .toList();
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
