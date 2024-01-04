package hu.orszaggyules.feladat.service.converter;

import hu.orszaggyules.feladat.dal.domain.SzavazasEntity;
import org.springframework.core.convert.converter.Converter;

public class SzavazasEntityToStringConverter implements Converter<SzavazasEntity, String>  {
    @Override
    public String convert(SzavazasEntity source) {
        return source.getId();
    }
}
