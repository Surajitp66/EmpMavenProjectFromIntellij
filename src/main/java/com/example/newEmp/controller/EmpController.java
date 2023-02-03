package com.example.newEmp.controller;

import com.example.newEmp.dao.EmpDao;
import com.example.newEmp.domain.EmpResponse;
import com.example.newEmp.entity.Emp;
import com.example.newEmp.service.EmpService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;


@RestController
@RequestMapping("/emp")
public class EmpController {

    private Logger logger = LoggerFactory.getLogger(EmpController.class);
    @Autowired
    private EmpService empNewService;
    @Autowired
    private EmpDao empDao;

    @GetMapping("")
    public Emp getEmp() {

        return new Emp(1, "Surajit", 2000, "A", 24, "asdf@gmai.com");


    }

    //get employees
//    @GetMapping("/allEmpfrm")
//    public List<Emp> getEmps() {
//        return this.empNewService.getEmps();
//
//    }
    @GetMapping("/allEmp")
    public ResponseEntity<EmpResponse> allEmp() {
        EmpResponse res = new EmpResponse();
        res.setEmpRes(empNewService.getEmps());
        res.setMessage("All Employees");
        return new ResponseEntity<EmpResponse>(res, HttpStatus.OK);
    }

    //get employee by id
//    @GetMapping("/empById/{id}")
//    public Emp getEmpById(@PathVariable("id") Integer id) {
//
//        return this.empNewService.getEmpById(id);
//    }
    @GetMapping("/empById/{id}")
    public ResponseEntity<EmpResponse> getEmpById(@PathVariable("id") Integer id) {
        EmpResponse res = new EmpResponse();
        res.setEmpRes(empNewService.getEmpById(id));
        res.setMessage(HttpStatus.OK.toString());
        return new ResponseEntity<EmpResponse>(res, HttpStatus.OK);
    }


    //    @PostMapping("/addEmp")
//    public Emp addEmp(@RequestBody Emp emp) {
//        return this.empNewService.addEmp(emp);
//    }
    @PostMapping("/addEmp")
    public ResponseEntity<EmpResponse> addEmp(@RequestBody Emp emp) {
        Emp em = empNewService.addEmp(emp);
        EmpResponse res = new EmpResponse();
        res.setEmpRes(em);
        res.setMessage("successfully added");
        return new ResponseEntity<EmpResponse>(res, HttpStatus.OK);
    }

    @GetMapping("/allEmpSQL")
    public ResponseEntity<EmpResponse> getAllEmps() {
        EmpResponse res = new EmpResponse();
        res.setEmpRes(empNewService.getAllEmps());
        res.setMessage("All Employees");
        logger.info("All emp info {}", res.getEmpRes());
        return new ResponseEntity<EmpResponse>(res, HttpStatus.OK);
    }


    @PostMapping("/addEmpSQLValid")
    public ResponseEntity<Object> addEmpByIdDB(@Valid @RequestBody Emp emp, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage(), HttpStatus.BAD_REQUEST);
//            return new ResponseEntity<Object>("Invalid employee", HttpStatus.BAD_REQUEST);
        }


        Object em = empNewService.addEmpByIdDB(emp);

        EmpResponse res = new EmpResponse();
        res.setEmpRes(em);
        res.setMessage("successfully added");
        return new ResponseEntity<Object>(res, HttpStatus.OK);


    }

    @PostMapping("/addEmpSQL")
    public ResponseEntity<Object> addEmpByIdDB(@RequestBody Emp emp) {
        Object em = empNewService.addEmpByIdDB(emp);

        EmpResponse res = new EmpResponse();
        res.setEmpRes(em);
        res.setMessage("successfully added");
        logger.info("Emp Added {}", em);
        return new ResponseEntity<Object>(res, HttpStatus.OK);


    }

   /* @PostMapping("/addEmpSQL")
    public ResponseEntity<Object> addEmpByIdDB(@Valid @RequestBody Emp emp) {
        if (emp == null) {
            return new ResponseEntity<Object>("Invalid employee", HttpStatus.BAD_REQUEST);
        }
        Object em = null;
        try {
            empNewService.addEmpByIdDB(emp);
        } catch (ValidationException e) {
            return new ResponseEntity<Object>(e, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<Object>(e, HttpStatus.BAD_REQUEST);
        }


        EmpResponse res = new EmpResponse();
        res.setEmpRes(em);
        res.setMessage("successfully added");
        return new ResponseEntity<Object>(res, HttpStatus.OK);


    }*/

    @GetMapping("/empByIdSQL/{id}")
    public ResponseEntity<Object> getEmpByIdDB(@PathVariable("id") Integer id) {
        EmpResponse res = new EmpResponse();
        Object empByIdDB = empNewService.getEmpByIdDB(id);
        res.setEmpRes(empByIdDB);
        logger.debug("Id found {}", res.getEmpRes());

        if (empByIdDB == Optional.empty()) {
            return new ResponseEntity<Object>("Id not found!", HttpStatus.BAD_REQUEST);

        } else {

            res.setMessage(HttpStatus.OK.toString());
            return new ResponseEntity<Object>(res, HttpStatus.OK);

        }
    }

//    @GetMapping("/empByIdSQL/{id}/{name}")
//    public ResponseEntity<EmpResponse> getEmpByIdDBNm(@PathVariable("id") Integer id, @PathVariable("name") String name) {
//        EmpResponse res = new EmpResponse();
//        res.setEmpRes(empNewService.getEmpByIdDBNm(id, name));
//        res.setMessage(HttpStatus.OK.toString());
//        return new ResponseEntity<EmpResponse>(res, HttpStatus.OK);
//    }


    @DeleteMapping("/empDeleteById/{id}")
    public ResponseEntity<EmpResponse> empDeleteById(@PathVariable("id") Integer id) {
        EmpResponse res = new EmpResponse();
        res.setEmpRes(empNewService.empDeleteById(id));
        res.setMessage("Delete Successful");
        logger.debug("Deleted emp {}", res.getEmpRes());
        return new ResponseEntity<EmpResponse>(res, HttpStatus.OK);
    }
}
