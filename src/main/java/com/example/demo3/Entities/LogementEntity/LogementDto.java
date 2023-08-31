package com.example.demo3.Entities.LogementEntity;

import lombok.Data;

import java.util.Date;
@Data
public class LogementDto {
    private String title;
    private String description;
    private String adresse;
    private Date startdate;
    private Date enddate;
}
