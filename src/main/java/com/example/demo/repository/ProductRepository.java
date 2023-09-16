package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(
            """
            SELECT p from Product p join p.brands b 
            WHERE (:productName IS NULL OR p.produce_name LIKE %:productName%)
                        AND (:sellPrice IS NULL OR p.sell_price = :sellPrice)
                        AND (:categoryId IS NULL OR p.subCategory.category.id = :categoryId)
                        AND (:statusId IS NULL OR p.status.id = :statusId)
                        AND (:brandId IS NULL OR b.id = :brandId)
        """)
    List<Product> get(@Param("productName") String productName,
                                @Param("sellPrice") Double sellPrice,
                                @Param("categoryId") Long categoryId,
                                @Param("statusId") Long statusId,
                                @Param("brandId") Long brandId);
}
