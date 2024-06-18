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
public class Ambiente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;

    @OneToOne(targetEntity = HorarioAmbiente.class,fetch = FetchType.LAZY)
    List<HorarioAmbiente>listaHorarioAmbiente;

}
