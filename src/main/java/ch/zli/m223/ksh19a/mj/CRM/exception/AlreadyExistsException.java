package ch.zli.m223.ksh19a.mj.CRM.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException() {
        this("");
    }

    public AlreadyExistsException(String message) {
        super(message, null, false, false);
    }
}
