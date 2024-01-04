package hu.orszaggyules.feladat.service.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SzavazasEredmenyValue {
    ACCEPTED("F"),
    REJECTED("U");

    private String eredmenyValue;

    public static SzavazasEredmenyValue of(boolean value) {
        return value ? ACCEPTED : REJECTED;
    }
}
