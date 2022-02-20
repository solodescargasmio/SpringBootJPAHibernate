package com.project.proyecto.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import com.project.proyecto.model.Employee;
import com.project.proyecto.repository.IEmployeeJpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


/*test "-Dspring.profiles.active=prod1" */
@CrossOrigin(origins ="http://localhost:8080")
@RestController
@RequestMapping("/employee")//Cuando coloque esta url me muestra los usuario
public class EmployeeController {
    @Autowired
    IEmployeeJpaRepository iemploye;
    
    @GetMapping()
    public ResponseEntity<Employee> getObjetos(@RequestParam String nombre){
        Optional<Employee> employeeData = iemploye.findByfirstName(nombre);

		if (employeeData.isPresent()) {
			return new ResponseEntity<>(employeeData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
    }
    @GetMapping("/")
    public List<Employee> getTodosEmployee(){
        return iemploye.findAll();
    }

    @PostMapping()
    public Employee guardarEmployee(@RequestBody Employee employee){
        return this.iemploye.save(employee);
    }
    
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable("id") Long id){
        try {
            this.iemploye.deleteById(id);
            return "EMPLOYEE DELETE!!!!";
        } catch (Exception e) {
            return "ERROR DELETE "+e.getMessage();
        }
        
    }

    @DeleteMapping("/")
    public String deleteEmployee(@RequestParam Employee employee){
        try {
            this.iemploye.delete(employee);
            return "EMPLOYEE DELETE!!!!";
        } catch (Exception e) {
            return "ERROR DELETE "+e.getMessage();
        }
        
    }
}
