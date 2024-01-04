package hu.orszaggyules.feladat.service.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Szavazat {
    private Kepviselo kepviselo;
    private SzavazatTipus szavazat;
    private String szavazas;
}
