package hu.orszaggyules.feladat.service.converter;

import hu.orszaggyules.feladat.dal.domain.SzavazasEntity;
import hu.orszaggyules.feladat.dal.domain.SzavazatEntity;
import hu.orszaggyules.feladat.service.domain.Szavazas;
import hu.orszaggyules.feladat.service.domain.Szavazat;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class SzavazasEntityToSzavazasConverter implements Converter<SzavazasEntity, Szavazas> {
    private SzavazasTipusEntityToSzavazasTipusConverter szavazasTipusEntityToSzavazasTipusConverter;
    private KepviseloEntityToKepviseloConverter kepviseloEntityToKepviseloConverter;
    private SzavazatEntityToSzavazatConverter szavazatEntityToSzavazatConverter;
    @Override
    public Szavazas convert(SzavazasEntity source) {
        return Szavazas.builder()
                .id(source.getId())
                .elnok(kepviseloEntityToKepviseloConverter.convert(source.getElnok()))
                .idopont(source.getIdopont())
                .targy(source.getTargy())
                .tipus(szavazasTipusEntityToSzavazasTipusConverter.convert(source.getTipus()))
                .szavazatok(convertSzavazatEntities(source.getSzavazatok()))
                .build();
    }

    private List<Szavazat> convertSzavazatEntities(List<SzavazatEntity> szavazats) {
        return szavazats.stream()
                .map(szavazat -> szavazatEntityToSzavazatConverter.convert(szavazat))
                .toList();
    }
}
