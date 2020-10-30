package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appUser_id;
    private String name;
    private String password;
    private String dateOfBirth;
    private String email;
    private String avatar;
    private String cover;
    private String introduction;
    private String job;
    private String gender;
    private String phoneNumber;
    @Transient
    private MultipartFile imgFile;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;

    public String getEmail(String email) {
        return  email;
    }

    public String  getDateOfBirth(String  dateOfBirth) {
        return dateOfBirth;
    }
}
