package dev.zhulidov.labrab2_8.service;

import org.springframework.validation.BindingResult;

public interface ValidationInterface {
    void isValid(BindingResult result);
}
