package com.example.demo.controllers;

import com.example.demo.dto.UserDto;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("user")
public class UserController {

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserDto registration(@Valid
                                @RequestBody
                                @JsonView(UserDto.UserView.RegistrationPost.class) UserDto userDto) {
        System.out.println(System.currentTimeMillis());

        System.out.println(userDto);
        var user = new UserDto();
        user.setUserName("DEFAULT");
        System.out.println(System.currentTimeMillis());
        return user;

    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UserDto login(@Valid
                         @RequestBody
                         @JsonView(UserDto.UserView.Login.class) UserDto userDto) {

        System.out.println(System.currentTimeMillis());
        var user = new UserDto();
        user.setPassword(userDto.getPassword());
        System.out.println(System.currentTimeMillis());
        return user;

    }
}
