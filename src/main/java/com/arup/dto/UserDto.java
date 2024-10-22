package com.arup.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserDto implements Serializable {

    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String mobile;
}