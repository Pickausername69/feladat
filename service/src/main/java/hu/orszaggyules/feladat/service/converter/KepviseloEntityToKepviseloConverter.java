package hu.orszaggyules.feladat.service.converter;

import hu.orszaggyules.feladat.dal.domain.KepviseloEntity;
import hu.orszaggyules.feladat.service.domain.Kepviselo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class KepviseloEntityToKepviseloConverter implements Converter<KepviseloEntity, Kepviselo> {
    @Override
    public Kepviselo convert(KepviseloEntity source) {
        return Kepviselo.builder()
                .id(source.getId())
                .build();
    }
}
