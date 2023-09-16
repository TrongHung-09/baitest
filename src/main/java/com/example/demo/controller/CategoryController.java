package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cate")
public class CategoryController {

    @Autowired
    ICategoryService iCategoryService;

    @GetMapping("/")
    public List<Category> show(){
        return iCategoryService.getAll();
    }

    @PostMapping("/add")
    public Category add(@RequestBody Category category){
        return iCategoryService.add(category);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable Long id){
        return iCategoryService.delete(id);
    }

    @PutMapping("update/{id}")
    public Category update(@PathVariable Long id, @RequestBody Category category){
        return iCategoryService.update(id, category);
    }
}
