package com.example.happyanddaily.domain.admin.service;

import com.example.happyanddaily.domain.admin.entity.Admin;
import com.example.happyanddaily.domain.admin.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> findAll(){
        return adminRepository.findAll();
    }

}
