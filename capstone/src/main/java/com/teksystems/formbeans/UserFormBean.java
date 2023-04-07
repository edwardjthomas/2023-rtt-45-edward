package com.teksystems.formbeans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserFormBean {

    private Integer id;

    private String username;

    private String password;

    private String name;

    private String email;

    private String preferredContact;
}
