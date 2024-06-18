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
public class ActaInicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDate fecha;
    @Column(length = 300,nullable = false)
    private String descripcion;

    @OneToOne(targetEntity = Contrato.class, fetch = FetchType.LAZY, mappedBy = "actaInicio")
    List<Contrato> listaContrato;

}
