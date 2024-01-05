package hu.orszaggyules.feladat.service.result;

import hu.orszaggyules.feladat.dal.repository.SzavazasRepository;
import hu.orszaggyules.feladat.service.domain.JelenletiSzavazasNotFoundException;
import hu.orszaggyules.feladat.service.domain.Szavazas;
import hu.orszaggyules.feladat.service.domain.SzavazasTipus;
import hu.orszaggyules.feladat.service.domain.SzavazatTipus;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class EgyszeruSzavazasResultCalculator implements SzavazasResultCalculator {
    private SzavazasRepository szavazasRepository;
    @Override
    public boolean isSzavazasAccepted(Szavazas szavazas) {
        return getNumberOfIgens(szavazas) > ((float) szavazasRepository
                .findOldestJelenletiSzavazas(szavazas.getIdopont())
                .orElseThrow(JelenletiSzavazasNotFoundException::new)
                .getSzavazatok().size()) / 2f;
    }

    @Override
    public int getKepviselokSzama(Szavazas szavazas) {
        return szavazasRepository
                .findOldestJelenletiSzavazas(szavazas.getIdopont())
                .orElseThrow(EntityNotFoundException::new)
                .getSzavazatok().size();
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
