package com.bezkoder.springjwt.dto;

import com.bezkoder.springjwt.models.Roles;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class UserDTO {
    private Long id;

    private String username;

    private String email;

    private String password;

    private Set<Roles> roles = new HashSet<>();
}
