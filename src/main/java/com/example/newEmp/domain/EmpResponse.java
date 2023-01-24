package com.example.newEmp.domain;

public class EmpResponse implements java.io.Serializable {

    private Object empRes;
    private String Message;

    public Object getEmpRes() {
        return empRes;
    }

    public void setEmpRes(Object empRes) {
        this.empRes = empRes;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String setMessage) {
        this.Message = setMessage;
    }
}

