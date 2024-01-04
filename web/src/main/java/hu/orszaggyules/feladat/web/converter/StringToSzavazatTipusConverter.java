package hu.orszaggyules.feladat.web.converter;

import hu.orszaggyules.feladat.service.domain.SzavazatTipus;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToSzavazatTipusConverter implements Converter<String, SzavazatTipus> {
    @Override
    public SzavazatTipus convert(String source) {
        return SzavazatTipus.of(source);
    }
}
