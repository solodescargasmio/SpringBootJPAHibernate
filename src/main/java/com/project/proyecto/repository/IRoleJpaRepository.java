package com.project.proyecto.repository;

import com.project.proyecto.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IRoleJpaRepository extends JpaRepository<Role,Long> {
    Role findByName(String namRole);
}
