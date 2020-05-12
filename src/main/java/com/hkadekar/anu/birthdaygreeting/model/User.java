package com.hkadekar.anu.birthdaygreeting.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class User {
    private Long userId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String email;
}
