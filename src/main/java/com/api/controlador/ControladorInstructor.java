package com.api.controlador;

import com.api.dominio.Horario;
import com.api.dominio.Instructor;
import com.api.servicios.ServicioInstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api-instructor")
public class ControladorInstructor {

    private static final Logger logger = LoggerFactory.getLogger(ServicioInstructor.class);

    @Autowired
    private ServicioInstructor servicioInstructor;

    @GetMapping("instructor")
    public List<Instructor> listarInstructor() {
        List<Instructor> listaInstructor = this.servicioInstructor.listarInstructor();
        logger.info("listado de instructores registrado");
        listaInstructor.forEach(instructor -> logger.info(instructor.toString()));
        return listaInstructor;
    }

    @PostMapping("buscar/{id}")
    public Instructor buscarInstructor(@PathVariable Long id) {
        Instructor instructorEncontrado = this.servicioInstructor.buscarInstructorPorId(id);
        logger.info("se ha encontrado el instructor");
        return instructorEncontrado;
    }



    @PostMapping("crear")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void guardarInstructor(@RequestBody Instructor instructor) {
        this.servicioInstructor.guardarInstructor(instructor);
    }

    @PostMapping("/actualizar")
    @ResponseStatus(HttpStatus.ACCEPTED)
    Instructor actualizarHorario (@PathVariable Long id, @RequestBody Instructor instructor){
        Instructor instructorEncontrado = this.servicioInstructor.buscarInstructorPorId(id);

        if (instructorEncontrado == null){
            throw new RuntimeException();
        }

        instructorEncontrado.setNombre(instructor.getNombre());
        instructorEncontrado.setApellido(instructor.getApellido());
        instructorEncontrado.setCorreo(instructor.getCorreo());
        instructorEncontrado.setCedula(instructor.getCedula());
        instructorEncontrado.setTelefono(instructor.getTelefono());
        instructorEncontrado.setDireccion(instructor.getDireccion());
        instructorEncontrado.setContrato(instructor.getContrato());
        instructorEncontrado.setHorario(instructor.getHorario());

        this.servicioInstructor.guardarInstructor(instructorEncontrado);
        return instructorEncontrado;
    }

}
