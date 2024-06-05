package com.betplay.modulos;

import java.util.ArrayList;

import com.betplay.modulos.cuerpos.CuerpoMedico;
import com.betplay.modulos.cuerpos.CuerpoTecnico;
import com.betplay.modulos.roles.Jugador;

public class Equipo {

    private String nombre;
    private int partidosJugados = 0;
    private int partidosGanados = 0;
    private int partidosPerdidos = 0;
    private int partidosEmpatados = 0;
    private int golesFavor = 0;
    private int golesContra = 0;
    private int puntos = 0;
    private CuerpoTecnico cuerpoTecnico;
    private CuerpoMedico cuerpoMedico;
    private ArrayList<Jugador> jugadores;
    
    public Equipo(String nombreEquipo){
        this.nombre = nombreEquipo;
    }

    public void agregarCuerpoT(CuerpoTecnico cuerpoTecnico){
        this.cuerpoTecnico = cuerpoTecnico;
    }

    public void agregarCuerpoM(CuerpoMedico cuerpoMedico){
        this.cuerpoMedico = cuerpoMedico;
    }

    public void agregarJugadores(){
        //necesarios 11 suplentes 11
        for (int i = 0; i < 11; i++) {
            
        }
    }



    public void gano(){
        this.partidosJugados++;
        this.partidosGanados++;
        this.puntos += 3;
    }
    public void perdio(){
        this.partidosPerdidos++;
        this.partidosJugados++;
    }
    public void empato(){
        this.partidosJugados++;
        partidosEmpatados++;
        this.puntos++;
    }

    public void setGolesFavor(int goles){
        this.golesFavor += goles;
    }

    public void setGolesContra(int goles){
        this.golesContra += goles;
    }

    public String print(){
        return String.format("hola");
    }
    public String getNombre(){
        return this.nombre;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public int getPartidosEmpatados() {
        return partidosEmpatados;
    }

    public int getGolesFavor() {
        return golesFavor;
    }

    public int getGolesContra() {
        return golesContra;
    }

    public int getPuntos() {
        return puntos;
    }

    @Override
    public String toString() {
        return String.format("%-15s %2d %2d %2d %2d %2d %2d %2d",
                nombre, partidosJugados, partidosGanados, partidosPerdidos, partidosEmpatados, golesFavor, golesContra, puntos);
    }
    

}
