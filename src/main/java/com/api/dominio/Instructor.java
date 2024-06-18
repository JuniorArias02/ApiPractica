package com.api.dominio;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Deprecated
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
//@EqualsAndHashCode(exclude = +)
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30,nullable = false)
    private String nombre;
    @Column(length = 30,nullable = false)
    private String apellido;
    @Column(length = 80,nullable = false)
    private String correo;
    @Column(length = 13,nullable = false)
    private Long cedula;
    @Column(length = 15,nullable = false)
    private String telefono;
    @Column(length = 90,nullable = false)
    private String direccion;

    @ManyToOne(targetEntity = Contrato.class)
    private Contrato contrato;

    @OneToOne(targetEntity = Horario.class)
    private Horario horario;

    @ManyToMany(targetEntity = ProgramaFormacion.class,fetch = FetchType.LAZY)
    List<ProgramaFormacion>listaProgramaFormacion;

    @ManyToOne(targetEntity = Centro.class,fetch = FetchType.LAZY)
    List<Centro>listaCentro;

}
