package com.example.demo.wapper;

import lombok.Data;

@Data
public class SubCategoryWrapper {

    private Long id;

    private String sub_cate_code;

    private String sub_cate_name;

    private Long category_id;

    private String category_name;
}
