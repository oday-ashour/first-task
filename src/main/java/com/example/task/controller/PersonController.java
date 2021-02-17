package com.example.task.controller;

import com.example.task.model.Person;
import com.example.task.service.PersonService;
import com.example.task.service.impl.PersonServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * This class responsible about providing RESTfull APIs for person entity
 */
@Path("/person")
public class PersonController {

    private PersonService personServiceImpl = new PersonServiceImpl();

    /**
     * Getting person model by id.
     * @param id Query param represent the id for the person to get.
     * @return Response containing the person model and the status code for the response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson(@QueryParam("id") Integer id) {
        Person person =personServiceImpl.getPerson(id);
        if(person.getId() != null){
            return Response.ok(person).build();
        }
        return Response.noContent().build();
    }

    /**
     * Create new person and store in aerospike database.
     * @param person sent throw request body as json, represent the person to add.
     * @return Response containing the created person model and the status code for the response.
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPerson(Person person) {
        return Response.ok(personServiceImpl.addPerson(person)).build();
    }

    /**
     * Delete person from aerospike database.
     * @param id Query param represent the id for the person to delete.
     * @return Response containing the id for the deleted person and the status code for the response.
     */
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public Response deletePerson(@QueryParam("id") Integer id) {
        return Response.ok(personServiceImpl.deletePerson(id)).build();
    }
}
