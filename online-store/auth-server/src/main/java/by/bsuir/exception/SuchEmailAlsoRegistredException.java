package by.bsuir.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class SuchEmailAlsoRegistredException extends ResponseStatusException {
    public SuchEmailAlsoRegistredException(HttpStatus status) {
        super(status);
    }
}
