package com.example.newEmp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*import javax.validation.constraints.Email;
import javax.validation.constraints.Max;*/
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Employee1")
public class Emp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String name;
    private Integer salary;
    private String status;
    @NotNull(message = "Age not valid")
    @Min(18)
    @Max(100)
    private Integer age;

    @NotBlank
    @Email
    private String email;


    public Emp(Integer id, String name, Integer salary, String status, Integer age, String email) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.status = status;
        this.age = age;
        this.email = email;
    }

//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getSalary() {
//        return salary;
//    }
//
//    public void setSalary(Integer salary) {
//        this.salary = salary;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", status='" + status + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}
