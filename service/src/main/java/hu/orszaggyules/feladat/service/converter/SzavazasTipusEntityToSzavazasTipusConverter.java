package hu.orszaggyules.feladat.service.converter;

import hu.orszaggyules.feladat.dal.domain.SzavazasTipusEntity;
import hu.orszaggyules.feladat.service.domain.SzavazasTipus;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SzavazasTipusEntityToSzavazasTipusConverter implements Converter<SzavazasTipusEntity, SzavazasTipus> {
    @Override
    public SzavazasTipus convert(SzavazasTipusEntity source) {
        return SzavazasTipus.of(source.getTipus());
    }
}
