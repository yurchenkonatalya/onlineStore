package by.bsuir.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserIsNotRegisteredException extends ResponseStatusException {

    public UserIsNotRegisteredException(HttpStatus status) {
        super(status);
    }
}
