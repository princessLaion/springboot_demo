package com.lrp.springboot.learn_spring_boot.handler;

import com.lrp.springboot.learn_spring_boot.error.ErrorDetail;
import com.lrp.springboot.learn_spring_boot.exception.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * For all of the Exceptions.
     */
    @ExceptionHandler({Exception.class})
    public final ResponseEntity<ErrorDetail> handleCustomException(Exception ex, WebRequest request) {
        return new ResponseEntity<ErrorDetail>(
                getErrorDetail(ex.getMessage(), request),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    /**
     * For UserNotFoundException only.
     */
    @ExceptionHandler({UserNotFoundException.class})
    public final ResponseEntity<ErrorDetail> handleUserCustomException(Exception ex, WebRequest request) {
        return new ResponseEntity<ErrorDetail>(
                getErrorDetail(ex.getMessage(), request),
                HttpStatus.NOT_FOUND
        );
    }

    private ErrorDetail getErrorDetail(String errMsg, WebRequest request) {
        return ErrorDetail.builder()
                .localDateTime(LocalDateTime.now())
                .message(errMsg)
                .description(request.getDescription(false))
                .build();

    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String errMsg = ex.getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining(", "));

        return new ResponseEntity(
                getErrorDetail(errMsg, request),
                HttpStatus.BAD_REQUEST
        );

    }
}