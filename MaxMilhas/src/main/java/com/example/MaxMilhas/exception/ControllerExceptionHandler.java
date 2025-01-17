package com.example.MaxMilhas.exception;

import com.example.MaxMilhas.domain.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ExistsCpfException.class)
    public ResponseEntity<ExceptionDTO> handleExistsCpf(ExistsCpfException e) {
        ExceptionDTO exception = new ExceptionDTO(e.getMessage(), "409");
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exception);
    }

    @ExceptionHandler(NotFoundCpfException.class)
    public ResponseEntity<ExceptionDTO> handleNotFoundCpf(NotFoundCpfException e) {
        ExceptionDTO exception = new ExceptionDTO(e.getMessage(), "404");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception);
    }

    @ExceptionHandler(InvalidCpfException.class)
    public ResponseEntity<ExceptionDTO> handleInvalidCpf(InvalidCpfException e) {
        ExceptionDTO exception = new ExceptionDTO(e.getMessage(), "400");
        return ResponseEntity.badRequest().body(exception);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDTO> handleGenericException(Exception e) {
        ExceptionDTO exception = new ExceptionDTO("Unexpected error", "500");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception);
    }
}
