package hu.orszaggyules.feladat.service.result;

import hu.orszaggyules.feladat.service.domain.Szavazas;
import hu.orszaggyules.feladat.service.domain.SzavazasTipus;
import hu.orszaggyules.feladat.service.domain.SzavazatTipus;
import org.springframework.stereotype.Component;

@Component
public class EgyszeruSzavazasResultCalculator implements SzavazasResultCalculator {
    @Override
    public boolean isSzavazasAccepted(Szavazas szavazas) {
        return getNumberOfIgens(szavazas) > szavazas.getSzavazatok().size();
    }

    @Override
    public SzavazasTipus getSzavazasTipus() {
        return SzavazasTipus.EGYSZERU_TOBBSEGI_SZAVAZAS;
    }

    private int getNumberOfIgens(Szavazas szavazas) {
        return (int) szavazas.getSzavazatok()
                .stream()
                .filter(szavazat -> SzavazatTipus.IGEN.equals(szavazat.getSzavazat()))
                .count();
    }

}
