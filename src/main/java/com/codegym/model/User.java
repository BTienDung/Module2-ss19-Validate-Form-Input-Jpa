package com.codegym.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    private  Long id;
    @NotEmpty
    @Size(min = 5, max = 45)
    private String firstName;
    @NotEmpty
    @Size(min = 5, max = 45)
    private String lastName;

    @NotBlank
    @Size(min = 10, max = 11)
    private String phone;

    @Min(18)
    private int Age;

    @Email
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String  phone) {
        this.phone = phone;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User() {
    }

    public User(@NotEmpty @Size(min = 5, max = 45) String firstName, @NotEmpty @Size(min = 5, max = 45) String lastName, @NotBlank @Size(min = 10, max = 11) String phone, @Min(18) int age, @Email String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        Age = age;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    //    @Override
//    public boolean supports(Class<?> clazz) {
//        return User.class.isAssignableFrom(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        User user = (User) target;
//        String email = user.getEmail();
//        ValidationUtils.rejectIfEmpty(errors, "number", "number.empty");
//        if (!email.startsWith("0")){
//            errors.rejectValue("number", "number.startsWith");
//        }
//        if (!email.matches("(^[0-9a-zA-Z]+[0-9a-zA-Z]*@[0-9a-zA-Z]+(\\.[A-Za-z0-9]+)$)")){
//            errors.rejectValue("number", "number.matches");
//        }
//    }
}
