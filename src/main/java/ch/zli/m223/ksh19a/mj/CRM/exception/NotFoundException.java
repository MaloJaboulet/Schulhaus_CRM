package ch.zli.m223.ksh19a.mj.CRM.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        this("");
    }

    public NotFoundException(String message) {
        super(message, null, false, false);
    }
}
