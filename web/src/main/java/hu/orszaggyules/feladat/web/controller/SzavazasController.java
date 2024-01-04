package hu.orszaggyules.feladat.web.controller;

import hu.orszaggyules.feladat.service.SzavazasService;
import hu.orszaggyules.feladat.service.domain.Szavazas;
import hu.orszaggyules.feladat.service.domain.SzavazasEredmeny;
import hu.orszaggyules.feladat.service.domain.SzavazatTipus;
import hu.orszaggyules.feladat.web.domain.request.SzavazasSaveRequest;
import hu.orszaggyules.feladat.web.domain.exception.ElnokNemSzavazottException;
import hu.orszaggyules.feladat.web.domain.response.KepviseloSzavazatOnSzavazasResponse;
import hu.orszaggyules.feladat.web.domain.response.SzavazasEredmenyResponse;
import hu.orszaggyules.feladat.web.domain.response.SzavazasSaveResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/szavazasok/szavazas", method = RequestMethod.GET)
    public KepviseloSzavazatOnSzavazasResponse getKepviseloSzavazatOnSzavazas(@RequestParam String szavazas, @RequestParam String kepviselo) {
        SzavazatTipus szavazatTipus = szavazasService.getKepviseloSzavazatOnSzavazas(szavazas, kepviselo);
        return conversionService.convert(szavazatTipus, KepviseloSzavazatOnSzavazasResponse.class);
    }

    @RequestMapping(value = "/szavazasok/eredmeny", method = RequestMethod.GET)
    public SzavazasEredmenyResponse getSzavazasEredmeny(@RequestParam String szavazas) {
        SzavazasEredmeny szavazasEredmeny =szavazasService.getSzavazasEredmeny(szavazas);
        return conversionService.convert(szavazasEredmeny, SzavazasEredmenyResponse.class);
    }

    private void checkIfElnokVotedToo(SzavazasSaveRequest szavazasSaveRequest) {
        szavazasSaveRequest.getSzavazatok()
                .stream()
                .filter(szavazat -> szavazat.getKepviselo().equals(szavazasSaveRequest.getElnok()))
                .findAny()
                .orElseThrow(() -> new ElnokNemSzavazottException(szavazasSaveRequest.getElnok()));
    }


}
