package hu.orszaggyules.feladat.dal.domain;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "szavazat")
public class SzavazatEntity {
    @EmbeddedId
    private SzavazatIdEntity id;

    @ManyToOne
    @MapsId("kepviseloId")
    @JoinColumn(name = "kepviselo_id")
    private KepviseloEntity kepviselo;

    @ManyToOne
    @MapsId("szavazasId")
    @JoinColumn(name = "szavazas_id")
    private SzavazasEntity szavazas;

    @Enumerated(value = EnumType.STRING)
    private SzavazatTipusEntity szavazat;
}
