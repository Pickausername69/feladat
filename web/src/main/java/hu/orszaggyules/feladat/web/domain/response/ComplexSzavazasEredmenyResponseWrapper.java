package hu.orszaggyules.feladat.web.domain.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class ComplexSzavazasEredmenyResponseWrapper {
    private List<ComplexSzavazasEredmenyResponse> szavazasok;
}
