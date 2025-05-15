package com.poc.api.filters;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.QueryParam;
import org.hibernate.validator.constraints.Length;

public class SearchCollegeByPhoneAndEmailFilter {

    @NotEmpty
    @NotBlank
    @NotNull
    @QueryParam("email")
    private String email;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotEmpty
    @NotBlank
    @NotNull
    @QueryParam("phoneNumber")
    private String phoneNumber;
}
