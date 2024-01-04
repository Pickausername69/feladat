package hu.orszaggyules.feladat.service.result;

import hu.orszaggyules.feladat.service.domain.Szavazas;
import hu.orszaggyules.feladat.service.domain.SzavazasTipus;
import org.springframework.stereotype.Component;

@Component
public class JelenletSzavazasResultCalculator implements SzavazasResultCalculator {
    @Override
    public boolean isSzavazasAccepted(Szavazas szavazas) {
        return true;
    }

    @Override
    public int getKepviselokSzama(Szavazas szavazas) {
        return szavazas.getSzavazatok().size();
    }

    @Override
    public SzavazasTipus getSzavazasTipus() {
        return SzavazasTipus.JELENLET;
    }
}
