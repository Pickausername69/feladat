package hu.orszaggyules.feladat.dal.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SzavazasTipusEntity {
    JELENLET("j"),
    EGYSZERU_TOBBSEGI_SZAVAZAS("e"),
    MINOSITETT_TOBBSEGI_SZAVAZAS("m");

    private String tipus;

    public static SzavazasTipusEntity of(String value) {
        for (SzavazasTipusEntity szavazasTipus : values()) {
            if (szavazasTipus.getTipus().equals(value)) {
                return szavazasTipus;
            }
        }
        throw new IllegalArgumentException("Invalid SzavazasTipusEntity: " + value);
    }
}
