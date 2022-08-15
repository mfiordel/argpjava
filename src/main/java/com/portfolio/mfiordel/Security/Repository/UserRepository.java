package com.portfolio.mfiordel.Security.Repository;

import com.portfolio.mfiordel.Security.Entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByNameUser(String nameUser);
    
    boolean existsByNameUser(String nameUser);
    boolean existsByEmail(String email);
    
}
