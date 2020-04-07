package com.jason.springcorestudy.validator;

import com.jason.springcorestudy.controller.ValidationController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by kohyusik on 06/11/2019.
 */
@Slf4j
public class CustomConstraintValidator implements ConstraintValidator<CustomConstraint, ValidationController.RequestDto> {

    @Override
    public void initialize(CustomConstraint constraintAnnotation) {
        log.debug("groups : {}", constraintAnnotation.groups());
        log.debug("message : {}", constraintAnnotation.message());
        log.debug("payload : {}", constraintAnnotation.payload());
    }

    @Override
    public boolean isValid(ValidationController.RequestDto value, ConstraintValidatorContext context) {
        log.debug("names : {}", value.getNames());

        return !CollectionUtils.isEmpty(value.getIds());
    }
}
