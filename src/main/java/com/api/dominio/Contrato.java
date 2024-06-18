package com.api.dominio;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Deprecated
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String tipo;
    @Column(nullable = false)
    private Double valor;
    @Column(nullable = false)
    private LocalDate fecha;

    @OneToOne(targetEntity = ActaInicio.class)
    private ActaInicio actaInicio;

    @OneToMany(targetEntity = Instructor.class, fetch = FetchType.LAZY, mappedBy = "contrato")
    List<Instructor> listaInstructor;
}
