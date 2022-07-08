
package com.portfolio.mfiordel.Security.Service;

import com.portfolio.mfiordel.Security.Entity.Rol;
import com.portfolio.mfiordel.Security.Enums.RolName;
import com.portfolio.mfiordel.Security.Repository.RolRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RolService {
    
    @Autowired
    RolRepository rolRepository;
    
    public Optional<Rol> getByRolName(RolName rolName){
        return rolRepository.findByRolName(rolName);
    }
    
    public void save(Rol rol){
        rolRepository.save(rol);
    }
}
