package com.api.servicios;


import com.api.dominio.Coordinador;

import java.util.List;

public interface IServicioCoordinador {

    List<Coordinador> listaCoordinador();

    Coordinador buscarCoordinadorPorId(Long id);

    void guardadCoordinador(Coordinador coordinador);

    void eliminarCoordinador( Long id);


}
