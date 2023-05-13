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
    public long menu_id;

    @Column(length=100)
    public String category_main;

    @Column(length=100)
    public String category_sub;

    @Column(length=100)
    public String menu_name;

    @Column(columnDefinition = "decimal(10,0)", length=10)
    public BigDecimal menu_price;

    @Column(columnDefinition = "TEXT")
    public String menu_description;

    @Column(length=100)
    public String img_path;

    @Column(length = 1)
    public int stars;

    @Column
    public boolean saleYn;
}
