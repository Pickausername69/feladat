package hu.orszaggyules.feladat.web.converter;

import hu.orszaggyules.feladat.service.domain.SzavazasTipus;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToSzavazasTipusConverter implements Converter<String, SzavazasTipus> {
    @Override
    public SzavazasTipus convert(String source) {
        return SzavazasTipus.of(source);
    }
}
