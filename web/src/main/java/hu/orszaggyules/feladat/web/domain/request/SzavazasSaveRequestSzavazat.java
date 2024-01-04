package hu.orszaggyules.feladat.web.domain.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class SzavazasSaveRequestSzavazat {
    @NotBlank
    private String kepviselo;
    @NotNull
    @Pattern(regexp = "[int]")
    private String szavazat;
}
