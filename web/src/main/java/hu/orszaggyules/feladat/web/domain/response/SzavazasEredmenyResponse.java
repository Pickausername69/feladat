package hu.orszaggyules.feladat.web.domain.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SzavazasEredmenyResponse {
    private String eredmeny;
    private Integer kepviselokSzama;
    private Integer igenekSzama;
    private Integer nemekSzama;
    private Integer tartozkodasokSzama;
}
