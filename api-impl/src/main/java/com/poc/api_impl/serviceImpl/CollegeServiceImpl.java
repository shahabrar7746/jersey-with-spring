package com.poc.api_impl.serviceImpl;

import com.poc.api.dto.CollegeDto;
import com.poc.api.service.CollegeController;
import com.poc.api_impl.repo.CollegeRepo;
import jakarta.annotation.PostConstruct;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class CollegeServiceImpl implements CollegeController {

    @Autowired
    private CollegeRepo repo;


    @Override
    public List<CollegeDto> getAllColleges() {
       return repo.findAll()
                .stream()
                .map(college -> {
                    CollegeDto dto = new CollegeDto();
                   dto.setAddress(college.getAddress());
                   dto.setCity(college.getCity());
                   dto.setEmail(college.getEmail());
                   dto.setName(college.getName());
                   dto.setPhoneNumber(college.getPhoneNumber());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
