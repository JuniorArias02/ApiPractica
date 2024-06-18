package com.api.controlador;

import com.api.dominio.Coordinador;
import com.api.servicios.ServicioCoordinador;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api-coordinador")
public class ControladorCoordinador {

    public static final Logger logger = LoggerFactory.getLogger(ControladorCoordinador.class);

    @Autowired
    private ServicioCoordinador servicioCoordinador;

    @GetMapping("/coordinador")
    public List<Coordinador> listaCoordinador() {
        List<Coordinador> listaCoordinadores = this.servicioCoordinador.listaCoordinador();
        logger.info("lista de coordinadores obtenidas");
        listaCoordinadores.forEach(coordinador -> logger.info(coordinador.toString()));
        return listaCoordinadores;
    }

    @GetMapping("/coordinador/{id}")
    Coordinador buscarCoordinadorPorId(@PathVariable Long id) {
        Coordinador coordinadorEncontrado = this.servicioCoordinador.buscarCoordinadorPorId(id);
        logger.info("coordinador encontrado");
        return coordinadorEncontrado;
    }

    @PostMapping("coordinador")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void guardarCoordinador(@RequestBody Coordinador coordinador) {
        this.servicioCoordinador.guardadCoordinador(coordinador);
    }

    @PostMapping("/coordinadorDelete/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void eliminarCoordinador(@PathVariable Long id) {
        this.servicioCoordinador.eliminarCoordinador(id);
    }

    @PutMapping("coordinadorUpdate/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Coordinador actualizarCoordinador(@PathVariable Long id, @RequestBody Coordinador coordinador)  {
        Coordinador coordinadorEncontrado = this.servicioCoordinador.buscarCoordinadorPorId(id);
        if (coordinadorEncontrado == null) {
            throw new RuntimeException();
        }
        coordinadorEncontrado.setNombre(coordinador.getNombre());
        coordinadorEncontrado.setApellido(coordinador.getApellido());
        coordinadorEncontrado.setCorreo(coordinador.getCorreo());
        coordinadorEncontrado.setCedula(coordinador.getCedula());
        coordinadorEncontrado.setTelefono(coordinador.getTelefono());
        coordinadorEncontrado.setListaHorario(coordinador.getListaHorario());
        this.servicioCoordinador.guardadCoordinador(coordinadorEncontrado);
        return coordinadorEncontrado;
    }

}
