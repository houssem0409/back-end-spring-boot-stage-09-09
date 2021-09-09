package com.bezkoder.springjwt.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity

@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue(value="ROLE_ADMIN")
public class Admin extends User {
}
