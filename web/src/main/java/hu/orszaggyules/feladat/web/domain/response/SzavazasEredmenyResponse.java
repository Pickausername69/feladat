package hu.orszaggyules.feladat.web.domain.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SzavazasEredmenyResponse {
    String eredmeny;
    Integer kepviselokSzama;
    Integer igenekSzama;
    Integer nemekSzama;
    Integer tartozkodasokSzama;
}
