package hu.orszaggyules.feladat.web.domain.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class KepviseloSzavazatOnSzavazasResponse {
    private String szavazat;
}
