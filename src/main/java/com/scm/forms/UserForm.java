package com.scm.forms;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserForm {
    @NotBlank(message = "Username is required")
    @Size(min=3,message = "Min 3 Chaarcters is required")
    private String name;

    @Email(message = "Invalid Email Address")
    @NotBlank(message = "Email Address is required")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min=8,message = "Min 8 Chaarcters is required")
    private String password;

    @NotBlank(message = "About is required")
    private String about;

    @Size(min=8,max = 12,message = "Invalid Phone Number ")
    @NotBlank(message = "PhoneNumber is Required")
    private String phoneNumber;
}
