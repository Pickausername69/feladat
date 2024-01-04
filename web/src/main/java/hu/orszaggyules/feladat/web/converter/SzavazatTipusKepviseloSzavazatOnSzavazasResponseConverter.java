package hu.orszaggyules.feladat.web.converter;

import hu.orszaggyules.feladat.service.domain.SzavazatTipus;
import hu.orszaggyules.feladat.web.domain.response.KepviseloSzavazatOnSzavazasResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SzavazatTipusKepviseloSzavazatOnSzavazasResponseConverter implements Converter<SzavazatTipus, KepviseloSzavazatOnSzavazasResponse> {
    @Override
    public KepviseloSzavazatOnSzavazasResponse convert(SzavazatTipus source) {
        return KepviseloSzavazatOnSzavazasResponse.builder()
                .szavazat(source.getTipus())
                .build();
    }
}
