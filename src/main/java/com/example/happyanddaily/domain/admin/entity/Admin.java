package com.example.happyanddaily.domain.admin.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length=10)
    private long adminId;

    @Column(length=100)
    private String categoryMain;

    @Column(length=100)
    private String categorySub;

    @Column(length=100)
    private String menuName;

    @Column(columnDefinition = "decimal(10,0)", length=10)
    private BigDecimal menuPrice;

    @Column(columnDefinition = "TEXT")
    private String menuDescription;

    @Column(length=100)
    private String imgPath;

    @Column(length = 1)
    private int stars;

    @Column
    private boolean saleYn;
}
