package hu.orszaggyules.feladat.web.converter;

import hu.orszaggyules.feladat.service.domain.SzavazasEredmeny;
import hu.orszaggyules.feladat.web.domain.response.SzavazasEredmenyResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SzavazasEredmenyToSzavazasEredmenyResponse implements Converter<SzavazasEredmeny, SzavazasEredmenyResponse> {
    @Override
    public SzavazasEredmenyResponse convert(SzavazasEredmeny source) {
        return SzavazasEredmenyResponse.builder()
                .eredmeny(source.getEredmeny().getEredmenyValue())
                .kepviselokSzama(source.getKepviselokSzama())
                .igenekSzama(source.getIgenekSzama())
                .nemekSzama(source.getNemekSzama())
                .tartozkodasokSzama(source.getTartozkodasokSzama())
                .build();
    }
}
