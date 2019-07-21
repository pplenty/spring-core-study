package com.jason.springcorestudy.supports;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Slf4j
@Component
public class KeywordValidator implements Validator {

//    @Override
//    public void initialize(AlarmKeywordConstraint constraintAnnotation) {
//        log.error("constraintAnnotation : {}", constraintAnnotation);
//    }
//
//    @Override
//    public boolean isValid(String keyword, ConstraintValidatorContext context) {
//
//        log.error("keyword : {}", keyword);
//        log.error("context : {}", context);
//        log.error("context : {}", context.getDefaultConstraintMessageTemplate());
//        return true;
//    }

    @Override
    public boolean supports(Class<?> clazz) {
        System.out.println(clazz);
        return IndexParameters.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        IndexParameters parameters = (IndexParameters) target;

        if (parameters.getRank() > 1) {
            errors.rejectValue("rank", "larger than 1");
        }

        System.out.println(target);
        System.out.println(errors);
    }
}