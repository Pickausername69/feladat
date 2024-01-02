package hu.orszaggyules.feladat.dal.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;


@Builder
@Accessors
@Entity
@Table(name = "szavazas", uniqueConstraints = {@UniqueConstraint(columnNames = {"idopont"})})
public class SzavazasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "idopont", unique = true)
    private LocalDateTime idopont;
    private String targy;
    private SzavazasTipusEntity szavazasTipus;
    private KepviseloEntity elnok;
}
