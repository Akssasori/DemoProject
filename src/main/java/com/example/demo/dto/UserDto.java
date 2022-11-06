package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UserDto {

    public interface UserView {
        public static interface RegistrationPost {}
        public static interface Login {}
    }

    @NotBlank(groups = {UserView.RegistrationPost.class}, message = "UserName não pode estar em branco ou nulo")
    @JsonView(UserView.RegistrationPost.class)
//    @NotBlank(message = "NÃO DEVE SER VAZIO PORRA")
    private String userName;

    @NotEmpty(groups = {UserView.Login.class}, message = "Password não pode estar vazio")
    @JsonView(UserView.Login.class)
    private Long password;

    @JsonView(UserView.RegistrationPost.class)
    private String email;

    @JsonView(UserView.RegistrationPost.class)
    private String cpf;

    private Integer PhoneNumber;

    private String imgProfile;
}
