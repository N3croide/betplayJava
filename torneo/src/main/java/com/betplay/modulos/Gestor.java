package com.betplay.modulos;

import java.util.ArrayList;
import java.util.Scanner;

public class Gestor {
    private ArrayList<Equipo> equipos;
    private ArrayList<Partido> partidos;

    public Gestor(){
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
        while(exist(equipox.getNombre())){
            System.out.println("Ese equipo ya existe.");
            equipox = new Equipo(sc.nextLine());
        }
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
        
        ArrayList<Equipo> clone = new ArrayList<>(this.equipos);
        
        sort(clone, 0, clone.size() - 1);

        for (Equipo equipo : clone) {
            System.out.println(equipo);
        }
    }
    public boolean exist(String nombre){
        for (Equipo equipo : equipos) {
            if(nombre.equalsIgnoreCase(equipo.getNombre())){
                return true;
            }
        }

        return false;
    }

    public void sort(ArrayList<Equipo> lista, int izq, int der){
        if(izq < der){
            int partition = sortPartition(izq, der, lista);
            sort(lista, izq, partition - 1);
            sort(lista, partition + 1, der);
        }

    }

    public int sortPartition(int posInicial, int posFinal, ArrayList<Equipo> arr){
        int pivote = arr.get(posFinal).getPuntos();
        int i = posInicial;
        int j = posInicial;

        while( i <= posFinal){
            if( arr.get(i).getPuntos() >= pivote ){
                Equipo temp = arr.get(i);
                int indexi = arr.indexOf(temp);
                int indexj = arr.indexOf(arr.get(j));
                arr.set(indexi, arr.get(j));
                arr.set(indexj, temp);
                j++;
            }
            i++;
        }
        return j - 1;
    }
}
