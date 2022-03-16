package by.bsuir.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class TokenIsNotValidException extends ResponseStatusException {
    public TokenIsNotValidException(HttpStatus status) {
        super(status);
    }
}
