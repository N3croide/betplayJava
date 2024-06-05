package com.betplay.modulos.roles;

import com.betplay.modulos.Persona;

public class PrepFisico extends Persona{
    private Integer experiencia;
    private String areaEspecializacion;

    
    public PrepFisico(String nombre, String apellidos, int edad, String rol, Integer experiencia,
            String areaEspecializacion) {
        super(nombre, apellidos, edad, rol);
        this.experiencia = experiencia;
        this.areaEspecializacion = areaEspecializacion;
    }
}
