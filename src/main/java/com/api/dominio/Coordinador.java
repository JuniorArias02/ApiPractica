package com.api.dominio;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Deprecated
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Coordinador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 25, name = "nombre", nullable = false)
    private String nombre;
    @Column(length = 30, name = "apellido", nullable = false)
    private String apellido;
    @Column(length = 30, name = "email", unique = true, nullable = false)
    private String correo;
    @Column(length = 11, name = "cedula", unique = true, nullable = false)
    private Long cedula;
    @Column(length = 15, name = "telefono", unique = true, nullable = false, columnDefinition = "Long")
    private Long telefono;


    @OneToMany(targetEntity = Horario.class,fetch = FetchType.LAZY,mappedBy = "coordinador")
    List<Horario> listaHorario;


}
