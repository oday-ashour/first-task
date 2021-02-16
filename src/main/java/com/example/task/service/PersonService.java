package com.example.task.service;

import com.example.task.model.Person;

import javax.ws.rs.core.Response;

public interface PersonService {

    public Person addPerson(Person person);
    public Person getPerson(Integer id);
    public Integer deletePerson(Integer id);
}
