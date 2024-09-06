package com.api.repositorios;

import com.api.dominio.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepositorioInstructor extends JpaRepository<Instructor,Long> {

}
