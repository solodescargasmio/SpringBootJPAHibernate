package com.project.proyecto.repository;

import com.project.proyecto.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;
import com.project.proyecto.model.Role;

@Repository
public interface IEmployeeJpaRepository extends JpaRepository<Employee,Long>{
  Optional<Employee> findByfirstName(String nombre);
  Employee findByemployeeid(String employeeid);
  List<Employee> findBylastName(String lastName);
  List<Employee> findByRole(Role role);

}
