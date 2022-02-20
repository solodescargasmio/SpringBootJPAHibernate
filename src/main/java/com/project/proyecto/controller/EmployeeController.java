package com.project.proyecto.controller;

import java.util.Optional;

import com.project.proyecto.model.Employee;
import com.project.proyecto.repository.IEmployeeJpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/*test "-Dspring.profiles.active=prod1" */
@CrossOrigin(origins ="http://localhost:8080")
@RestController
@RequestMapping("/usuario")//Cuando coloque esta url me muestra los usuario
public class EmployeeController {
    @Autowired
    IEmployeeJpaRepository iemploye;
    
    @GetMapping()
    public ResponseEntity<Employee> getObjetos(@RequestParam String nombre){
        Optional<Employee> tutorialData = iemploye.findByfirstName(nombre);

		if (tutorialData.isPresent()) {
			return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
    }
}
