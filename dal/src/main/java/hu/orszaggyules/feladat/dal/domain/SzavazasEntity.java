package hu.orszaggyules.feladat.dal.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "szavazas", uniqueConstraints = {@UniqueConstraint(columnNames = {"idopont"})})
public class SzavazasEntity {
    @Id
    private String id;
    @Column(name = "idopont", unique = true)
    private LocalDateTime idopont;
    private String targy;
    @Enumerated(EnumType.STRING)
    private SzavazasTipusEntity tipus;
    //OntToOne is original
    @ManyToOne
    @JoinColumn(name = "elnok", referencedColumnName = "id")
    private KepviseloEntity elnok;
    @OneToMany(mappedBy = "szavazas", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SzavazatEntity> szavazatok;
}
