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
public class ProgramaFormacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30,nullable = false)
    private String nombre;

    @OneToMany(targetEntity = Aprendiz.class, fetch = FetchType.LAZY, mappedBy = "programaFormacion")
    List<Aprendiz> ListaAprendiz;

    @ManyToOne(targetEntity = Ambiente.class, fetch = FetchType.LAZY)
    List<Ambiente> listaAmbiente;

    @JoinTable(name = "programaCompetencia")
    @ManyToMany(targetEntity = Competencias.class, fetch = FetchType.LAZY)
    List<Competencias> listaCompetencias;


}
