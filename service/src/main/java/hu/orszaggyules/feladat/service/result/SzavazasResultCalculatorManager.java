package hu.orszaggyules.feladat.service.result;

import hu.orszaggyules.feladat.dal.domain.SzavazasEntity;
import hu.orszaggyules.feladat.dal.repository.SzavazasRepository;
import hu.orszaggyules.feladat.service.domain.*;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class SzavazasResultCalculatorManager {
    private List<SzavazasResultCalculator> szavazasResultCalculators;
    private ConversionService conversionService;
    private SzavazasRepository szavazasRepository;

    public SzavazasEredmeny getSzavazasResult(String szavazasId) {
        SzavazasEntity szavazasEntity = szavazasRepository.findById(szavazasId)
                .orElseThrow(() -> new RuntimeException("Record not found!"));
        Szavazas szavazas = conversionService.convert(szavazasEntity, Szavazas.class);
        SzavazasResultCalculator szavazasResultCalculator = szavazasResultCalculators.stream()
                .filter(calculator -> calculator.getSzavazasTipus().equals(szavazas.getTipus()))
                .findFirst()
                .get();
        return SzavazasEredmeny.builder()
                .eredmeny(isSzavazasAccepted(szavazasResultCalculator, szavazas))
                .kepviselokSzama(szavazasResultCalculator.getKepviselokSzama(szavazas))
                .igenekSzama(calculateIgenekSzama(szavazas))
                .nemekSzama(calculateNemekSzama(szavazas))
                .tartozkodasokSzama(calculateTartozkodasokSzama(szavazas))
                .build();
    }
    private SzavazasEredmenyValue isSzavazasAccepted(SzavazasResultCalculator szavazasResultCalculator, Szavazas szavazas) {
        boolean accepted = szavazasResultCalculator.isSzavazasAccepted(szavazas);
        return SzavazasEredmenyValue.of(accepted);
    }
    private int calculateIgenekSzama(Szavazas szavazas) {
        return (int) szavazas.getSzavazatok()
                .stream()
                .filter(szavazat -> SzavazatTipus.IGEN.equals(szavazat.getSzavazat()))
                .count();
    }
    private int calculateNemekSzama(Szavazas szavazas) {
        return (int) szavazas.getSzavazatok()
                .stream()
                .filter(szavazat -> SzavazatTipus.NEM.equals(szavazat.getSzavazat()))
                .count();
    }
    private int calculateTartozkodasokSzama(Szavazas szavazas) {
        return (int) szavazas.getSzavazatok()
                .stream()
                .filter(szavazat -> SzavazatTipus.TARTOZKODIK.equals(szavazat.getSzavazat()))
                .count();
    }
}
