package hu.orszaggyules.feladat.web.converter;

import hu.orszaggyules.feladat.service.domain.Kepviselo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToKepviseloConverter implements Converter<String, Kepviselo> {
    @Override
    public Kepviselo convert(String source) {
        return Kepviselo.builder()
                .id(source)
                .build();
    }
}
