package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.request.ProductAddRequest;
import com.example.demo.request.ProductUpdateRequest;
import com.example.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService iProductService;

    @GetMapping("/")
    public List<Product> getAll(){
        return iProductService.getAll();
    }

    @PostMapping("/add")
    public Product add(@RequestBody ProductAddRequest productAddRequest){
        return iProductService.add(productAddRequest);
    }

    @PutMapping("/update/{id}")
    public Product update(@PathVariable Long id, @RequestBody ProductUpdateRequest productUpdateRequest){
        return iProductService.update(id, productUpdateRequest);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable Long id){
        return iProductService.delete(id);
    }

    @GetMapping("/search")
    public List<Product> search(@RequestParam(value = "productName", required = false) String productName,
                                @RequestParam(value = "sellPrice", required = false) Double sellPrice,
                                @RequestParam(value = "CategoryId", required = false) Long categoryId,
                                @RequestParam(value = "statusId", required = false) Long statusId,
                                @RequestParam(value = "brandId", required = false) Long brandId){
        return iProductService.get(productName, sellPrice, categoryId, statusId, brandId);
    }
}
