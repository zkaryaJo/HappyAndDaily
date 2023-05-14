package com.example.happyanddaily.domain.shop.controller;

import com.example.happyanddaily.domain.menu.entity.Menu;
import com.example.happyanddaily.domain.menu.service.MenuService;
import com.example.happyanddaily.domain.shop.entity.Shop;
import com.example.happyanddaily.domain.shop.service.ShopService;
import com.example.happyanddaily.domain.systemmenu.entity.SystemMenu;
import com.example.happyanddaily.domain.systemmenu.service.SystemMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/shop")
public class ShopController {
    private final MenuService menuService;
    private final ShopService shopService;
    private final SystemMenuService systemMenuService;
    public ShopController(MenuService menuService, ShopService shopService, SystemMenuService systemMenuService) {
        this.menuService = menuService;
        this.shopService = shopService;
        this.systemMenuService = systemMenuService;
    }

    @GetMapping("{subPage}")
    public String viewShop(Model model, @PathVariable("subPage") String subPage){

        List<Menu> menuList = null;
        Shop shop = null;
        Map<String, List<SystemMenu>> systemMenuMap = null;
        try {
            menuList = menuService.findAll();
            shop = shopService.findById(1);
            systemMenuMap = systemMenuService.findAllToMap();

        }catch(Exception e){
            log.info(""+e);
        }

        model.addAttribute("menuList", menuList);
        model.addAttribute("shop", shop);
        model.addAttribute("systemMenuMap", systemMenuMap);

        return "contents/menu/"+subPage;
    }

}
