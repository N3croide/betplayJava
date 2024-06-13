package com.betplay.modulos.personas;

public abstract class Persona {
    private String nombre;
    private String apellidos;
    private int edad;
    private Rol rol;
    private Integer id;


    public Persona(){}

    public Persona(String nombre, String apellidos, int edad, Rol rol){
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

    public Rol getRol() {
        return rol;
    }

    public Integer getId() {
        return id;
    }

    public String getNombreCompleto(){
        return this.nombre +" "+ this.apellidos;
    }
}

