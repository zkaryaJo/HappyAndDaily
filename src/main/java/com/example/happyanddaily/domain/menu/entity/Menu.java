package com.example.happyanddaily.domain.menu.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;

@Entity
@Getter
@Setter
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length=10)
    private long menuId;

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
    private String badge;
}
