package hu.orszaggyules.feladat.web.domain.request;

import hu.orszaggyules.feladat.web.validation.UniqueSzavazat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@ToString
@Getter
public class SzavazasSaveRequest {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime idopont;
    @NotBlank
    private String targy;
    @NotNull
    @Pattern(regexp = "[jem]")
    private String tipus;
    @NotBlank
    private String elnok;
    @Valid
    @UniqueSzavazat
    private List<SzavazasSaveRequestSzavazat> szavazatok;

}
