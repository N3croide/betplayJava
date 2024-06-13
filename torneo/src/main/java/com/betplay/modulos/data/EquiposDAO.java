package com.betplay.modulos.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;

import com.betplay.modulos.Equipo;

public class EquiposDAO implements interfaceDAO <Integer, Equipo> {
    private HashMap <Integer ,Equipo> equipos;
    private Gson gson;
    private final String PATH = "betplayJava/torneo/src/main/java/jsonData/equipo.json";

    public EquiposDAO(){
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.equipos = load();
    }

    @Override
    public HashMap<Integer ,Equipo> load(){
        try (Reader reader = new FileReader(PATH)) {
            Type type = new TypeToken<HashMap<Integer ,Equipo>>() {}.getType();
           return gson.fromJson(reader, type);
        } catch (IOException e) {
            return new HashMap<Integer ,Equipo>();
        }
    }

    @Override
    public void save(){
        try (Writer writer = new FileWriter(PATH)){
            gson.toJson(equipos ,writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Equipo equipo){
        equipos.put(equipo.getId(),equipo);
        save();
    }

    @Override
    public void delete(Integer id){
        equipos.remove(id);
        save();
    }

    @Override
    public HashMap<Integer, Equipo> getList(){
        return equipos;
    }

    @Override
    public boolean exist(Equipo equipoNuevo){
        for (Equipo equipo : this.equipos.values()) {
            if ((equipoNuevo.getId() == equipo.getId()) || ( (equipoNuevo.getNombre().toLowerCase()).equals(equipo.getNombre().toLowerCase()) )) {
                return true;
            }
        }
        return false;
    }
}
