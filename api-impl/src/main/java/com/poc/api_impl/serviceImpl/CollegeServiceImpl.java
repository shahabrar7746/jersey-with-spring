package com.poc.api_impl.serviceImpl;

import com.poc.api.dto.CollegeDto;
import com.poc.api.filters.SearchCollegeByPhoneAndEmailFilter;
import com.poc.api.service.CollegeController;
import com.poc.api_impl.entity.College;
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
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
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
                   college.updateDto(dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public CollegeDto searchByPhoneNumberAndEmail(SearchCollegeByPhoneAndEmailFilter filter) {
        String email = filter.getEmail();
        String phoneNumber = filter.getPhoneNumber();
        Optional<College> collegeOptional = repo.findByEmailAndPhoneNumber(email, phoneNumber);
        CollegeDto dto = new CollegeDto();
        collegeOptional.ifPresentOrElse(college -> college.updateDto(dto), ()-> {
            dto.setName("No college found for your email and phone number");
        } );
        return dto;
    }

    @Override
    public CollegeDto registerCollege(CollegeDto dto) {
        College college = new College();
        BeanUtils.copyProperties(dto, college);
        repo.save(college);
        return dto;
    }

    @Override
    public CollegeDto updateCollege(String email, CollegeDto dto) {
        Optional<College> college = repo.findByEmail(email);
        college.map(college1 -> {
           college1.updateEntity(dto);
           college1.updateDto(dto);
            return college1;
        });
        college.ifPresent(repo::save);
        return dto;

    }

    @Override
    public CollegeDto removeCollege(String email) {
        Optional<College> college = repo.findByEmail(email);
        college.ifPresent(repo::delete);
        CollegeDto dto = new CollegeDto();
        college.ifPresent(college1 -> college1.updateDto(dto));
        return dto;
    }
}
