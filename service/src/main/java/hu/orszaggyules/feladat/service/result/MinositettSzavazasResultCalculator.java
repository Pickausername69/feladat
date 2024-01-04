package hu.orszaggyules.feladat.service.result;

import hu.orszaggyules.feladat.service.domain.Szavazas;
import hu.orszaggyules.feladat.service.domain.SzavazasTipus;
import hu.orszaggyules.feladat.service.domain.SzavazatTipus;
import org.springframework.stereotype.Component;

@Component
public class MinositettSzavazasResultCalculator implements SzavazasResultCalculator {
    private static final Integer TOTAL_NUMBER_OF_KEPVISELO = 200;
    @Override
    public boolean isSzavazasAccepted(Szavazas szavazas) {
        return getNumberOfIgens(szavazas) > TOTAL_NUMBER_OF_KEPVISELO / 2;
    }

    @Override
    public int getKepviselokSzama(Szavazas szavazas) {
        return TOTAL_NUMBER_OF_KEPVISELO;
    }


    @Override
    public SzavazasTipus getSzavazasTipus() {
        return SzavazasTipus.MINOSITETT_TOBBSEGI_SZAVAZAS;
    }

    private int getNumberOfIgens(Szavazas szavazas) {
        return (int) szavazas.getSzavazatok()
                .stream()
                .filter(szavazat -> SzavazatTipus.IGEN.equals(szavazat.getSzavazat()))
                .count();
    }
}
