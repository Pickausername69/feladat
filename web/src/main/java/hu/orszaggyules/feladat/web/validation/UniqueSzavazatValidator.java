package hu.orszaggyules.feladat.web.validation;

import hu.orszaggyules.feladat.web.domain.request.SzavazasSaveRequestSzavazat;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UniqueSzavazatValidator implements ConstraintValidator<UniqueSzavazat, List<SzavazasSaveRequestSzavazat>> {

    private String message;

    @Override
    public void initialize(UniqueSzavazat uniqueSzavazat) {
        this.message = uniqueSzavazat.message();
    }

    @Override
    public boolean isValid(List<SzavazasSaveRequestSzavazat> list, ConstraintValidatorContext context) {
        boolean result = true;
        Set<String> uniqueKepviselo = new HashSet<>();
        for (SzavazasSaveRequestSzavazat szavazat : list) {
            String kepviselo = szavazat.getKepviselo();
            if (!uniqueKepviselo.contains(kepviselo)) {
                uniqueKepviselo.add(kepviselo);
            } else {
                buildConstraintViolation(context, message);
                result = false;
                break;
            }
        }
        return result;
    }

    private void buildConstraintViolation(ConstraintValidatorContext context, String message) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation();
    }
}