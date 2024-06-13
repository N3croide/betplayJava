package com.betplay.modulos.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;

import com.betplay.modulos.Equipo;
import com.betplay.modulos.Partido;
import com.betplay.modulos.Tuple;

public class EequiposDAO implements interfaceDAO <Integer, Equipo> {
    private HashMap <Integer ,Equipo> equipos;
    private Gson gson;
    private final String path = "data/equipo.json";

    public EequiposDAO(){
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.equipos = load();
    }

    @Override
    public HashMap<Integer ,Equipo> load(){
        try (Reader reader = new FileReader(path)) {
            Type type = new TypeToken<HashMap<Integer ,Equipo>>() {}.getType();
           return gson.fromJson(reader, type);
        } catch (IOException e) {
            return new HashMap<Integer ,Equipo>();
        }
    }

    @Override
    public void save(){
        try (Writer writer = new FileWriter(path)){
            gson.toJson(equipos ,writer);
        } catch (Exception e) {
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

}
