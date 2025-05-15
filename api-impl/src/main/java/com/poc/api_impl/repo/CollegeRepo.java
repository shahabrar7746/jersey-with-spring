package com.poc.api_impl.repo;

import com.poc.api_impl.entity.College;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CollegeRepo extends JpaRepository<College, Integer> {

    Optional<College> findByEmail(String email);

    Optional<College> findByEmailAndPhoneNumber(String email, String phoneNumber);
}
