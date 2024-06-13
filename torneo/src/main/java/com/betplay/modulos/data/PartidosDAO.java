package com.betplay.modulos.data;

import com.betplay.modulos.Tuple;

import com.betplay.modulos.Partido;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;


public class PartidosDAO implements interfaceDAO <Tuple, Partido>{
    
    private HashMap <Tuple, Partido> partidos;
    private Gson gson;
    private final String path = "data/partidos.json";

    public PartidosDAO(){
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.partidos = load();
    }

    @Override
    public HashMap<Tuple, Partido> load(){
        try (Reader reader = new FileReader(path)) {
            Type type = new TypeToken<HashMap<Tuple, Partido>>() {}.getType();
           return gson.fromJson(reader, type);
        } catch (IOException e) {
            return new HashMap<Tuple, Partido>();
        }
    }

    @Override
    public void save(){
        try (Writer writer = new FileWriter(path)){
            gson.toJson(partidos ,writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void create(Partido equipo){
        partidos.put(equipo.getId(), equipo);
        save();
    }

    @Override
    public void delete(Tuple id){
        partidos.remove(id);
        save();
    }

    @Override
    public HashMap<Tuple, Partido> getList(){
        return partidos;
    }

}
