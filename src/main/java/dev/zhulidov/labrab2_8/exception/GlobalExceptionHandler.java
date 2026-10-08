package dev.zhulidov.labrab2_8.exception;

import dev.zhulidov.labrab2_8.model.Codes;
import dev.zhulidov.labrab2_8.model.ErrorCodes;
import dev.zhulidov.labrab2_8.model.ErrorMessages;
import dev.zhulidov.labrab2_8.model.Response;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationFailedException.class)
    public ResponseEntity<Response> handleValidationErrors(MethodArgumentNotValidException ex){
        log.error("Validation exception ");
        Response body = Response.builder()
                .code(Codes.FAILED)
                .errorCode(ErrorCodes.VALIDATION_EXCEPTION)
                .errorMessage(ErrorMessages.VALIDATION)
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
    @ExceptionHandler(UnsupportedCodeException.class)
    public ResponseEntity<Response> handleUnsupportedCodeErrors(MethodArgumentNotValidException ex){

        Response body = Response.builder()
                .code(Codes.FAILED)
                .errorCode(ErrorCodes.UNSUPPORTED_EXCEPTION)
                .errorMessage(ErrorMessages.UNKNOWN)
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response> handleUnknownErrors(MethodArgumentNotValidException ex){

        Response body = Response.builder()
                .code(Codes.FAILED)
                .errorCode(ErrorCodes.UNKNOWN_EXCEPTION)
                .errorMessage(ErrorMessages.UNKNOWN)
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }


}
