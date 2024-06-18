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
public class Competencias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 120,nullable = false)
    private String nombre;
}
