package com.example.hr.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Document(collection = "employees")
public class Employee {
    @Id
    @Pattern(regexp = "\\d{11}")
    private String identity;
    @Size(min = 6)
    private String fullname;
    @Min(2000)
    private double salary;
    @Size(max = 1_000_000)
    private String photo;

    public Employee() {
    }

    public Employee(String identity, String fullname, double salary) {
        this.identity = identity;
        this.fullname = fullname;
        this.salary = salary;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "identity='" + identity + '\'' +
                ", fullname='" + fullname + '\'' +
                ", salary=" + salary +
                '}';
    }
}
