//package com.example.demo.model;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//@Entity
//@Data
//@Table(name = "product_brand")
//@IdClass(IdProductBrand.class)
//public class ProductBrand {
////
////    @EmbeddedId
////    public IdProductBrand idProductBrand;
//
//    @Id
//    @GeneratedValue (strategy = GenerationType.IDENTITY)
//    @ManyToOne
//    @JoinColumn(name = "product_id")
//    private Product product;
//
//    @Id
//    @GeneratedValue (strategy = GenerationType.IDENTITY)
//    @ManyToOne
//    @JoinColumn(name = "brand_id")
//    private Brand brand;
//}
