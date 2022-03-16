package by.bsuir.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EmailIsNotActivatedException extends ResponseStatusException {
    public EmailIsNotActivatedException(HttpStatus status) {
        super(status);
    }
}
