package com.example.happyanddaily.api;

import com.example.happyanddaily.domain.menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface ApiMenuRepository extends JpaRepository<Menu, Long> {

}
