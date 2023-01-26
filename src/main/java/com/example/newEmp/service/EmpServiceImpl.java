package com.example.newEmp.service;

import com.example.newEmp.dao.EmpDao;
import com.example.newEmp.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao dao;
    List<Emp> list;

    public EmpServiceImpl() {
        list = new ArrayList<>();
        list.add(new Emp(1, "Surajit", 6000, "A", 24, "asdf@gmai.com"));
        list.add(new Emp(2, "Rohit", 900, "A", 28, "qewwrgfb@gmai.com"));
        list.add(new Emp(3, "Raj", 8933, "A", 22, "hyrre@gmai.com"));
        list.add(new Emp(4, "mita", 1000, "I", 29, "ryrf@gmai.com"));
        list.add(new Emp(5, "Rima", 7000, "I", 79, "drdc@gmai.com"));
    }


    @Override
    public List<Emp> getEmps() {
        // TODO Auto-generated method stub
        return list;
    }

    @Override
    public Emp getEmpById(int id) {
        Emp c = null;

        for (Emp emp1 : list) {

            if (emp1.getId() == id) {
                c = emp1;
            }
        }
        return c;

    }

    @Override
    public Emp addEmp(Emp emp) {
        list.add(emp);
        return emp;
    }


//For SQL

    @Override
    public List<Emp> getAllEmps() {
        return dao.findAll();
    }


//    @Override
//    public Optional getEmpByIdDBNm(Integer id, String name) {
//        return dao.findBy(id, name);
//    }

    @Override
    public Object getEmpByIdDB(Integer id) {
        return dao.findById(id);
    }

    @Override
    public Object empDeleteById(Integer id) {
        Optional<Emp> emp = dao.findById(id);
        dao.deleteById(id);
        return emp;
    }

    @Override
    public Object addEmpByIdDB(Emp emp) {
        dao.save(emp);
        return emp;
    }


}
