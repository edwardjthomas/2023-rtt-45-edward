package com.teksystems.formbeans;

import jakarta.persistence.Column;

public class UserFormBean {

    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "preferred_contact")
    private String preferredContact;
}
