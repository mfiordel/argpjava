
package com.portfolio.mfiordel.Repository;

import com.portfolio.mfiordel.Entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienceRepository extends JpaRepository<Experience, Long>{
    
}
