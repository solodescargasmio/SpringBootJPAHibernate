package com.project.proyecto.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.project.proyecto.model.Project;

@Repository
public interface IProjectJpaRepository extends JpaRepository<Project,Long> {
    Project findByName(String name);
}
