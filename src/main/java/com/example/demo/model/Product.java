package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "subcate_id")
    private SubCategory subCategory;

    @Column(length = 100)
    private String produce_name;

    @Column(length = 50)
    private String color;

    private Long quantity;

    private Double sell_price;

    private Double origin_price;

    @Column(length = 1000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToMany
    @JoinTable(
            name = "product_brand",
            // TẠO RA 1 BẢNG PHỤ CÓ TÊN product_brand
            joinColumns = @JoinColumn(name = "product_id"),
            // GỒM 1 CỘT LÀ KHÓA NGOẠI VỚI CHÍNH TABLE NÀY
            inverseJoinColumns = @JoinColumn(name = "brand_id")
            // 1 KHÓA NGOẠI VỚI TABLE PRODUCT => BẢNG BÊN DƯỚI ANOTION
    )
    List<Brand> brands;
}
