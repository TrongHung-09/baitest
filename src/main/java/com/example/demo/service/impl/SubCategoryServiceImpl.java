package com.example.demo.service.impl;

import com.example.demo.model.Category;
import com.example.demo.model.SubCategory;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.SubCategoryRepository;
import com.example.demo.service.ISubCategoryService;
import com.example.demo.wapper.SubCategoryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubCategoryServiceImpl implements ISubCategoryService {

    @Autowired
    SubCategoryRepository subCategoryRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public SubCategory add(SubCategoryWrapper subCategoryWrapper) {
        SubCategory subCategory = new SubCategory();

        subCategory.setSub_cate_name(subCategoryWrapper.getSub_cate_name());
        subCategory.setSub_cate_code(subCategoryWrapper.getSub_cate_code());

        Category category = categoryRepository.findById(subCategoryWrapper.getCategory_id()).get();
        subCategory.setCategory(category);

        return subCategoryRepository.save(subCategory);
    }

    @Override
    public Boolean delete(Long aLong) {
        SubCategory subCategory = subCategoryRepository.getById(aLong);
        subCategoryRepository.delete(subCategory);
        for (SubCategory subCategory1 : subCategoryRepository.findAll()) {
            if (subCategory1.getId() == aLong) {
                return false;
            }
        }
        return true;
    }

    @Override
    public SubCategory update(Long aLong, SubCategoryWrapper subCategory) {
        SubCategory subCategory1 = subCategoryRepository.getById(aLong);

        Category category = categoryRepository.findById(subCategory.getCategory_id()).get();
        subCategory1.setCategory(category);
        subCategory1.setSub_cate_code(subCategory.getSub_cate_code());
        subCategory1.setSub_cate_name(subCategory.getSub_cate_name());
//        subCategory1.setCategory(subCategory.getCategory());
//        subCategory1.setSub_cate_code(subCategory.getSub_cate_code());
//        subCategory1.setSub_cate_name(subCategory.getSub_cate_name());
        return subCategoryRepository.save(subCategory1);
    }

    @Override
    public List<SubCategory> getAll() {
        return subCategoryRepository.findAll();
    }
}
