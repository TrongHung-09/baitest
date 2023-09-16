package com.example.demo.request;

import lombok.Data;

@Data
public class ProductUpdateRequest {

    private Long id;

    private String produce_name;

    private Long subcate_id;

//    private String subcate_code;
//
//    private String subcate_name;

    private String color;

    private Long quantity;

    private Double sell_price;

    private Double origin_price;

    private Long brand_id;

//    private String brand_name;

    private Long status_id;

//    private String status_name;
}
