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
public class SzavazatEntityToSzavazatConverter implements Converter<SzavazatEntity, Szavazat> {
    private KepviseloEntityToKepviseloConverter kepviseloEntityToKepviseloConverter;
    private SzavazatTipusEntityToSzavazatTipusConverter szavazatTipusEntityToSzavazatTipusConverter;

    @Override
    public Szavazat convert(SzavazatEntity source) {
        return Szavazat.builder()
                .kepviselo(kepviseloEntityToKepviseloConverter.convert(source.getKepviselo()))
                .szavazat(szavazatTipusEntityToSzavazatTipusConverter.convert(source.getSzavazat()))
                .szavazas(source.getSzavazas().getId())
                .build();
    }
}
