package com.betplay.modulos.roles;
import com.betplay.modulos.Persona;

public class Tecnico extends Persona{
    private String areaEspecializacion;

    public Tecnico(String nombre, String apellidos, int edad, String rol, String areaEspecializacion) {
        super(nombre, apellidos, edad, rol);
        this.areaEspecializacion = areaEspecializacion;
    }

    public String getAreaEspecializacion() {
        return areaEspecializacion;
    }

    
    
}
