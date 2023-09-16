package com.example.demo.service.impl;

import com.example.demo.model.Brand;
import com.example.demo.repository.BrandRepository;
import com.example.demo.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements IBrandService {

    @Autowired
    BrandRepository brandRepository;

    @Override
    public Brand add(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Boolean delete(Long id) {
        Optional<Brand> brand = brandRepository.findById(id);
        brandRepository.delete(brand.get());
        for (Brand brand1: brandRepository.findAll()) {
            if(brand1.getId()==id){
                return false;
            }
        }
        return true;
    }

    @Override
    public Brand update(Long id, Brand brand) {
        Brand brand1 = brandRepository.getById(id);
        brand1.setBrand_name(brand.getBrand_name());
        return brand1;
    }

    @Override
    public List<Brand> getAll() {
        return brandRepository.findAll();
    }
}
