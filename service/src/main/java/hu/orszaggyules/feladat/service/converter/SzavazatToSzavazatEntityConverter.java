package hu.orszaggyules.feladat.service.converter;

import hu.orszaggyules.feladat.dal.domain.SzavazasEntity;
import hu.orszaggyules.feladat.dal.domain.SzavazatEntity;
import hu.orszaggyules.feladat.dal.domain.SzavazatIdEntity;
import hu.orszaggyules.feladat.service.domain.Szavazat;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class SzavazatToSzavazatEntityConverter implements Converter<Szavazat, SzavazatEntity> {
    private KepviseloToKepviseloEntityConverter kepviseloToKepviseloEntityConverter;
    private SzavazatTipusToSzavazatTipusEntityConverter szavazatTipusToSzavazatTipusEntityConverter;

    @Override
    public SzavazatEntity convert(Szavazat source) {
        return SzavazatEntity.builder()
                .kepviselo(kepviseloToKepviseloEntityConverter.convert(source.getKepviselo()))
                .szavazat(szavazatTipusToSzavazatTipusEntityConverter.convert(source.getSzavazat()))
                .id(setSzavazatIdEntity(source))
                .szavazas(new SzavazasEntity())
                .build();
    }

    private SzavazatIdEntity setSzavazatIdEntity(Szavazat source) {
        return SzavazatIdEntity.builder()
                .kepviseloId(source.getKepviselo().getId())
                .build();
    }
}
