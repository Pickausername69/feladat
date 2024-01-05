package hu.orszaggyules.feladat.web.converter;

import hu.orszaggyules.feladat.service.domain.Szavazat;
import hu.orszaggyules.feladat.web.domain.response.ComplexSzavazasEredmenyResponseSzavazat;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SzavazatToComplexSzavazasEredmenyResponseSzavazatConverter implements Converter<Szavazat, ComplexSzavazasEredmenyResponseSzavazat> {
    @Override
    public ComplexSzavazasEredmenyResponseSzavazat convert(Szavazat source) {
        return ComplexSzavazasEredmenyResponseSzavazat.builder()
                .szavazat(source.getSzavazat().getTipus())
                .kepviselo(source.getKepviselo().getId())
                .build();
    }
}
