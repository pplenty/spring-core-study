package com.jason.springcorestudy.validator.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.*;
import java.util.List;

@Builder
@Getter
public class Person {

    @NotEmpty(message = "이름이 있어야 합니다.")
    private String name;

    @Positive(message = "나이는 0 이상이어야 합니다.")
    @Min(value = 18, message = "운전자의 나이는 18세 이상이어야 합니다.", groups = PersonGroups.Driver.class)
    private int age;

    @NotEmpty(message = "운전자는 운전면허번호가 있어야 합니다.", groups = PersonGroups.Driver.class)
    private String driverLicenseNumber;

    @Negative(message = "잔고는 0 이하", groups = PersonGroups.Adult.class)
    private int amount;

    @NotEmpty(message = "자식이 있어야 합니다.", groups = PersonGroups.Adult.class)
    private List<String> children;
}