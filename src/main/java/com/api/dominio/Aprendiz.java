package com.api.dominio;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Deprecated
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Aprendiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30, nullable = false)
    private String nombre;
    @Column(length = 30, nullable = false)
    private String apellido;
    @Column(length = 60, nullable = false)
    private String correo;
    @Column(length = 11, nullable = false)
    private Long cedula;
    @Column(length = 15, nullable = false)
    private String telefono;

    @ManyToMany(targetEntity = CursoComplementario.class, fetch = FetchType.LAZY)
    @JoinTable(name = "aprendizCurso")
    List<CursoComplementario> listCursoComplementarios;

    @ManyToOne(targetEntity = ProgramaFormacion.class)
    private ProgramaFormacion programaFormacion;
}
