package com.ruCode.filmorate.anotation;

import com.ruCode.filmorate.validators.ReleaseTimeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {ReleaseTimeValidator.class})
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ReleaseTime {
    String message() default "{jakarta.validation.constraints.ReleaseTime.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
