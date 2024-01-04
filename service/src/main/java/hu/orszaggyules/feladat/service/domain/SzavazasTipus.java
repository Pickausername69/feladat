package hu.orszaggyules.feladat.service.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SzavazasTipus {
    JELENLET("j"),
    EGYSZERU_TOBBSEGI_SZAVAZAS("e"),
    MINOSITETT_TOBBSEGI_SZAVAZAS("m");

    private String tipus;

    public static SzavazasTipus of(String value) {
        for (SzavazasTipus szavazasTipus : values()) {
            if (szavazasTipus.getTipus().equals(value)) {
                return szavazasTipus;
            }
        }
        throw new IllegalArgumentException("Invalid SzavazasTipus: " + value);
    }
}
