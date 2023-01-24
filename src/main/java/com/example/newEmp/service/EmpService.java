package com.example.newEmp.service;

import com.example.newEmp.entity.Emp;

import java.util.List;


public interface EmpService {

    public List<Emp> getEmps();

    Emp getEmpById(int id);

    Emp addEmp(Emp emp);


    List<Emp> getAllEmps();

    Object getEmpByIdDB(Integer id);

    Object empDeleteById(Integer id);

    Object addEmpByIdDB(Emp emp);
}
