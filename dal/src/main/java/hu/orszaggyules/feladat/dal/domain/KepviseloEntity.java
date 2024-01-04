package hu.orszaggyules.feladat.dal.domain;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "kepviselo")
public class KepviseloEntity {
    @Id
    private String id;
}
