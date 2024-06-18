package com.api.dominio;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Deprecated
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Centro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30,nullable = false)
    private String nombre;
    @Column(length = 300,nullable = false)
    private String descripcion;



}
