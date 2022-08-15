package com.portfolio.mfiordel.Security.Service;

import com.portfolio.mfiordel.Security.Entity.User;
import com.portfolio.mfiordel.Security.Repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional 
public class UserService {
    
    @Autowired
    UserRepository userRepository;
       
    public Optional<User> getByNameUser(String nameUser){
        return userRepository.findByNameUser(nameUser);
    }
    
    public boolean existsByNameUser(String nameUser){
        return userRepository.existsByNameUser(nameUser);
    }
    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }
    public void save(User user){
    userRepository.save(user);
    }
}