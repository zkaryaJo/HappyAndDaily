package com.example.happyanddaily.domain.login;

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
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String viewLogin(Model model) {
        model.addAttribute("REST_API_KEY", "b774a11d0f7cc39ac37d9966a5cd2061");
        return "login";
    }
}
