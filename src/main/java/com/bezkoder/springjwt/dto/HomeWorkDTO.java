package com.bezkoder.springjwt.dto;

import lombok.Data;

import java.util.Date;

@Data
public class HomeWorkDTO {
    private Long idHomeWork;
    private Date endDate;
    private Date startDate;
    private Long courseIdCourse;


}
