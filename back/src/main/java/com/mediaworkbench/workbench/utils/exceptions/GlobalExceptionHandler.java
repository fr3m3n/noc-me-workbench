package com.mediaworkbench.workbench.utils.exceptions;

import org.apache.log4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Objects;


@ControllerAdvice
public class GlobalExceptionHandler {

    private final static Logger LOGGER = Logger.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> allErrors(Exception e, WebRequest req){
        LOGGER.error(e.getMessage());

        return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CustomNotFoundException.class)
    public ResponseEntity<String> handleCustomNotFoundException(CustomNotFoundException ex) {
        LOGGER.error(ex.getMessage());

        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleJsonParseException(HttpMessageNotReadableException ex) {
        LOGGER.error(ex.getMessage());

        String errorMessage = "Invalid JSON payload: " + ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicateNiNumberException.class)
    public ResponseEntity<String> handleDuplicateNiNumberException(DuplicateNiNumberException ex) {
        LOGGER.error(ex.getMessage());

        String errorMessage = "Duplicate niNumber: " + ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicateLicenseNumberException.class)
    public ResponseEntity<String> handleDuplicateLicenseNumberException(DuplicateLicenseNumberException ex) {
        LOGGER.error(ex.getMessage());

        String errorMessage = "Duplicate licenseNumber: " + ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicateEmailException.class)
    public ResponseEntity<String> handleDuplicateEmailException(DuplicateEmailException ex) {
        LOGGER.error(ex.getMessage());

        String errorMessage = "Duplicate email: " + ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicateAppointmentException.class)
    public ResponseEntity<String> handleDuplicateAppointmentException(DuplicateAppointmentException ex) {
        LOGGER.error(ex.getMessage());

        String errorMessage = "Duplicate appointment: " + ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<String> handleInvalidCredentialsException(InvalidCredentialsException ex) {
        LOGGER.error(ex.getMessage());

        String errorMessage = "Invalid credentials: " + ex.getMessage();
        return new ResponseEntity<>(errorMessage, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(CustomDatabaseException.class)
    public ResponseEntity<String> handleCustomDatabaseException(CustomDatabaseException ex) {
        LOGGER.error("Database error: " + ex.getMessage(), ex);
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request) {
        LOGGER.error("Data integrity violation: " + ex.getMessage(), ex);
        return new ResponseEntity<>("Data integrity violation: " + Objects.requireNonNull(ex.getRootCause()).getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(CustomDataIntegrityViolationException.class)
    public ResponseEntity<String> handleCustomDataIntegrityViolationException(CustomDataIntegrityViolationException ex) {
        LOGGER.error(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }


    @ExceptionHandler(CustomValidationException.class)
    public ResponseEntity<String> handleCustomValidationException(CustomValidationException ex) {
        LOGGER.error(ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }



}
