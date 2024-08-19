package com.ruCode.filmorate.validators;

import com.ruCode.filmorate.anotation.SpaceContains;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class SpaceContainsValidator implements ConstraintValidator<SpaceContains, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return !(s.contains(" "));
    }
}
