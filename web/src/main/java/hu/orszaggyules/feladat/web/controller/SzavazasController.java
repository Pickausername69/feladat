package hu.orszaggyules.feladat.web.controller;

import hu.orszaggyules.feladat.service.SzavazasService;
import hu.orszaggyules.feladat.service.domain.Szavazas;
import hu.orszaggyules.feladat.web.domain.request.SzavazasSaveRequest;
import hu.orszaggyules.feladat.web.domain.exception.ElnokNemSzavazottException;
import hu.orszaggyules.feladat.web.domain.response.SzavazasSaveResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class SzavazasController {
    private SzavazasService szavazasService;
    private ConversionService conversionService;

    @RequestMapping(value = "/szavazasok/szavazas", method = RequestMethod.POST)
    public SzavazasSaveResponse Szavazas(@RequestBody @Valid SzavazasSaveRequest szavazasSaveRequest) {
        checkIfElnokVotedToo(szavazasSaveRequest);
        Szavazas szavazasToSave = conversionService.convert(szavazasSaveRequest, Szavazas.class);
        String savedSzavazas = szavazasService.save(szavazasToSave);
        return conversionService.convert(savedSzavazas, SzavazasSaveResponse.class);
    }

    private void checkIfElnokVotedToo(SzavazasSaveRequest szavazasSaveRequest) {
        szavazasSaveRequest.getSzavazatok()
                .stream()
                .filter(szavazat -> szavazat.getKepviselo().equals(szavazasSaveRequest.getElnok()))
                .findAny()
                .orElseThrow(() -> new ElnokNemSzavazottException(szavazasSaveRequest.getElnok()));
    }


}
