package hu.orszaggyules.feladat.web.domain.exception;

public class ElnokNemSzavazottException extends RuntimeException {
    public ElnokNemSzavazottException(String elnok) {
        super(elnok + " should also vote.");
    }
}
