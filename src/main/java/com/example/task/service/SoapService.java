package com.example.task.service;

import com.example.task.model.Person;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface SoapService {

    @WebMethod
    public Person getPerson(Integer id);

    @WebMethod
    public Person addPerson(Integer id,String name,Integer age);

    @WebMethod
    public Integer deletePerson(Integer id);
}
