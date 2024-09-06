package com.api.repositorios;

import com.api.dominio.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositorioContrato extends JpaRepository<Contrato,Long> {
}
