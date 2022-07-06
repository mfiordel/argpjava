package com.portfolio.mfiordel.Security.Service;

import com.portfolio.mfiordel.Security.Service.UserService;
import com.portfolio.mfiordel.Security.Entity.MainUser;
import com.portfolio.mfiordel.Security.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImp implements UserDetailsService {
    
    @Autowired
    UserService userService;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getByNameUser(username).get();
        return MainUser.build(user);
    }
    
}
