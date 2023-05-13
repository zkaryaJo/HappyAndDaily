package com.example.happyanddaily.controller;

import com.example.happyanddaily.domain.menu.entity.Menu;
import com.example.happyanddaily.domain.menu.service.MenuService;
import com.example.happyanddaily.domain.shop.entity.Shop;
import com.example.happyanddaily.domain.shop.service.ShopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/about")
public class AboutController {
    private final MenuService menuService;
    private final ShopService shopService;
    public AboutController(MenuService menuService, ShopService shopService) {
        this.menuService = menuService;
        this.shopService = shopService;
    }

    @GetMapping
    public String about(Model model){

        List<Menu> arrayList = null;
        Shop shop = null;
        try {
            arrayList = menuService.findAll();
            shop = shopService.findById(1);
        }catch(Exception e){
            log.info(""+e);
        }

        model.addAttribute("arrayList", arrayList);
        model.addAttribute("shop", shop);

        return "contents/about";
    }

}
