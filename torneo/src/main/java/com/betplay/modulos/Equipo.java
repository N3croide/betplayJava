package com.betplay.modulos;

import java.util.ArrayList;
import java.util.HashMap;

import com.betplay.modulos.personas.Jugador;
import com.betplay.modulos.personas.MiembroEquipo;

public class Equipo {

    private Integer id;
    private String nombre;
    private int partidosJugados = 0;
    private int partidosGanados = 0;
    private int partidosPerdidos = 0;
    private int partidosEmpatados = 0;
    private int golesFavor = 0;
    private int golesContra = 0;
    private int puntos = 0;
    private HashMap<Integer, MiembroEquipo> cuerpoTecnico;
    private HashMap<Integer, MiembroEquipo> cuerpoMedico;
    private HashMap<Integer, Jugador> jugadores;
    
    public Equipo(String nombreEquipo){
        this.nombre = nombreEquipo;
        cuerpoTecnico = new HashMap<>();
        cuerpoMedico = new HashMap<>();
    }

    public void agregarCuerpoT(MiembroEquipo cuerpoTecnico){
        this.cuerpoTecnico.put(cuerpoTecnico.getId(), cuerpoTecnico);
    }

    public void agregarCuerpoM(MiembroEquipo cuerpoMedico){
        this.cuerpoMedico.put(cuerpoMedico.getId(), cuerpoMedico);
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

    public Integer getId() {
        return id;
    }

    public HashMap getCuerpoTecnico() {
        return cuerpoTecnico;
    }

    public HashMap getCuerpoMedico() {
        return cuerpoMedico;
    }

    public HashMap getJugadores() {
        return jugadores;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public void setPartidosGanados(int partidosGanados) {
        this.partidosGanados = partidosGanados;
    }

    public void setPartidosPerdidos(int partidosPerdidos) {
        this.partidosPerdidos = partidosPerdidos;
    }

    public void setPartidosEmpatados(int partidosEmpatados) {
        this.partidosEmpatados = partidosEmpatados;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return String.format("%-15s %2d %2d %2d %2d %2d %2d %2d",
                nombre, partidosJugados, partidosGanados, partidosPerdidos, partidosEmpatados, golesFavor, golesContra, puntos);
    }
    

}
