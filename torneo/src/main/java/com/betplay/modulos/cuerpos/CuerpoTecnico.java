package com.betplay.modulos.cuerpos;

import com.betplay.modulos.roles.Tecnico;
import com.betplay.modulos.roles.AsistTecnico;
import com.betplay.modulos.roles.PrepFisico;
import java.util.ArrayList;

public class CuerpoTecnico {
    private Tecnico tecnico;
    private ArrayList<AsistTecnico> asistTecnicos;
    private ArrayList<PrepFisico> preparadoresFisicos;


    public CuerpoTecnico(){
        this.asistTecnicos = new ArrayList<>();
        this.preparadoresFisicos = new ArrayList<>();
    }

    public CuerpoTecnico(Tecnico tecnico, AsistTecnico asistTecnicos,PrepFisico preparadoresFisicos) {
        this.asistTecnicos.add(asistTecnicos);
        this.preparadoresFisicos.add(preparadoresFisicos);
        
    }

    public void aggTecnico(Tecnico tecnico){
        this.tecnico = tecnico; 
    }

    

    
}
