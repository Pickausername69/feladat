package hu.orszaggyules.feladat.web.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = UniqueSzavazatValidator.class)
public @interface UniqueSzavazat {
    String message() default "List contains duplicate Szavazat";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
