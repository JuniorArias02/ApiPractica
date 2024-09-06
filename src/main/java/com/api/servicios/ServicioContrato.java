package com.api.servicios;

import com.api.repositorios.IRepositorioContrato;
import org.springframework.beans.factory.annotation.Autowired;

public class ServicioContrato implements IServiciosContrato{

    @Autowired
    private IRepositorioContrato iRepositorioContrato;





}
