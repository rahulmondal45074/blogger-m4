package com.example.Blogging.Platform.API.model;


import com.example.Blogging.Platform.API.model.enums.AccountType;
import com.example.Blogging.Platform.API.model.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,scope = User.class,property = "userId")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @NotBlank(message = "user name can not be blank")
    private String userName;
    @NotNull(message = "userHandler can not be null")
    private String userHandle;
    private String userBio;

    @Email
    private String userEmail;

    @Size(min = 5,max = 10)
    private String userPassword;
    private Gender userGender;
    private AccountType userAccountType;



}
