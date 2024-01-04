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
public class SzavazasToSzavazasEntityConverter implements Converter<Szavazas, SzavazasEntity> {
    private SzavazasTipusToSzavazasTipusEntityConverter szavazasTipusToSzavazasTipusEntityConverter;
    private KepviseloToKepviseloEntityConverter kepviseloToKepviseloEntityConverter;
    private SzavazatToSzavazatEntityConverter szavazatToSzavazatEntityConverter;
    @Override
    public SzavazasEntity convert(Szavazas source) {
        return SzavazasEntity.builder()
                .id(source.getId())
                .elnok(kepviseloToKepviseloEntityConverter.convert(source.getElnok()))
                .idopont(source.getIdopont())
                .targy(source.getTargy())
                .tipus(szavazasTipusToSzavazasTipusEntityConverter.convert(source.getTipus()))
                .szavazatok(convertSzavazats(source.getSzavazatok()))
                .build();
    }

    private List<SzavazatEntity> convertSzavazats(List<Szavazat> szavazats) {
        return szavazats.stream()
                .map(szavazat -> szavazatToSzavazatEntityConverter.convert(szavazat))
                .toList();
    }
}
