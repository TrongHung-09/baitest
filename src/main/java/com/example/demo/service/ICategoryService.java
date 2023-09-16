package com.example.demo.service;

import com.example.demo.model.Category;

import java.util.List;

public interface ICategoryService {
    Category add(Category category);

    Boolean delete(Long id);

    Category update(Long id, Category category);

    List<Category> getAll();
}
