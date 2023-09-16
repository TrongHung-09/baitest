package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "sub_category")
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String sub_cate_code;

    @Column(length = 50)
    private String sub_cate_name;

    @ManyToOne
    @JoinColumn(name = "cate_id")
    private Category category;
}
