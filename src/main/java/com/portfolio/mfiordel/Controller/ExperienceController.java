package com.portfolio.mfiordel.Controller;

import com.portfolio.mfiordel.Entity.Experience;
import com.portfolio.mfiordel.Interface.IExperienceService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienceController {
    @Autowired IExperienceService iexperienceService;
    
    @GetMapping("/experience/get")
    public List<Experience> getExperience(){
        return iexperienceService.getExperience();
    }
    
    @PostMapping("/experience/post")
    public String createExperience(@RequestBody Experience experience){
        iexperienceService.saveExperience(experience);
        return "La experiencia fue creada correctamente";
    }
    
    @DeleteMapping("/experience/delete/(id)")
    public String deleteExperience(@PathVariable Long id){
        iexperienceService.deleteExperience(id);
        return "La experiencia fue eliminada correctamente";
    }
    
    @PutMapping("/experience/edit/(id)")
    public Experience editExperience(@PathVariable Long id,
                                     @RequestParam("name_school") String newNameSchool,
                                     @RequestParam("is_actually") boolean newIsActually,
                                     @RequestParam("initial_date") Date newInitialDate,
                                     @RequestParam("end_date") Date newEndDate,
                                     @RequestParam("description") String newDescription,
                                     @RequestParam("url_img") String newUrlImage,
                                     @RequestParam("style") String newStyle
                                     //@RequestParam("person_id") Long newPersonId
                                     ){
        
        Experience experience = iexperienceService.findExperience(id);
        
        experience.setName_school(newNameSchool);
        experience.set_actually(newIsActually);
        experience.setInitial_date(newInitialDate);
        experience.setEnd_date(newEndDate);
        experience.setDescription(newDescription);
        experience.setUrl_img(newUrlImage);
        experience.setStyle(newStyle);
        //experience.setPerson_id(newPersonId);
        
        iexperienceService.saveExperience(experience);
        return experience;
    }
    @GetMapping("/person/get/experience")
    public Experience findExperience(){
        return iexperienceService.findExperience((long)1);
    }
}
