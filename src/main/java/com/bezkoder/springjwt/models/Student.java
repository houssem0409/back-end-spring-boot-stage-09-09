package com.bezkoder.springjwt.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue(value="ROLE_STUDENT")
public class Student extends User{

    private String Matricul;
    @ManyToOne
    ClassRoom classRoom;
    @ManyToOne
    Parent parent;
}
