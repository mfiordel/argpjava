
package com.portfolio.mfiordel.Repository;

import com.portfolio.mfiordel.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Long>{
    
}
