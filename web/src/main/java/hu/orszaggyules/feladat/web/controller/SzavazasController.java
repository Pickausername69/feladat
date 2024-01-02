package hu.orszaggyules.feladat.web.controller;

import hu.orszaggyules.feladat.web.domain.SzavazasSaveRequest;
import hu.orszaggyules.feladat.web.domain.exception.ElnokNemSzavazottException;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SzavazasController {

    @RequestMapping(value = "/szavazasok/szavazas", method = RequestMethod.POST)
    public void Szavazas(@RequestBody @Valid SzavazasSaveRequest szavazasSaveRequest) {
        checkIfElnokVotedToo(szavazasSaveRequest);
        System.out.println(szavazasSaveRequest);
    }

    private void checkIfElnokVotedToo(SzavazasSaveRequest szavazasSaveRequest) {
        szavazasSaveRequest.getSzavazatok()
                .stream()
                .filter(szavazat -> szavazat.getKepviselo().equals(szavazasSaveRequest.getElnok()))
                .findAny()
                .orElseThrow(() -> new ElnokNemSzavazottException(szavazasSaveRequest.getElnok()));
    }


}
