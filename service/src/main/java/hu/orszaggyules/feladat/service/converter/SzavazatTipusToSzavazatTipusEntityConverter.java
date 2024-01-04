package hu.orszaggyules.feladat.service.converter;

import hu.orszaggyules.feladat.dal.domain.SzavazatTipusEntity;
import hu.orszaggyules.feladat.service.domain.SzavazatTipus;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SzavazatTipusToSzavazatTipusEntityConverter implements Converter<SzavazatTipus, SzavazatTipusEntity> {
    @Override
    public SzavazatTipusEntity convert(SzavazatTipus source) {
        return SzavazatTipusEntity.of(source.getTipus());
    }
}
