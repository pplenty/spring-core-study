package com.jason.springcorestudy.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by kohyusik on 05/11/2019.
 */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {CustomConstraintValidator.class})
public @interface CustomConstraint {

    String message() default "~ 는 필수 입니다.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
