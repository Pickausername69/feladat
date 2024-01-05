package hu.orszaggyules.feladat.web.domain.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ComplexSzavazasEredmenyResponseSzavazat {
    private String kepviselo;
    private String szavazat;
}
