package com.example.demo.repository;

import com.example.demo.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    SubCategory getById(Long id);

    Optional<SubCategory> findById(Long id);
}
