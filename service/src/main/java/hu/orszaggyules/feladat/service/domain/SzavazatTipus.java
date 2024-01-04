package hu.orszaggyules.feladat.service.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
public enum SzavazatTipus {
    IGEN("i"),
    NEM("n"),
    TARTOZKODIK("t");

    private final String tipus;

    public static SzavazatTipus of(String value) {
        for (SzavazatTipus szavazatTipus : values()) {
            if (szavazatTipus.getTipus().equals(value)) {
                return szavazatTipus;
            }
        }
        throw new IllegalArgumentException("Invalid SzavazatTipus: " + value);
    }
}
