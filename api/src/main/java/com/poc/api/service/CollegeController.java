package com.poc.api.service;

import com.poc.api.dto.CollegeDto;
import com.poc.api.filters.SearchCollegeByPhoneAndEmailFilter;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/college")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface CollegeController {

    @GET
    @Path("/")
     List<CollegeDto> getAllColleges();

    @GET
    @Path("/search")
    CollegeDto searchByPhoneNumberAndEmail(@BeanParam @Valid SearchCollegeByPhoneAndEmailFilter filter);

    @POST
    @Path("/create")
    CollegeDto registerCollege(CollegeDto dto);

    @PUT
    @Path("/update/{email}")
    CollegeDto updateCollege(@PathParam("email") String email, CollegeDto dto);

    @DELETE
    @Path("/remove/{email}")
    CollegeDto removeCollege(@PathParam("email") String email);

}
