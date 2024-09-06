package com.api.servicios;

import com.api.dominio.Horario;

import java.util.List;

public interface IServicioHorario {

    List<Horario> listaHorario();

    Horario buscarHorario(Long id);

    void guardadHorario(Horario horario);

    void eliminarHorario(Long id);


}
