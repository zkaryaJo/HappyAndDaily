package com.example.happyanddaily.domain.systemmenu.repository;

import com.example.happyanddaily.domain.systemmenu.entity.SystemMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemMenuRepository extends JpaRepository<SystemMenu, Long> {
}
