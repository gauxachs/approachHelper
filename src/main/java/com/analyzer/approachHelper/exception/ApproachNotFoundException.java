package com.analyzer.approachHelper.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ApproachNotFoundException extends RuntimeException {

    public ApproachNotFoundException(String message) {
        super(message);
    }
}
