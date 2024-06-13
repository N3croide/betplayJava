package com.betplay.modulos;

public class Partido {

    private String fecha;
    private Equipo equipoLocal, equipoVisitante;
    private int golesL, golesV;
    private Tuple id;

    public Tuple getId() {
        return id;
    }

    public void setId(Tuple id) {
        this.id = id;
    }

    public Partido(String fecha, Equipo local, Equipo visitante, int golesL, int golesV){
        this.fecha = fecha;
        this.equipoLocal = local;
        this.equipoVisitante = visitante;
        this.golesL = golesL;
        this.golesV = golesV;
        this.id = new Tuple<Integer,Integer>(local.getId(), visitante.getId());
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
