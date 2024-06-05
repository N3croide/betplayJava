package com.betplay.modulos.roles;
import com.betplay.modulos.Persona;

public class Medico extends Persona{
    private String nivelEducacion;
    private String especialidad;
    
    public Medico(String nombre, String apellidos, int edad, String rol, String nivelEducacion, String especialidad) {
        super(nombre, apellidos, edad, rol);
        this.nivelEducacion = nivelEducacion;
        this.especialidad = especialidad;
    }

}
