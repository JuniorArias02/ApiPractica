package com.api.servicios;

import com.api.dominio.Horario;
import com.api.repositorios.IRepositorioHorario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioHorario implements IServicioHorario {

    @Autowired
    private IRepositorioHorario iRepositorioHorario;

    @Override
    public List<Horario> listaHorario() {
        return this.iRepositorioHorario.findAll();
    }

    @Override
    public Horario buscarHorario(Long id) {
        return this.iRepositorioHorario.findById(id).orElse(null);
    }

    @Override
    public void guardadHorario(Horario horario) {
        this.iRepositorioHorario.save(horario);
    }

    @Override
    public void eliminarHorario(Long id) {
        this.iRepositorioHorario.deleteById(id);
    }
}
