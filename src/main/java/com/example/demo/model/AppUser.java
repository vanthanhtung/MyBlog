package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appUser_id;

    @NotBlank (message = "Please fill out this field")
    private String name;
    @NotBlank (message = "Please fill out this field")
    private String password;
    private Date dateOfBirth;

    @Email
    @NotBlank (message = "Invalid email. Must be abc@xyz.com")
    private String email;
    private String avatar;
    private String cover;
    private String introduction;
    private String job;
    private String gender;

    @Pattern(regexp = "0+[0-9]{9}")
    @NotBlank(message = "Invalid phone number")
    private String phoneNumber;
    private boolean isActive;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;
}
