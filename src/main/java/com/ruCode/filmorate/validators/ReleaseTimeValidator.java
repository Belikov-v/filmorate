package com.ruCode.filmorate.validators;

import com.ruCode.filmorate.anotation.ReleaseTime;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.Month;

public class ReleaseTimeValidator implements ConstraintValidator<ReleaseTime, LocalDate> {

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        return localDate.isAfter(LocalDate.of(1895, Month.DECEMBER,28));
    }
}