package hu.orszaggyules.feladat.web.converter;

import hu.orszaggyules.feladat.web.domain.response.SzavazasSaveResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToSzavazasSaveResponseConverter implements Converter<String, SzavazasSaveResponse> {
    @Override
    public SzavazasSaveResponse convert(String source) {
        return SzavazasSaveResponse.builder()
                .szavazasId(source)
                .build();
    }
}
