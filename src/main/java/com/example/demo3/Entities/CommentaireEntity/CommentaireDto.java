package com.example.demo3.Entities.CommentaireEntity;

import lombok.Data;

import java.util.Date;
@Data

public class CommentaireDto {
    private String text;
    private Date sendDate;

    private boolean seen;
}
