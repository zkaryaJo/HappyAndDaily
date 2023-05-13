package com.example.happyanddaily.domain.shop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10)
    private long shopId;

    @Column(length = 100)
    private String shopName;
    @Column(length = 100)
    private String shopTel;
    @Column(length = 100)
    private String shopAddress;
    @Column(length = 100)
    private String shopCategory;
    @Column(length = 200)
    private String shopThumbPath;
    @Column(length = 100)
    private String shopBusinessNumber;
    @Column(length=1000)
    private String shopDescription;
}
