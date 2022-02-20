package by.bsuir.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class GoogleRequestException extends ResponseStatusException {
    public GoogleRequestException(HttpStatus status) {
        super(status);
    }
}
