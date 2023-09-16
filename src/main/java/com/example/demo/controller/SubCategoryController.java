package com.example.demo.controller;

import com.example.demo.model.SubCategory;
import com.example.demo.service.ISubCategoryService;
import com.example.demo.wapper.SubCategoryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subcate")
public class SubCategoryController {

    @Autowired
    ISubCategoryService iSubCategoryService;

    @GetMapping("/")
    public List<SubCategory> getAll(){
        return iSubCategoryService.getAll();
    }

    @PostMapping("/add")
    public SubCategory add(@RequestBody SubCategoryWrapper subCategory){
        return iSubCategoryService.add(subCategory);
    }

    @PutMapping("/update/{id}")
    public SubCategory update(@PathVariable Long id, @RequestBody SubCategoryWrapper subCategory){
        return iSubCategoryService.update(id, subCategory);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable Long id){
        return iSubCategoryService.delete(id);
    }
}
