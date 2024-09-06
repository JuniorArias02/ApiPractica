package com.api.servicios;

import com.api.dominio.Instructor;
import org.aspectj.apache.bcel.generic.Instruction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IServicioInstructor {
    List<Instructor> listarInstructor();

    Instructor buscarInstructorPorId(Long id);

    Instructor guardarInstructor(Instructor instructor);
}
