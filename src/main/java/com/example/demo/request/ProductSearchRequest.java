package com.example.demo.request;

import lombok.Data;

@Data
public class ProductSearchRequest {

    private Long id;

    private String produce_name;

    private Long subcate_id;

    private String color;

    private Long quantity;

    private Double sell_price;

    private Double origin_price;

    private Long brand_id;
}
