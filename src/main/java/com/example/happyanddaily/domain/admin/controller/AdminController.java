package com.example.happyanddaily.domain.admin.controller;

import com.example.happyanddaily.domain.admin.entity.Admin;
import com.example.happyanddaily.domain.admin.service.AdminService;
import com.example.happyanddaily.domain.menu.entity.Menu;
import com.example.happyanddaily.domain.menu.service.MenuService;
import com.example.happyanddaily.domain.shop.entity.Shop;
import com.example.happyanddaily.domain.shop.service.ShopService;
import com.example.happyanddaily.domain.systemmenu.entity.SystemMenu;
import com.example.happyanddaily.domain.systemmenu.service.SystemMenuService;
import com.fasterxml.jackson.databind.ObjectMapper;
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
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;
    private final MenuService menuService;
    private final ShopService shopService;
    private final SystemMenuService systemMenuService;
    public AdminController(AdminService adminService, MenuService menuService, ShopService shopService, SystemMenuService systemMenuService) {
        this.adminService = adminService;
        this.menuService = menuService;
        this.shopService = shopService;
        this.systemMenuService = systemMenuService;
    }

    @GetMapping("{subPage}")
    public String viewAdmin(Model model, @PathVariable("subPage") String subPage){


        List<Admin> adminList = null;
        List<Menu> menuList = null;
        Shop shop = null;
        Map<String, List<SystemMenu>> systemMenuMap = null;
        try {
            adminList = adminService.findAll();
            menuList = menuService.findAll();
            shop = shopService.findById(1);
            systemMenuMap = systemMenuService.findAllToMap();

        }catch(Exception e){
            log.info(""+e);
        }

        Map<String, Object> singleMenuMap = new ObjectMapper().convertValue(menuList.get(0), Map.class);

        model.addAttribute("menuList", menuList);
        model.addAttribute("singleMenuMap", singleMenuMap);
        model.addAttribute("shop", shop);
        model.addAttribute("systemMenuMap", systemMenuMap);

        return "contents/admin/"+subPage;
    }

}
