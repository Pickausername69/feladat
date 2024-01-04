package hu.orszaggyules.feladat.service.converter;

import hu.orszaggyules.feladat.dal.domain.SzavazatTipusEntity;
import hu.orszaggyules.feladat.service.domain.SzavazatTipus;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SzavazatTipusEntityToSzavazatTipusConverter implements Converter<SzavazatTipusEntity, SzavazatTipus> {
    @Override
    public SzavazatTipus convert(SzavazatTipusEntity source) {
        return SzavazatTipus.of(source.getTipus());
    }
}
