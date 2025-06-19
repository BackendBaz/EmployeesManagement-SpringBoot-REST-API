package io.github.backendbaz.employees.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> notFound(EmployeeNotFoundException
                                                                    exception) {
        EmployeeErrorResponse response = new EmployeeErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "Not Found",
                exception.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<EmployeeErrorResponse> methodValidation() {
        EmployeeErrorResponse response = new EmployeeErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                "There is a validation error in the request",
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<EmployeeErrorResponse> argumentTypeMismatch() {
        EmployeeErrorResponse response = new EmployeeErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                "Type of argument is not valid",
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<EmployeeErrorResponse> emptyBodyNotReadable() {
        EmployeeErrorResponse response = new EmployeeErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                "Required request body is missing",
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<EmployeeErrorResponse> bodyArgumentNotValid() {
        EmployeeErrorResponse response = new EmployeeErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                "There is an invalid body",
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
