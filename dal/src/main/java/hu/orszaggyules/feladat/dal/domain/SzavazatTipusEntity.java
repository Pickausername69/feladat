package hu.orszaggyules.feladat.dal.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SzavazatTipusEntity {
    IGEN("i"),
    NEM("n"),
    TARTOZKODIK("t");

    private String tipus;

    public static SzavazatTipusEntity of(String value) {
        for (SzavazatTipusEntity szavazatTipus : values()) {
            if (szavazatTipus.getTipus().equals(value)) {
                return szavazatTipus;
            }
        }
        throw new IllegalArgumentException("Invalid SzavazatTipusEntity: " + value);
    }
}
