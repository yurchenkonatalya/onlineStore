package by.bsuir.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ActivationKeyIsNotExist extends ResponseStatusException {
    public ActivationKeyIsNotExist(HttpStatus status) {
        super(status);
    }
}
