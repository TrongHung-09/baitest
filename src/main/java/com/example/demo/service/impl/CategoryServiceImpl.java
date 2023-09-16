package com.example.demo.service.impl;

import com.example.demo.model.Brand;
import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category add(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Boolean delete(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        categoryRepository.delete(category.get());
        for (Category category1: categoryRepository.findAll()) {
            if(category1.getId()==id){
                return false;
            }
        }
        return true;
    }

    @Override
    public Category update(Long id, Category category) {
        Category category1 = categoryRepository.findById(id).get();
        category1.setCate_name(category.getCate_name());
        category1.setCate_code(category.getCate_code());
        return categoryRepository.save(category1);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
