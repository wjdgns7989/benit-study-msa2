package com.benit.svc2.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class UserDto {

    private String name;
    private String phoneNumber;
    private String address;
    private int age;
}
