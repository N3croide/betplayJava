package com.betplay.modulos.roles;
import com.betplay.modulos.Persona;

public class AsistTecnico extends Persona{
    private String funcion;

    public AsistTecnico(String nombre, String apellidos, int edad, String rol, String funcion) {
        super(nombre, apellidos, edad, rol);
        this.funcion = funcion;
    }

    
}
