package hu.orszaggyules.feladat.service.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SzavazasEredmeny {
    SzavazasEredmenyValue eredmeny;
    Integer kepviselokSzama;
    Integer igenekSzama;
    Integer nemekSzama;
    Integer tartozkodasokSzama;
}
