package com.betplay.modulos;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorEquipos {
    private ArrayList<Equipo> equipos;
    private ArrayList<Partido> partidos;

    public GestorEquipos(){
        this.equipos = new ArrayList<>();
        this.partidos = new ArrayList<>();
    }

    public int size(){
        return this.equipos.size();
    }

    public Equipo getEquipo(int index){
        return this.equipos.get(index);
    }

    public void printAll(){
        for (int i = 0; i < this.equipos.size(); i++) {
            System.out.println( (i+1) +". "+ this.equipos.get(i).getNombre());           
        }
    }

    public void aggEquipo(Scanner sc){
        System.out.println("Ingrese el nombre del equipo: \n");
        Equipo equipox = new Equipo(sc.nextLine());
        this.equipos.add(equipox);
        System.out.println(String.format("Equipo %s agregado.",equipox.getNombre()));
    }

    public void addPartido(Partido p){
        this.partidos.add(p);
    }

    public Equipo maxGoles(){
        Equipo maxGoles = equipos.get(0);
        for (Equipo equipo : equipos) {
            if(maxGoles.getGolesFavor() < equipo.getGolesFavor()){
                maxGoles = equipo;
            }
        }
        return maxGoles;
    }

    public Equipo maxPuntos(){
        Equipo maxGoles = equipos.get(0);
        for (Equipo equipo : equipos) {
            if(maxGoles.getPuntos() < equipo.getPuntos()){
                maxGoles = equipo;
            }
        }
        return maxGoles;
    }
    
    public Equipo maxWins(){
        Equipo maxGoles = equipos.get(0);
        for (Equipo equipo : equipos) {
            if(maxGoles.getPartidosGanados() < equipo.getPartidosGanados()){
                maxGoles = equipo;
            }
        }
        return maxGoles;
    }

    public int totalGoles(){
        int goles = 0;
        for (Equipo equipo : equipos) {
            goles += equipo.getGolesFavor(); 
        }
        return goles;
    }

    public int avgGoles(){
        int goles = 0 , partidos = 0;
        for (Equipo equipo : equipos) {
            partidos += equipo.getPartidosJugados();
            goles += equipo.getGolesFavor();
        }
        return ( goles/ (partidos / 2) );
    }

    public boolean cantidadPartidos(){
        if (equipos.size() == 0) {
            return false;
        }
        int mismaCantidadPartidos = equipos.get(0).getPartidosJugados();
        for (Equipo equipo : equipos) {
            if(mismaCantidadPartidos != equipo.getPartidosJugados()){
                return false;
            }
        }
        
        return true;
    }

    public void imprimirTabla() {
        System.out.println(String.format("%-15s %2s %2s %2s %2s %2s %2s %2s",
                "Equipo", "PJ", "PG", "PP", "PE", "GF", "GC", "TP"));
        System.out.println("-----------------------------------------------------");
        for (Equipo equipo : equipos) {
            System.out.println(equipo);
        }
    }
}
