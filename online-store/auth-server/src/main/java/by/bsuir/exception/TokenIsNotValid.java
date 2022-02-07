package by.bsuir.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class TokenIsNotValid extends ResponseStatusException {
    public TokenIsNotValid(HttpStatus status) {
        super(status);
    }
}
