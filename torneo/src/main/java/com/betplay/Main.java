package com.betplay;
import java.util.Scanner;

import com.betplay.modulos.Equipo;
import com.betplay.modulos.Partido;
import com.betplay.modulos.GestorEquipos;

public class Main {
    public static void main(String[] args) {
        
        GestorEquipos equipos = new GestorEquipos();

        System.out.println("\nBienvenido a la liga de betPlay");

        Scanner sc = new Scanner(System.in);
        while (true) {
            
            menus();
            int opt = validarInt(sc);
            if(opt == 1 )
            {
                equipos.aggEquipo(sc);
            }
            else if(opt == 2)
            {   
                if(equipos.size() >= 2)
                {
                    partido(sc, equipos);
                }else System.out.println("Tiene que haber mas de dos equipos registrados.");
            }
            else if(opt == 3)
            {
                if(!equipos.cantidadPartidos()){
                    System.out.println("La cantidad de partidos no es la misma,"+
                    " por lo que no estan todas la estadisticas aun.\nPresione Enter para continuar");
                    sc.nextLine();
                }
                else
                {
                    boolean secondMenu = true;
                    while (secondMenu) {
                        menus2();
                        opt = validarInt(sc);
                        switch (opt) {
                            case 1:
                                equipoMasGolesF(equipos);
                                break;
                        
                            case 2:
                                equipoMasPuntos(equipos);
                                break;
                        
                            case 3:
                                equipoMasWins(equipos);
                                break;
                        
                            case 4:
                                totalGoles(equipos);
                                break;
                        
                            case 5:
                                promeidoGoles(equipos);
                                break;
                        
                            case 0:
                                secondMenu = false;
                                break;
                        
                            default:
                            System.out.println("Ingrese una opcion correcta.");
                                break;
                        }
                    }
                }
            }
            else if(opt == 4)
            {
                equipos.imprimirTabla();
            }
            else if(opt == 0)
            {
                System.out.println("Adioooo....");
                break;
            }
            else{
                System.out.println("Ingrese una opcion correcta.");
            }
        }
    }

    private static void menus(){
        String menu = "1. Registrar equipo\n2. Registrar partido\n3. Menu reportes\n4.Tabla puntuaciones\n0. Salir\nIngrese una opcion: ";
        System.out.println(menu);
    }

    private static void menus2(){
        String menu = "1. Equipo con mas goles a favor\n2. Equipo con mas puntos\n"+
                              "3. Equipo con mas partidos ganados\n4. Total de goles\n"+
                              "5. Promedio de goles\n0. Salir";
        System.out.println(menu);
    }

    private static int validarInt(Scanner sc){
        int opcion = -1;
        try {
            opcion = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrada no válida. Por favor, ingrese un número.");
        }
        return opcion;
    }

    private static int validarSeleccionEquipo(int iEquipo, Scanner sc, int size){
        while (iEquipo > size || iEquipo <= 0) {
            System.out.println("Ingrese una opcion valida.");
            iEquipo = validarInt(sc);
        }
        return iEquipo - 1;
    }

    private static void partido(Scanner sc, GestorEquipos equipos){
        int iEquipoLocal, iEquipoVisitante, golesLocal, golesVisitante;
        
        System.out.println("Ingrese la fecha: ");
        String fecha = sc.nextLine();

        equipos.printAll();
        
        System.out.println("Seleccione el equipo local: ");
        iEquipoLocal = validarSeleccionEquipo(validarInt(sc), sc, equipos.size());

        Equipo local =equipos.getEquipo(iEquipoLocal);

        System.out.println("Ingrese los goles del equipo local: ");
        golesLocal = validarInt(sc);
        
        System.out.println("Seleccione el equipo visitante: ");

        iEquipoVisitante = validarSeleccionEquipo(validarInt(sc), sc, equipos.size());
        
        while(iEquipoLocal == iEquipoVisitante){
            System.out.println("Ingrese un equipo diferentes");
            iEquipoVisitante = validarSeleccionEquipo(validarInt(sc), sc, equipos.size());
        }

        Equipo visitante = equipos.getEquipo(iEquipoVisitante);
        
        System.out.println("Ingrese los goles del equipo visitante: ");
        golesVisitante = validarInt(sc);
        
        visitante.setGolesContra(golesLocal);
        visitante.setGolesFavor(golesVisitante);
        local.setGolesContra(golesVisitante);
        local.setGolesFavor(golesLocal);
        
        Partido newPartido = new Partido(fecha, local , visitante, golesLocal, golesVisitante);
        equipos.addPartido(newPartido);
        newPartido.determinarGanador();
    }

    private static void equipoMasGolesF(GestorEquipos equipos){
        Equipo maxGolesF = equipos.maxGoles();
        System.out.println(String.format("El equipo con mas goles a favor es %s con %d goles.",
        maxGolesF.getNombre(), maxGolesF.getGolesFavor()));

    }

    private static void equipoMasPuntos(GestorEquipos equipos){
        Equipo maxPuntos = equipos.maxPuntos();
        System.out.println(String.format("El equipo con mas puntos es %s con %d puntos",
         maxPuntos.getNombre(), maxPuntos.getPuntos()));
    }
    
    private static void equipoMasWins(GestorEquipos equipos){
        Equipo maxPuntos = equipos.maxWins();
        System.out.println(String.format("El equipo con partidos ganados es %s con %d partidos ganados",
            maxPuntos.getNombre(), maxPuntos.getPartidosGanados()));
    }
    
    private static void totalGoles(GestorEquipos equipos){
        int goles = equipos.totalGoles();
        System.out.println(String.format("El total de goles este torneo: %d", goles));
    }

    private static void promeidoGoles(GestorEquipos equipos){
        int avgGoles = equipos.avgGoles();
        System.out.println(String.format("Promedio de goles por patido: ", avgGoles));
    }

}