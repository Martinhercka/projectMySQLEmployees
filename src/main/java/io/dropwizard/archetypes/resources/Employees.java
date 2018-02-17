package io.dropwizard.archetypes.resources;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.archetypes.db.MySQL;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/employees")
public class Employees
{

    @POST

    @Path("/salary")

    @Produces(MediaType.APPLICATION_JSON)
    public String getPopulation(Emplo emplo)
    {

        String salary = new MySQL().getSalary(emplo.name);
        return salary;


    }



    public static class Emplo
    {
        @JsonProperty("name")
        public String name ;


    }

}


