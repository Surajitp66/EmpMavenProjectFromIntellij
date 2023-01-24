package com.example.newEmp.dao;

import com.example.newEmp.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmpDao extends JpaRepository<Emp, Integer> {


}

