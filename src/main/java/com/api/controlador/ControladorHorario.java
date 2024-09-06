package com.api.controlador;

import com.api.dominio.Horario;
import com.api.dominio.HorarioAmbiente;
import com.api.servicios.ServicioHorario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api-horario")
public class ControladorHorario {

    public static final Logger logger = LoggerFactory.getLogger(ControladorHorario.class);

    @Autowired
    private ServicioHorario servicioHorario;

    @GetMapping("/horario")
    public List<Horario> listarHorario(){
        List<Horario>listaHorarios = this.servicioHorario.listaHorario();
        logger.info("Lista de coordinadores obtenidas");
        listaHorarios.forEach(horario -> logger.info(horario.toString()));
        return listaHorarios;
    }


    @GetMapping("/buscarHorario/{id}")
    Horario buscarHorario(@PathVariable Long id){
        Horario horarioEncontrado = this.servicioHorario.buscarHorario(id);
        logger.info("horario encontrado");
        return horarioEncontrado;
    }

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void guardarHorario (@RequestBody Horario horario){
        this.servicioHorario.guardadHorario(horario);
    }

    @PostMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void eliminarHorario(@PathVariable Long id){
        this.servicioHorario.eliminarHorario(id);
    }


    @PostMapping("/actualizar")
    @ResponseStatus(HttpStatus.ACCEPTED)
    Horario actualizarHorario (@PathVariable Long id,@RequestBody Horario horario){
        Horario horarioEncontrado = this.servicioHorario.buscarHorario(id);

        if (horarioEncontrado == null){
            throw new RuntimeException();
        }

        horarioEncontrado.setFechaInicio(horario.getFechaInicio());
        horarioEncontrado.setFechaFin(horario.getFechaFin());
        horarioEncontrado.setHoraInicio(horario.getHoraInicio());
        horarioEncontrado.setHoraFin(horario.getHoraFin());
        this.servicioHorario.guardadHorario(horarioEncontrado);
        return horarioEncontrado;
    }



}
