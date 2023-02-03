package com.example.newEmp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import lombok.Getter;
//import lombok.Setter;

/*import javax.validation.constraints.Email;
import javax.validation.constraints.Max;*/
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotNull;
//123456
//@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Employee1")
public class Emp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @NotBlank(message = "Please provide valid name")
    @Size(min = 3, max = 20, message = "Name should be minimum 3 character and maximum 20 ")
    private String name;
    private Integer salary;
    @NotBlank
    @Size(max = 1, message = "Maximum 1 character allow")
    private String status;
    @NotNull(message = "Age not valid")
    @Min(value = 18, message = "Minimum age should be 18")
    @Max(value = 100, message = "Maximum age not more than 100")
    private Integer age;

    @NotBlank
    @Email(message = "Please provide a valid Email address")
    private String email;


   /* public Emp(Integer id, String name, Integer salary, String status, Integer age, String email) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.status = status;
        this.age = age;
        this.email = email;
    }*/

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

//    @Override
//    public String toString() {
//        return "Emp{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", salary=" + salary +
//                ", status='" + status + '\'' +
//                ", age=" + age +
//                ", email='" + email + '\'' +
//                '}';
//    }

}