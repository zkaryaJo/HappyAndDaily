package com.example.happyanddaily.domain.systemmenu.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class SystemMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length=10)
    private long systemMenuId;

    @Column(length=100)
    private String depth1;

    @Column(length=100)
    private String depth2;

    @Column(length=100)
    private String depth3;

    @Column(length=100)
    private String depth4;

    @Column(length=100)
    private String systemMenuName;

}
