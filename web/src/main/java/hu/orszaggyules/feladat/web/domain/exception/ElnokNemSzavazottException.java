package hu.orszaggyules.feladat.web.domain.exception;

import hu.orszaggyules.feladat.web.domain.SzavazasSaveRequest;

public class ElnokNemSzavazottException extends RuntimeException {
    public ElnokNemSzavazottException(String elnok) {
        super(elnok + " should also vote.");
    }
}
