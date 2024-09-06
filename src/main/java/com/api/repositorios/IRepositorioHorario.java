package com.api.repositorios;

import com.api.dominio.Horario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepositorioHorario extends JpaRepository<Horario,Long> {

}
