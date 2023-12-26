package hu.orszaggyules.feladat.dal.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "testthingy")
public class TestEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String strValue;

    public String getStrValue() {
        return strValue;
    }
}
