package hu.orszaggyules.feladat.web.converter;

import hu.orszaggyules.feladat.service.domain.Szavazat;
import hu.orszaggyules.feladat.web.domain.request.SzavazasSaveRequestSzavazat;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class SzavazasSaveRequestSzavazatToSzavazatConverter implements Converter<SzavazasSaveRequestSzavazat, Szavazat> {
    private StringToKepviseloConverter stringToKepviseloConverter;
    private StringToSzavazatTipusConverter szavazatTipusConverter;

    @Override
    public Szavazat convert(SzavazasSaveRequestSzavazat source) {
        return Szavazat.builder()
                .kepviselo(stringToKepviseloConverter.convert(source.getKepviselo()))
                .szavazat(szavazatTipusConverter.convert(source.getSzavazat()))
                .build();
    }
}
