package com.portfolio.mfiordel.Interface;

import com.portfolio.mfiordel.Entity.Person;
import java.util.List;

public interface IPersonService {
    //Get Person
    public List<Person> getPerson();
    
    //Save person object
    public void savePerson(Person person);
    
    //Delete object person by id
    public void deletePerson(Long id);
    
    //Search object person by id
    public Person findPerson(Long id);
}