package com.portfolio.mfiordel.Controller;

import com.portfolio.mfiordel.Entity.Person;
import com.portfolio.mfiordel.Interface.IPersonService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "https://mf-portfolio-arg-programa.web.app")
public class PersonController {
    @Autowired IPersonService ipersonService;
        
    @GetMapping("/person/get")
    public List<Person> getPerson(){
        return ipersonService.getPerson();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/person/create")
    public String createPerson(@RequestBody Person person){
        ipersonService.savePerson(person);
        return "La persona fue creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/person/delete/{id}")
    public String deletePerson(@PathVariable Long id){
        ipersonService.deletePerson(id);
        return "La persona fue eliminada correctamente";
    }
    
    @PutMapping("/person/edit/{id}")
    public Person editPerson(@PathVariable Long id,
                             @RequestParam("name") String newName,
                             @RequestParam("lastname") String newLastName,
                             @RequestParam("address") String newAddress,
                             @RequestParam("phone") String newPhone,
                             @RequestParam("mail") String newMail,
                             @RequestParam("url_img") String newUrlImg,
                             @RequestParam("about_me") String newAboutMe){
        
        Person person = ipersonService.findPerson(id);
        
        person.setName(newName);
        person.setLastname(newLastName);
        person.setAddress(newAddress);
        person.setPhone(newPhone);
        person.setMail(newMail);
        person.setUrl_img(newUrlImg);
        person.setAbout_me(newAboutMe);
        
        ipersonService.savePerson(person);
        return person;
    }
    @GetMapping("/person/get/profile")
    public Person findPerson(){
        return ipersonService.findPerson((long)1);
    }
}
