package dev.zhulidov.labrab2_8.controller;

import dev.zhulidov.labrab2_8.exception.UnsupportedCodeException;
import dev.zhulidov.labrab2_8.exception.ValidationFailedException;
import dev.zhulidov.labrab2_8.model.Request;
import dev.zhulidov.labrab2_8.model.Response;
import dev.zhulidov.labrab2_8.service.ValidationInterface;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequiredArgsConstructor
public class MyController {

    private final ValidationInterface validationInterface;



    @PostMapping("/feedback")
    public ResponseEntity<Response> feedBack(@RequestBody @Valid Request request, BindingResult bindingResult){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.$$$'Z'");

        Response response = Response.builder()
                .uid(request.uid())
                .operationUid(request.operationUid())
                .systemTime(simpleDateFormat.format(new Date()))
                .code("success")
                .errorCode("")
                .errorMessage("")
                .build();
        try{
            isValidUid(request);
            validationInterface.isValid(bindingResult);
        } catch (ValidationFailedException e) {
            response.setCode("failed");
            response.setErrorCode("ValidationException");
            response.setErrorMessage("Ошибка валидации");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }catch (UnsupportedCodeException e ){
            response.setCode("failed");
            response.setErrorCode("UnsupportedCode");
            response.setErrorMessage("Ошибка кода");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            response.setCode("failed");
            response.setErrorCode("UnknownException");
            response.setErrorMessage("Неизвестная ошибка");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(response);

    }
    private void isValidUid(Request request){
        if (request.uid().equals("123")){
            throw new UnsupportedCodeException("UnsupportedCode");
        }
    }
}
