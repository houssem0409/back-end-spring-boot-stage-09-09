package com.bezkoder.springjwt.models;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue(value="ROLE_PARENT")
public class Parent extends User{
    private int numCin;
    @OneToMany(mappedBy = "parent")
    List<Student> students;
    @OneToMany(mappedBy = "parent",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    List<Evaluation> evaluations;

}
