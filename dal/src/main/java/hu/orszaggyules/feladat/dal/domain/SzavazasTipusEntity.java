package hu.orszaggyules.feladat.dal.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Entity
@Table(name = "szavazas_tipus")
public enum SzavazasTipusEntity {
    JELENLET(1, "jelenlet"),
    EGYSZERU_TOBBSEGI_SZAVAZAS(2, "egyszeru tobbsegi szavazas"),
    MINOSITETT_TOBBSEGI_SZAVAZAS(3, "minositett tobbsegi szavazas");

    @Id
    private Integer id;
    private String tipus;
}
