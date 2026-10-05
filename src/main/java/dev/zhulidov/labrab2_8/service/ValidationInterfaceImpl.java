package dev.zhulidov.labrab2_8.service;

import dev.zhulidov.labrab2_8.exception.UnsupportedCodeException;
import dev.zhulidov.labrab2_8.exception.ValidationFailedException;
import dev.zhulidov.labrab2_8.model.Request;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
@Component
@Primary
public class ValidationInterfaceImpl implements ValidationInterface{
    @Override
    public void isValid(BindingResult result) {

        if (result.hasErrors()){
            throw new ValidationFailedException(result.getFieldError().toString());
        }
    }


}
