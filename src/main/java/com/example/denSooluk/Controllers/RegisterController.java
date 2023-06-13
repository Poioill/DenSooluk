package com.example.denSooluk.Controllers;


import com.example.denSooluk.Entity.User;
import com.example.denSooluk.Services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RequestMapping
@Controller
@RequiredArgsConstructor
public class RegisterController {
    private final UserService userService;
    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/registration")
    public String createUser(@Valid User user, Model model, BindingResult bindingResult){
//        if (bindingResult.hasErrors()){
//            String errorMessage = bindingResult.getFieldError("username").getDefaultMessage();
//            model.addAttribute("errorMessage", errorMessage);
//            return "registration";
//        }
        if (!userService.createUser(user)){
            model.addAttribute("message", "User already exists! Please ");
            return "registration";
        }
        return "redirect:/login";
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleValidationExceptions(
            MethodArgumentNotValidException ex, Model model) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> errors = result.getFieldErrors();
        for (FieldError error : errors ) {
            model.addAttribute(error.getField(), error.getDefaultMessage());
        }
        return "registration";
    }
}

