package com.example.demo.service;

import java.util.List;

public interface IService <O, IDO>{
    public O add(O o);

    public Boolean delete(IDO id);

    public O update (IDO id, O o);

    public List<O> getAll();
}
