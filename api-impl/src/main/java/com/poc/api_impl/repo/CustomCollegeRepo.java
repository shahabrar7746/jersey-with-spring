package com.poc.api_impl.repo;

import com.poc.api_impl.entity.College;

import java.util.List;

public interface CustomCollegeRepo {

    List<College> fetchAllColleges();
}
