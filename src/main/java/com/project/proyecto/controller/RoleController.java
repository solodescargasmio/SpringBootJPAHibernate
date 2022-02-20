package com.project.proyecto.controller;

import com.project.proyecto.model.Role;
import com.project.proyecto.repository.IRoleJpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;


@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/role")



public class RoleController {
    @Autowired
    IRoleJpaRepository iRole;

    @GetMapping()
    public ResponseEntity<List<Role>> getAll(){
        List<Role> roles=iRole.findAll();
        if(roles.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(roles,HttpStatus.OK);    
        }
    }

    @PostMapping()
    public Role guardarRoleString(@RequestParam String roln){
        Role rol=new Role(roln);
        return this.iRole.save(rol);
    }
    @PostMapping("/")
    public Role guardarRole(@RequestBody Role rol){
        return this.iRole.save(rol);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable("id") Long id){
		try {
			iRole.deleteById(id);
				return new ResponseEntity<>("Tutorials DELETE!! ",HttpStatus.NO_CONTENT);
			} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
    }
}
