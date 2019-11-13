package com.jason.springcorestudy.validator;

import com.jason.springcorestudy.validator.dto.Person;
import com.jason.springcorestudy.validator.dto.PersonGroups;
import lombok.extern.slf4j.Slf4j;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kohyusik on 06/11/2019.
 */
@Slf4j
public class ValidatorTest {

    private static ValidatorFactory factory;
    private static Validator validator;

    @BeforeClass
    public static void init() {
        factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        log.debug("factory : {}", factory);
        log.debug("validator : {}", validator);
    }

    @Test
    public void singleGroup() {

        // given
        Person person = Person.builder()
                .name("k")
                .age(12)
                .build();

        // when
        Set<ConstraintViolation<Person>> constraintViolations =
                validator.validate(person, PersonGroups.Driver.class);

        // then
        log.debug("size : {}", constraintViolations.size());
        constraintViolations.forEach(violation -> log.debug("violation : {}", violation));

        assertThat(constraintViolations).hasSize(2);

    }

    @Test
    public void bothGroup() {

        // given
        Person person = Person.builder()
                .name("k")
                .age(12)
                .build();

        // when
        Set<ConstraintViolation<Person>> constraintViolations =
                validator.validate(person, PersonGroups.Driver.class, PersonGroups.Adult.class);

        // then
        log.debug("size : {}", constraintViolations.size());
        constraintViolations.forEach(violation -> log.debug("violation : {}", violation));

        assertThat(constraintViolations).hasSize(4);

    }

    @Test
    public void name() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4);
        System.out.println(list.size());
        List<Integer> list2 = list.stream()
                .limit(20)
                .sorted(Comparator.comparingInt(Object::hashCode).reversed())
                .collect(Collectors.toList());
        System.out.println(list2);
        System.out.println(list2.size());
    }
}