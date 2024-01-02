package hu.orszaggyules.feladat.dal.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.experimental.Accessors;

@Builder
@Accessors
@Entity
@Table(name = "szavazat")
public class SzavazatEntity {
    private
}
