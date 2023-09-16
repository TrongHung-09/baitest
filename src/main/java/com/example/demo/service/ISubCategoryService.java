package com.example.demo.service;

import com.example.demo.model.SubCategory;
import com.example.demo.wapper.SubCategoryWrapper;

import java.util.List;

public interface ISubCategoryService{
    SubCategory add(SubCategoryWrapper subCategoryWrapper);

    Boolean delete(Long id);

    SubCategory update(Long aLong, SubCategoryWrapper subCategory);

    List<SubCategory> getAll();
}
