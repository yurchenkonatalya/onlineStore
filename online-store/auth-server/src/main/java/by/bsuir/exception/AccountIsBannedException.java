package by.bsuir.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AccountIsBannedException extends ResponseStatusException {
    public AccountIsBannedException(HttpStatus status) {
        super(status);
    }
}
