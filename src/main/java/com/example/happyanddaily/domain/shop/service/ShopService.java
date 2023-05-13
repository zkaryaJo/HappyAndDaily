package com.example.happyanddaily.domain.shop.service;

import com.example.happyanddaily.domain.shop.entity.Shop;
import com.example.happyanddaily.domain.shop.repository.ShopRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ShopService {

    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public List<Shop> findAll(){
        return shopRepository.findAll();
    }

    public Shop findById(long id) throws Exception {
        return shopRepository.findById(id).orElseThrow(()->new Exception());

    }
}
