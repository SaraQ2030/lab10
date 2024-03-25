package org.example.lab10.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.lab10.API.ApiRessponse;
import org.example.lab10.Model.User;
import org.example.lab10.Service.UserService;
import org.hibernate.mapping.List;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/jobsystem/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getUser(){
        return ResponseEntity.status(200).body(userService.getUser());
    }
@PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid  User user , Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        Boolean isAdd=userService.addUser(user);
        if (isAdd){
            return ResponseEntity.status(200).body(new ApiRessponse("User added "));
        }
        return ResponseEntity.status(400).body(new ApiRessponse("already exist"));
    }
@PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id,@RequestBody @Valid User user ,Errors errors){
        if (errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        Boolean isUpdated=userService.updateUser(id,user);
        if (isUpdated){
            return ResponseEntity.status(200).body(new ApiRessponse("user updated"));
        }
        return ResponseEntity.status(400).body(new ApiRessponse("Not founf Id"));
    }
@DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        Boolean isDeleted=userService.deleteUser(id);
        if (isDeleted){
            return ResponseEntity.status(200).body(new ApiRessponse("User deleted"));
        }
        return ResponseEntity.status(400).body(new ApiRessponse("Not found Id"));
    }

}
