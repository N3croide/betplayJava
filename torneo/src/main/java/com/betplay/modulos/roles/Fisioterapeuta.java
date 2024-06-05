package com.betplay.modulos.roles;
import com.betplay.modulos.Persona;

public class Fisioterapeuta extends Persona{
    private String especialidad;

    public Fisioterapeuta(String nombre, String apellidos, int edad, String rol, String especialidad) {
        super(nombre, apellidos, edad, rol);
        this.especialidad = especialidad;
    }
}
