package com.example.springbootformulario.validation;

import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RequeridoValidador implements ConstraintValidator<Requerido, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null || !StringUtils.hasText(s)) {
            return false;
        }
        return true;
    }
}
