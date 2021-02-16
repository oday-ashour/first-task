package com.example.task.service.impl;

import com.example.task.model.Person;
import com.example.task.service.PersonService;
import com.example.task.service.SoapService;

import javax.jws.WebService;

@WebService(endpointInterface = "com.example.task.service.SoapService")
public class SoapServiceImpl implements SoapService {

    private PersonService personServiceImpl = new PersonServiceImpl();

    @Override
    public Person getPerson(Integer id) {
        return personServiceImpl.getPerson(id);
    }

    @Override
    public Person addPerson(Integer id, String name, Integer age) {
        Person person = new Person(id,name,age);
        return personServiceImpl.addPerson(person);
    }

    @Override
    public Integer deletePerson(Integer id) {
        return personServiceImpl.deletePerson(id);
    }

}
