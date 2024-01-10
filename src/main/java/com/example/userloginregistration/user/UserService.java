package com.example.userloginregistration.user;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository;

    //CRUD

    public User addUser(User user ){
        user.setId(UUID.randomUUID().getLeastSignificantBits());
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
       return  userRepository.findAll();
    }


    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User updateUser(User userRequest){
        //get the existing doc from db
        //assign new value from request to that doc
        User existingUser=userRepository.findById(userRequest.getId()).get();
        existingUser.setEmail(userRequest.getEmail());
        existingUser.setUsername(userRequest.getUsername());
        existingUser.setPassword(userRequest.getPassword());
        return userRepository.save(existingUser);
    }

    public  String deleteUser(Long userId){
        userRepository.deleteById(userId);
        return userId+ " user deleted successfully";
    }

}
