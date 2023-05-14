package com.example.happyanddaily.domain.systemmenu.service;



import com.example.happyanddaily.domain.systemmenu.entity.SystemMenu;
import com.example.happyanddaily.domain.systemmenu.repository.SystemMenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class SystemMenuService {

    private final SystemMenuRepository systemMenuRepository;

    public SystemMenuService(SystemMenuRepository systemMenuRepository) {
        this.systemMenuRepository = systemMenuRepository;
    }

    public List<SystemMenu> findAll(){
        return systemMenuRepository.findAll();
    }

    public SystemMenu findById(long id) throws Exception {
        return systemMenuRepository.findById(id).orElseThrow(()-> new NoSuchElementException());
    }

    public Map<String, List<SystemMenu>> findAllToMap(){
        return systemMenuRepository.findAll()
                .stream().collect(Collectors.groupingBy(SystemMenu::getDepth1));
    }

}
