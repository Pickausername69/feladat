package hu.orszaggyules.feladat.web;

import hu.orszaggyules.feladat.service.domain.JelenletiSzavazasNotFoundException;
import hu.orszaggyules.feladat.web.domain.exception.ElnokNemSzavazottException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionHandler
        extends ResponseEntityExceptionHandler {

    private class JsonResponse {
        String message;

        public JsonResponse() {
        }

        public JsonResponse(String message) {
            super();
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    @ExceptionHandler(value
            = {ElnokNemSzavazottException.class, IllegalArgumentException.class})
    protected ResponseEntity<JsonResponse> handleSaveErrors(RuntimeException e) {
        return new ResponseEntity<>(new JsonResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = EntityNotFoundException.class)
    protected ResponseEntity<JsonResponse> handleNotFound(EntityNotFoundException e) {
        return new ResponseEntity<>(new JsonResponse("Searched entity not found!"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = JelenletiSzavazasNotFoundException.class)
    protected ResponseEntity<JsonResponse> handleJelenletiSzavazasNotFoundException(JelenletiSzavazasNotFoundException e) {
        return new ResponseEntity<>(new JsonResponse("No jelenleti szavazas found!"), HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();

        Map<String, String> errors = new HashMap<>();
        for (FieldError fieldError : fieldErrors) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return ResponseEntity.badRequest().body(errors);
    }
}
