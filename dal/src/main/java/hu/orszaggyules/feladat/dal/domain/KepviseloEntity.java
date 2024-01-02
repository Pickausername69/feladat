package hu.orszaggyules.feladat.dal.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.experimental.Accessors;

@Builder
@Accessors
@Entity
@Table(name = "kepviselo")
public class KepviseloEntity {
    @Id
    private String id;
    private String name;
}
