package com.example.healthfood.application.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Data
public class UserDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String last_name;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String address;
    @NotBlank
    private String phone_number;
}


