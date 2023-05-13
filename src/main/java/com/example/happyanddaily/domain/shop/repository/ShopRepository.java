package com.example.happyanddaily.domain.shop.repository;

import com.example.happyanddaily.domain.shop.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}
