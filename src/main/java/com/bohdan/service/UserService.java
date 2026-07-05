package com.bohdan.service;

import com.bohdan.entity.User;
import com.bohdan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user){
        userRepository.save(user);
    }

    public void delete(int id){
        userRepository.deleteById(id);
    }

    public void makeUserStudent(int id){

        User user = userRepository.findById(id).orElse(null);

        if(user == null){
            throw new RuntimeException("Такого користувача не існує");
        }

        user.setStudent(true);
        userRepository.save(user);

    }


}
