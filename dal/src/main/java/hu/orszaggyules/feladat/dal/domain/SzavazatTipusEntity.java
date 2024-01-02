package hu.orszaggyules.feladat.dal.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Entity
@Table(name = "szavazat_tipus")
public enum SzavazatTipusEntity {
    IGEN(1, "igen"),
    NEM(2, "nem"),
    TARTOZKODIK(3, "tartozkodik");

    @Id
    private final Integer id;
    private final String tipus;
}
