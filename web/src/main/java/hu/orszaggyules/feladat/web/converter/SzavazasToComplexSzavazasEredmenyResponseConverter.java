package hu.orszaggyules.feladat.web.converter;

import hu.orszaggyules.feladat.service.domain.Szavazas;
import hu.orszaggyules.feladat.service.domain.Szavazat;
import hu.orszaggyules.feladat.web.domain.response.ComplexSzavazasEredmenyResponse;
import hu.orszaggyules.feladat.web.domain.response.ComplexSzavazasEredmenyResponseSzavazat;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class SzavazasToComplexSzavazasEredmenyResponseConverter implements Converter<Szavazas, ComplexSzavazasEredmenyResponse> {
    private SzavazatToComplexSzavazasEredmenyResponseSzavazatConverter szavazatToComplexSzavazasEredmenyResponseSzavazatConverter;

    @Override
    public ComplexSzavazasEredmenyResponse convert(Szavazas source) {
        return ComplexSzavazasEredmenyResponse.builder()
                .elnok(source.getElnok().getId())
                .idopont(source.getIdopont())
                .targy(source.getTargy())
                .tipus(source.getTipus().getTipus())
                .szavazatok(convertSzavazats(source.getSzavazatok()))
                .build();
    }

    private List<ComplexSzavazasEredmenyResponseSzavazat> convertSzavazats(List<Szavazat> szavazats) {
        return szavazats.stream()
                .map(szavazat -> szavazatToComplexSzavazasEredmenyResponseSzavazatConverter.convert(szavazat))
                .toList();
    }
}
