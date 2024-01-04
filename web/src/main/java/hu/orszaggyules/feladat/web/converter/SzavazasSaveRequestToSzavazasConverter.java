package hu.orszaggyules.feladat.web.converter;

import hu.orszaggyules.feladat.service.domain.Szavazas;
import hu.orszaggyules.feladat.service.domain.Szavazat;
import hu.orszaggyules.feladat.web.domain.request.SzavazasSaveRequest;
import hu.orszaggyules.feladat.web.domain.request.SzavazasSaveRequestSzavazat;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class SzavazasSaveRequestToSzavazasConverter implements Converter<SzavazasSaveRequest, Szavazas> {
    private SzavazasSaveRequestSzavazatToSzavazatConverter szavazasSaveRequestSzavazatToSzavazatConverter;
    private StringToSzavazasTipusConverter stringToSzavazasTipusConverter;
    private StringToKepviseloConverter stringToKepviseloConverter;

    @Override
    public Szavazas convert(SzavazasSaveRequest source) {
        return Szavazas.builder()
                .elnok(stringToKepviseloConverter.convert(source.getElnok()))
                .idopont(source.getIdopont())
                .targy(source.getTargy())
                .szavazatok(convertSzavazats(source.getSzavazatok()))
                .tipus(stringToSzavazasTipusConverter.convert(source.getTipus()))
                .build();
    }

    private List<Szavazat> convertSzavazats(List<SzavazasSaveRequestSzavazat> szavazats) {
        return szavazats.stream()
                .map(szavazat -> szavazasSaveRequestSzavazatToSzavazatConverter.convert(szavazat))
                .toList();
    }
}
