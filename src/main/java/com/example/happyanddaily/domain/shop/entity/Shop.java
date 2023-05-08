package com.example.happyanddaily.domain.shop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Shop {

    @Id
    @Column(length = 10)
    public long shop_id;

    @Column(length = 100)
    public String shop_name;
    @Column(length = 100)
    public String shop_tel;
    @Column(length = 100)
    public String shop_address;
    @Column(length = 100)
    public String shop_category;
    @Column(length = 200)
    public String shop_thumb_path;
    @Column(length = 100)
    public String shop_business_number;
    @Column(length=1000)
    public String shop_description;
}
