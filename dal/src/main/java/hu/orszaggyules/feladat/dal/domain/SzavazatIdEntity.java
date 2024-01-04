package hu.orszaggyules.feladat.dal.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Embeddable
public class SzavazatIdEntity {
    @Column(name = "szavazat_id")
    private String kepviseloId;
    @Column(name = "szavazas_id")
    private String szavazasId;
}
