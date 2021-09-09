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
@DiscriminatorValue(value="TCH")
public class Teacher extends User{

    private String Speciality;
    @OneToMany(mappedBy = "teacher",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    List<Evaluation> evaluations;
    @ManyToOne
    Course course;
}
