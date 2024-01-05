package hu.orszaggyules.feladat.web.controller;

import hu.orszaggyules.feladat.service.SzavazasService;
import hu.orszaggyules.feladat.service.domain.Szavazas;
import hu.orszaggyules.feladat.service.domain.SzavazasEredmeny;
import hu.orszaggyules.feladat.service.domain.SzavazatTipus;
import hu.orszaggyules.feladat.web.domain.request.SzavazasSaveRequest;
import hu.orszaggyules.feladat.web.domain.exception.ElnokNemSzavazottException;
import hu.orszaggyules.feladat.web.domain.response.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
public class SzavazasController {
    private SzavazasService szavazasService;
    private ConversionService conversionService;

    @RequestMapping(value = "/szavazasok/szavazas", method = RequestMethod.POST)
    public SzavazasSaveResponse szavazas(@RequestBody @Valid SzavazasSaveRequest szavazasSaveRequest) {


        checkIfElnokVotedToo(szavazasSaveRequest);
        Szavazas szavazasToSave = conversionService.convert(szavazasSaveRequest, Szavazas.class);
        String savedSzavazas = szavazasService.save(szavazasToSave);
        return conversionService.convert(savedSzavazas, SzavazasSaveResponse.class);
    }

    @RequestMapping(value = "/szavazasok/szavazat", method = RequestMethod.GET)
    public KepviseloSzavazatOnSzavazasResponse getKepviseloSzavazatOnSzavazas(@RequestParam String szavazas, @RequestParam String kepviselo) {
        SzavazatTipus szavazatTipus = szavazasService.getKepviseloSzavazatOnSzavazas(szavazas, kepviselo);
        return conversionService.convert(szavazatTipus, KepviseloSzavazatOnSzavazasResponse.class);
    }

    @RequestMapping(value = "/szavazasok/eredmeny", method = RequestMethod.GET)
    public SzavazasEredmenyResponse getSzavazasEredmeny(@RequestParam String szavazas) {
        SzavazasEredmeny szavazasEredmeny = szavazasService.getSzavazasEredmeny(szavazas);
        return conversionService.convert(szavazasEredmeny, SzavazasEredmenyResponse.class);
    }

    @RequestMapping(value = "/szavazasok/napi-szavazasok", method = RequestMethod.GET)
    public ComplexSzavazasEredmenyResponseWrapper getNapiSzavazat(@RequestParam LocalDate nap) {
        List<Szavazas> szavazasList = szavazasService.getSzavazasOnDate(nap);
        List<ComplexSzavazasEredmenyResponse> result = new ArrayList<>();
        szavazasList.forEach(szavazas -> {
            ComplexSzavazasEredmenyResponse converted = conversionService.convert(szavazas, ComplexSzavazasEredmenyResponse.class);
            extendComplexSzavazasEredmenyResponse(converted, szavazas);
            result.add(converted);
        });
        return new ComplexSzavazasEredmenyResponseWrapper(result);
    }

    //Note that for this request the constant 200 kepviselo number was used
    @RequestMapping(value="/szavazasok/kepviselo-reszvetel-atlag", method = RequestMethod.GET)
    public KepviseloAtlagInTimePeriodResponse getKepviseloAtlagInTimePeriod(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        DecimalFormat format = new DecimalFormat("#.##");
        Float atlag = szavazasService.getAtlagInTimePeriod(start, end);
        return KepviseloAtlagInTimePeriodResponse.builder()
                .atlag(format.format(atlag))
                .build();
    }

    private void extendComplexSzavazasEredmenyResponse(ComplexSzavazasEredmenyResponse complexSzavazasEredmenyResponse, Szavazas szavazas) {
        SzavazasEredmeny szavazasEredmeny = szavazasService.getSzavazasEredmeny(szavazas.getId());
        complexSzavazasEredmenyResponse.setEredmeny(szavazasEredmeny.getEredmeny().getEredmenyValue());
        complexSzavazasEredmenyResponse.setKepviselokSzama(szavazasEredmeny.getKepviselokSzama());
    }

    private void checkIfElnokVotedToo(SzavazasSaveRequest szavazasSaveRequest) {
        szavazasSaveRequest.getSzavazatok()
                .stream()
                .filter(szavazat -> szavazat.getKepviselo().equals(szavazasSaveRequest.getElnok()))
                .findAny()
                .orElseThrow(() -> new ElnokNemSzavazottException(szavazasSaveRequest.getElnok()));
    }
}
