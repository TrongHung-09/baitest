package com.example.demo.service.impl;

import com.example.demo.model.Brand;
import com.example.demo.model.Product;
import com.example.demo.model.Status;
import com.example.demo.model.SubCategory;
import com.example.demo.repository.BrandRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.StatusRepository;
import com.example.demo.repository.SubCategoryRepository;
import com.example.demo.request.ProductAddRequest;
import com.example.demo.request.ProductUpdateRequest;
import com.example.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    SubCategoryRepository subCategoryRepository;

    @Autowired
    StatusRepository statusRepository;

    @Override
    public Product add(ProductAddRequest o) {
        Product product = new Product();

        product.setQuantity(o.getQuantity());
        product.setColor(o.getColor());
        product.setDescription("");
        product.setSell_price(o.getSell_price());
        product.setOrigin_price(o.getOrigin_price());
        product.setProduce_name(o.getProduce_name());

        SubCategory subCategory = subCategoryRepository.findById(o.getSubcate_id()).get();
        product.setSubCategory(subCategory);

        Status status = statusRepository.findById(1L).get();
        Brand brand = brandRepository.findById(o.getBrand_id()).get();
        List<Brand> brands = new ArrayList<>();
        brands.add(brand);

        product.setStatus(status);
        product.setBrands(brands);
        return productRepository.save(product);
    }

    @Override
    public Boolean delete(Long id) {
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
        for (Product product1: productRepository.findAll()
             ) {
            if(product1.getId() == id){
                return false;
            }
        }
        return true;
    }

    @Override
    public Product update(Long id, ProductUpdateRequest o) {
        Product product = productRepository.findById(id).get();

        product.setQuantity(o.getQuantity());
        product.setColor(o.getColor());
        product.setDescription("");
        product.setSell_price(o.getSell_price());
        product.setOrigin_price(o.getOrigin_price());
        product.setProduce_name(o.getProduce_name());

        SubCategory subCategory = subCategoryRepository.findById(o.getSubcate_id()).get();
        Status status = statusRepository.findById(o.getStatus_id()).get();
        Brand brand = brandRepository.findById(o.getBrand_id()).get();
        List<Brand> brands = new ArrayList<>();
        brands.add(brand);

        product.setSubCategory(subCategory);
        product.setStatus(status);
        product.setBrands(brands);
        product.setSubCategory(subCategory);
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> get(String productName, Double sellPrice, Long categoryId, Long statusId, Long brandId) {
        return productRepository.get(productName, sellPrice, categoryId, statusId, brandId);
    }
}
