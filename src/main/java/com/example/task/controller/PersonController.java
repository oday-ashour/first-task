package com.example.task.controller;

import com.example.task.model.Person;
import com.example.task.service.PersonService;
import com.example.task.service.impl.PersonServiceImpl;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/person")
public class PersonController {

    private PersonService personServiceImpl = new PersonServiceImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson(@QueryParam("id") Integer id) {
        Person person =personServiceImpl.getPerson(id);
        if(person.getId() != null){
            return Response.ok(person).build();
        }
        return Response.noContent().build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPerson(Person person) {
        return Response.ok(personServiceImpl.addPerson(person)).build();
    }

    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public Response deletePerson(@QueryParam("id") Integer id) {
        return Response.ok(personServiceImpl.deletePerson(id)).build();
    }
}
