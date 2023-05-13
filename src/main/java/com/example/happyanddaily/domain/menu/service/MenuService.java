package com.example.happyanddaily.domain.menu.service;

import com.example.happyanddaily.domain.menu.entity.Menu;
import com.example.happyanddaily.domain.menu.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<Menu> findAll(){
        return menuRepository.findAll();
    }

}
