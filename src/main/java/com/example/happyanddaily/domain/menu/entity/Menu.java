package com.example.happyanddaily.domain.menu.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.text.DecimalFormat;

@Entity
@Getter
@Setter
public class Menu {

    @Id
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
}
