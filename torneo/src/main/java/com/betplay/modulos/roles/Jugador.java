package com.betplay.modulos.roles;

import com.betplay.modulos.Persona;

public class Jugador extends Persona{
    private int dorsal;
    private String posJuego;
    private String nacionalidad;
    private String fechaIngreso;
    private int golesAnotados;
    private int totalTr; //TARJETAS ROJAS
    private int totalTa; //TARJETAS AMARILLAS
    
    public Jugador(String nombre, String apellidos, int edad, String rol, int dorsal, String posJuego,
            String nacionalidad, String fechaIngreso, int golesAnotados, int totalTr, int totalTa){
        super(nombre, apellidos, edad, rol);
        this.dorsal = dorsal;
        this.posJuego = posJuego;
        this.nacionalidad = nacionalidad;
        this.fechaIngreso = fechaIngreso;
        this.golesAnotados = golesAnotados;
        this.totalTr = totalTr;
        this.totalTa = totalTa;
    }

    public int getDorsal() {
        return dorsal;
    }

    public String getPosJuego() {
        return posJuego;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public int getGolesAnotados() {
        return golesAnotados;
    }

    public int getTotalTr() {
        return totalTr;
    }

    public int getTotalTa() {
        return totalTa;
    }
}
