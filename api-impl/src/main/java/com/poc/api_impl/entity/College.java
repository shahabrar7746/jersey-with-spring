package com.poc.api_impl.entity;

import com.poc.api.dto.CollegeDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "college")
@Getter
@Setter
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "city", length = 40)
    private String city;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    @Column(name = "email", unique = true)
    private String email;

    @OneToMany(mappedBy = "college", fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE})
    private List<Student> students;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public void updateDto(CollegeDto dto)
    {
        dto.setAddress(this.getAddress());
        dto.setCity(this.getCity());
        dto.setEmail(this.getEmail());
        dto.setName(this.getName());
        dto.setPhoneNumber(this.getPhoneNumber());
    }

    public void updateEntity(CollegeDto dto)
    {
        String updatedEmail = dto.getEmail() == null ? this.getEmail() : dto.getEmail();
        String updatedPhoneNumber = dto.getPhoneNumber() == null ? this.getPhoneNumber() : dto.getPhoneNumber();
        String updatedName = dto.getName() == null ? this.getName() : dto.getName();
        String updatedCity = dto.getCity() == null ? this.getCity() : dto.getCity();
        String updatedAddress = dto.getAddress() == null ? this.getAddress() : dto.getAddress();
        this.setAddress(updatedAddress);
        this.setCity(updatedCity);
        this.setName(updatedName);
        this.setCity(updatedCity);
        this.setEmail(updatedEmail);
        this.setPhoneNumber(updatedPhoneNumber);
    }
}
