package com.betplay.modulos;

public class Persona {
    private String nombre;
    private String apellidos;
    private int edad;
    private String rol;

    public Persona(){}

    public Persona(String nombre, String apellidos, int edad, String rol){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public String getRol() {
        return rol;
    }
}

