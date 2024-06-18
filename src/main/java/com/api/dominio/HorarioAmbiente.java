package com.api.dominio;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Deprecated
@AllArgsConstructor
@Data
public class HorarioAmbiente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDate fecha;
    @Column(nullable = false)
    private LocalTime horaInicio;
    @Column(nullable = false)
    private LocalTime horaFin;



}
