package hu.orszaggyules.feladat.service.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
public class Szavazas {
    private String id;
    private LocalDateTime idopont;
    private String targy;
    private SzavazasTipus tipus;
    private Kepviselo elnok;
    private List<Szavazat> szavazatok;
}
