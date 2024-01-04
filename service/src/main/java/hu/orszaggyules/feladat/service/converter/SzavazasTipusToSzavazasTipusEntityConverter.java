package hu.orszaggyules.feladat.service.converter;

import hu.orszaggyules.feladat.dal.domain.SzavazasTipusEntity;
import hu.orszaggyules.feladat.service.domain.SzavazasTipus;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SzavazasTipusToSzavazasTipusEntityConverter implements Converter<SzavazasTipus, SzavazasTipusEntity> {
    @Override
    public SzavazasTipusEntity convert(SzavazasTipus source) {
        return SzavazasTipusEntity.of(source.getTipus());
    }
}
