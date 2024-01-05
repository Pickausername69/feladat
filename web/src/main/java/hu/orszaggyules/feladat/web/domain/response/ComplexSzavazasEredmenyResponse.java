package hu.orszaggyules.feladat.web.domain.response;

import hu.orszaggyules.feladat.web.domain.request.SzavazasSaveRequestSzavazat;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
public class ComplexSzavazasEredmenyResponse {
    private LocalDateTime idopont;
    private String targy;
    private String tipus;
    private String elnok;
    private String eredmeny;
    private Integer kepviselokSzama;
    private List<ComplexSzavazasEredmenyResponseSzavazat> szavazatok;
}
