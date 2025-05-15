package com.poc.api_impl.repo.repoImp;

import com.poc.api_impl.entity.College;
import com.poc.api_impl.repo.CustomCollegeRepo;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class CustomCollegerepoImpl implements CustomCollegeRepo {

    private  EntityManager manager;

    @Override
    public List<College> fetchAllColleges() {
    return  manager.createNamedQuery("SELECT c FROM College c")
              .getResultList();

    }

    @PostConstruct
    public void created()
    {
        System.out.println("Im created!!");
    }
}
