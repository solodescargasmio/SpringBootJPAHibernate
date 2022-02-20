package com.project.proyecto.controller;

import com.project.proyecto.repository.IProjectJpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.proyecto.model.Project;
import java.util.*;

@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/project")

public class ProjectController {
    @Autowired
    IProjectJpaRepository iProj;

    @GetMapping()
    public ResponseEntity<List<Project>> getAll(){
        List<Project> projects=iProj.findAll();
        if(projects.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(projects,HttpStatus.OK);    
        }
    }

    @GetMapping("/{id}")
    public Optional<Project> getPorId(@PathVariable Long id){
          return iProj.findById(id);  
    }

    @PostMapping()
    public Project guardarRoleString(@RequestParam String projectn){
        Project project=new Project(projectn);
        return this.iProj.save(project);
    }
    @PostMapping("/")
    public Project guardarRole(@RequestBody Project project){
        return this.iProj.save(project);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable("id") Long id){
		try {
			iProj.deleteById(id);
				return new ResponseEntity<>("Tutorials DELETE!! ",HttpStatus.NO_CONTENT);
			} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
    }   
}
