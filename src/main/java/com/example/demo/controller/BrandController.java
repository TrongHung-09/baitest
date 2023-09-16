package com.example.demo.controller;

import com.example.demo.model.Brand;
import com.example.demo.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    IBrandService iBrandService;

    @GetMapping("/")
    public List<Brand> getAll(){
        return iBrandService.getAll();
    }

    @PostMapping("/add")
    public Brand add(@RequestBody Brand brand){
        return iBrandService.add(brand);
    }

    @PutMapping("/update/{id}")
    public Brand update(@PathVariable Long id, @RequestBody Brand brand){
        return iBrandService.update(id, brand);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable Long id){
        return iBrandService.delete(id);
    }
}
