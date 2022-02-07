package by.bsuir.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NonActiveAccountException extends ResponseStatusException {
    public NonActiveAccountException(HttpStatus status) {
        super(status);
    }
}
