package dev.zhulidov.labrab2_8.controller;

import dev.zhulidov.labrab2_8.exception.UnsupportedCodeException;
import dev.zhulidov.labrab2_8.exception.ValidationFailedException;
import dev.zhulidov.labrab2_8.model.*;
import dev.zhulidov.labrab2_8.service.ModifyResponseService;
import dev.zhulidov.labrab2_8.service.ValidationInterface;
import dev.zhulidov.labrab2_8.util.DateTimeUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RestController
public class MyController {

    private final ValidationInterface validationInterface;
    private final ModifyResponseService modifyResponseService;

    @Autowired
    public MyController(ValidationInterface validationInterface,@Qualifier("ModifySystemTimeResponseService") ModifyResponseService modifyResponseService) {
        this.validationInterface = validationInterface;
        this.modifyResponseService = modifyResponseService;
    }

    @PostMapping("/feedback")
    public ResponseEntity<Response> feedBack(@RequestBody @Valid Request request, BindingResult bindingResult){

        log.info("request: {}", request);
        Response response = Response.builder()
                .uid(request.uid())
                .operationUid(request.operationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();
        log.info("RESPONSE changed: {}", response.toString());
        try{
            isValidUid(request);
            validationInterface.isValid(bindingResult);
        } catch (ValidationFailedException e) {
            log.error("Validation exception ");
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.VALIDATION_EXCEPTION);
            response.setErrorMessage(ErrorMessages.VALIDATION);
            log.info("RESPONSE changed code: {}, errCode: {}, errMess: {} ", response.getCode(),response.getErrorCode(),response.getErrorMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }catch (UnsupportedCodeException e ){
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNSUPPORTED_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNKNOWN);
            log.info("RESPONSE changed code: {}, errCode: {}, errMess: {} ", response.getCode(),response.getErrorCode(),response.getErrorMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            response.setCode(Codes.FAILED);
            response.setErrorCode(ErrorCodes.UNKNOWN_EXCEPTION);
            response.setErrorMessage(ErrorMessages.UNKNOWN);
            log.info("RESPONSE changed code: {}, errCode: {}, errMess: {} ", response.getCode(),response.getErrorCode(),response.getErrorMessage());
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
