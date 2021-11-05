package com.bezkoder.springjwt.dto;


import com.bezkoder.springjwt.models.ERole;
import lombok.Data;

@Data
public class RoleDTO {

    private Long id;
    private ERole name;
}
