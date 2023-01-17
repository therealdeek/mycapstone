package com.project.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
public class CreateUserForm {

    @NotEmpty(message = "Email is required.")
    @Length(max = 20, message = "Email must be less than 20 characters.")
    private String email;

    @NotEmpty(message = "password is required.")
    @Pattern(regexp = "^[a-z,A-Z,0-9,\\D,\\d]+$", message = "Password can only contain lowercase, uppercase, and special characters")
    @Length(min = 8, message = "Password must be longer than 8 characters.")
    @Length(max = 25, message = "Password must be shorter than 25 characters.")
    private String password;

    @NotEmpty(message = "must confirm password.")
    @Length(min = 8, message = "Password must be longer than 8 characters.")
    @Length(max = 25, message = "Password must be shorter than 25 characters.")
    private String confirmPassword;

    @Length(min = 2, message = "First name must have at least 2 characters.")
    @Length(max = 30, message = "First name must be less than 30 characters.")
    private String firstName;

    @Length(min = 2, message = "Last name must have at least 2 characters.")
    @Length(max = 30, message = "Last name must be less than 30 characters.")
    private String lastName;

    @NotEmpty
    private String address;

    @NotEmpty
    @Length(max = 30, message = "City must be 30 characters or less.")
    private String city;

    @NotEmpty
    @Length(max = 2, message = "State must be 2 characters.")
    private String state;

    @NotEmpty
    @Length(max = 5, message = "Zip must be 5 characters.")
    private String zip;

}
