package com.portfolio.mfiordel.Security.Repository;

import com.portfolio.mfiordel.Security.Entity.Rol;
import com.portfolio.mfiordel.Security.Enums.RolName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolName(RolName rolName);
}
