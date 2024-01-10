package com.example.userloginregistration.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService service;

    //this is the only endpoint that is not secured:
    @GetMapping("/welcome")
    public  String welcome(){
        return  "Welcome, this is not secured";
    }

    @PostMapping("/addUser")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user){
        return service.addUser(user);
    }

    @GetMapping("/all")
    public List<User> getUsers(){
        return  service.getAllUsers();
    }

    @GetMapping("/{email}")
    public User getUser(@PathVariable String email){
        return service.findByEmail(email);
    }


    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user){
        return service.updateUser(user);
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable Long userId){
        return service.deleteUser(userId);
    }

}
