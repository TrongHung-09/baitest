package com.example.demo.service;

import com.example.demo.model.Brand;

import java.util.List;

public interface IBrandService {
    Brand add(Brand brand);

    Boolean delete(Long id);

    Brand update(Long id, Brand brand);

    List<Brand> getAll();
}
