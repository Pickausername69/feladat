package hu.orszaggyules.feladat.service.result;

import hu.orszaggyules.feladat.service.domain.Szavazas;
import hu.orszaggyules.feladat.service.domain.SzavazasTipus;

public interface SzavazasResultCalculator {
    boolean isSzavazasAccepted(Szavazas szavazas);
    SzavazasTipus getSzavazasTipus();
}
