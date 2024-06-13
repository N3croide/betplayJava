package com.betplay.modulos.data;

import java.util.HashMap;

public interface interfaceDAO<ID,T> {
    HashMap <ID, T> load();
    void save();
    void create(T element);
    void delete(ID id);
    HashMap <ID, T> getList();
    boolean exist(T element);
}
