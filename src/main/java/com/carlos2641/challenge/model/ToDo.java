package com.carlos2641.challenge.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
@Entity(name = "todo")
//  Esta clases es el modelo que se usara para los EndPoints
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_todo;

    @Column(length = 250, nullable = false)
    private String description;

    @Column(nullable = false)
    private Date date;

    @Column(length = 50)
    private String status;  // pendiente - en progreso - completado
}
