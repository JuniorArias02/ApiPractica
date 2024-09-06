package com.api.dominio;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Deprecated
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDate fechaInicio;
    @Column(nullable = false)
    private LocalDate fechaFin;
    @Column(nullable = false)
    private LocalTime horaInicio;
    @Column(nullable = false)
    private LocalTime horaFin;


    @ManyToOne(targetEntity = Coordinador.class)
    private Coordinador coordinador;

    @OneToOne(targetEntity = Instructor.class, fetch = FetchType.LAZY, mappedBy = "horario")
    List<Instructor> horarioInstructor;


}
