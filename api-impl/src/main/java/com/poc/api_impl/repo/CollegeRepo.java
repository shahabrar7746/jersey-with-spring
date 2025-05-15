package com.poc.api_impl.repo;

import com.poc.api_impl.entity.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeRepo extends JpaRepository<College, Integer> {
}
