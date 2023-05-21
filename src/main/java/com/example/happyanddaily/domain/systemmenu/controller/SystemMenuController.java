package com.example.happyanddaily.domain.systemmenu.controller;

import com.example.happyanddaily.domain.menu.entity.Menu;
import com.example.happyanddaily.domain.shop.entity.Shop;
import com.example.happyanddaily.domain.systemmenu.entity.SystemMenu;
import com.example.happyanddaily.domain.systemmenu.service.SystemMenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/systemMenus")
public class SystemMenuController {
    private final SystemMenuService systemMenuService;
    public SystemMenuController(SystemMenuService systemMenuService) {
        this.systemMenuService = systemMenuService;
    }

    @GetMapping()
    public ResponseEntity findAllToMap(){
        try{
            return ResponseEntity.ok(systemMenuService.findAllToMap());
        }catch(Exception e){
            return ResponseEntity.ok(e);
        }
    }

}
