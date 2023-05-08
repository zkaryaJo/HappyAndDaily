package com.example.happyanddaily.domain.sysmenu.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class SysMenu {

    @Id
    @Column(length=10)
    public long sys_menu_id;

    @Column(length=100)
    public String depth1;

    @Column(length=100)
    public String depth2;

    @Column(length=100)
    public String depth3;

    @Column(length=100)
    public String depth4;

    @Column(length=100)
    public BigDecimal sys_menu_name;

    @Column(length=100)
    public BigDecimal url;

}
