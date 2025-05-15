package com.poc.api.service;

import com.poc.api.dto.CollegeDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/college")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface CollegeController {



    @GET
    @Path("/")
    public List<CollegeDto> getAllColleges();
}
