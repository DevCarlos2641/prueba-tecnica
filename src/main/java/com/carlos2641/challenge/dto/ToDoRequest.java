package com.carlos2641.challenge.dto;

import lombok.Data;

@Data
public class ToDoRequest {
    private String description;
    private String date;
    private String status;  // pendiente - en progreso - completado
}
