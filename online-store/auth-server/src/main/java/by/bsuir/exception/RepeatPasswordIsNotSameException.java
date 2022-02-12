package by.bsuir.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class RepeatPasswordIsNotSameException extends ResponseStatusException {
    public RepeatPasswordIsNotSameException(HttpStatus status) {
        super(status);
    }
}
