package com.betplay.modulos;

public class Partido {

    private String fecha;
    private Equipo equipoLocal, equipoVisitante;
    private int golesL, golesV;

    public Partido(String fecha, Equipo local, Equipo visitante, int golesL, int golesV){
        this.fecha = fecha;
        this.equipoLocal = local;
        this.equipoVisitante = visitante;
        this.golesL = golesL;
        this.golesV = golesV;
    }

    public void determinarGanador(){
        if(this.golesL != this.golesV){
            if(this.golesL > this.golesV){
                this.equipoLocal.gano();
                this.equipoVisitante.perdio();
            }
            else{
                this.equipoLocal.perdio();
                this.equipoVisitante.gano();
            }
        }
        else{
            this.equipoLocal.empato();
            this.equipoVisitante.empato();
        }
    }
}
