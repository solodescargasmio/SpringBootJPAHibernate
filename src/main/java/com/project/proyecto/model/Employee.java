package com.project.proyecto.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 10)
    private Long id;

    @Column(length = 25)
    private String firstName;

    @Column(length = 25)
    private String lastName;

    @Column(length = 25)
    private String employeeid;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_role")
    private Role role;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="employee_project",
    joinColumns = {@JoinColumn(name = "employee_id")},
    inverseJoinColumns = {@JoinColumn(name="project_id")})
    private List<Project> projects=new ArrayList<Project>();


    public Employee() {
    }


    public Employee(String firstName, String lastName, String employeeid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeid = employeeid;
    }
    


    public Employee(String firstName, String lastName, String employeeid, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeid = employeeid;
        this.role = role;
    }


    public Role getRole() {
        return role;
    }


    public void setRole(Role role) {
        this.role = role;
    }


    public List<Project> getProjects() {
        return projects;
    }


    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getEmployeeid() {
        return employeeid;
    }


    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "Employee [employeeid=" + employeeid + ", firstName=" + firstName + ", id=" + id + ", lastName="
                + lastName + "]";
    }

    
    

    

}
