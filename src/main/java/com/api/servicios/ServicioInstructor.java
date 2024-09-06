package com.api.servicios;

import com.api.dominio.Instructor;
import com.api.repositorios.IRepositorioInstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioInstructor implements IServicioInstructor {

    @Autowired
    private IRepositorioInstructor iRepositorioInstructor;

    @Override
    public List<Instructor> listarInstructor() {
        return this.iRepositorioInstructor.findAll();
    }

    @Override
    public Instructor buscarInstructorPorId(Long id) {
        return this.iRepositorioInstructor.findById(id).orElse(null);
    }

    @Override
    public Instructor guardarInstructor(Instructor instructor) {
        return this.iRepositorioInstructor.save(instructor);
    }


}
