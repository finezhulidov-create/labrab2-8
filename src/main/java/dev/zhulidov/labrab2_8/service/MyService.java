package dev.zhulidov.labrab2_8.service;

import dev.zhulidov.labrab2_8.exception.UnsupportedCodeException;
import dev.zhulidov.labrab2_8.exception.ValidationFailedException;
import dev.zhulidov.labrab2_8.model.*;
import dev.zhulidov.labrab2_8.util.DateTimeUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Date;
@Slf4j
@Service
@RequiredArgsConstructor
public class MyService {

    private final ValidationInterface validationInterface;
    private final ModifyResponseService modifyResponseService;
    private final AnnualBonusService annualBonusService;

    public Response sendFeedBack(Request request, BindingResult bindingResult){
        Long start = System.currentTimeMillis();
        isValidUid(request);
        validationInterface.isValid(bindingResult);
        request.setCurrentMillis(start);
        var bonus = annualBonusService.calculate(request.getPosition(),request.getBonus(),request.getBonus(), request.getWorkDays(), request.getSystemTime().getYear());
        log.info("request: {}", request);
        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(DateTimeUtil.getCustomFormat().format(new Date()))
                .code(Codes.SUCCESS)
                .annualBonus(bonus)
                .errorCode(ErrorCodes.EMPTY)
                .errorMessage(ErrorMessages.EMPTY)
                .build();
        log.info("RESPONSE changed: {}", response.toString());
        modifyResponseService.modify(response);
        log.info("response: {}", response);
//

        return response;
    }
    private void isValidUid(Request request){
        if (request.getUid().equals("123")){
            throw new UnsupportedCodeException("UnsupportedCode");
        }
    }
}
