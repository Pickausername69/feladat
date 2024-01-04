package hu.orszaggyules.feladat.service.converter;

import hu.orszaggyules.feladat.dal.domain.KepviseloEntity;
import hu.orszaggyules.feladat.service.domain.Kepviselo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class KepviseloToKepviseloEntityConverter implements Converter<Kepviselo, KepviseloEntity> {
    @Override
    public KepviseloEntity convert(Kepviselo source) {
        return KepviseloEntity.builder()
                .id(source.getId())
                .build();
    }
}
