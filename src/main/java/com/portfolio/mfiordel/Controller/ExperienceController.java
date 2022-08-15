package com.portfolio.mfiordel.Controller;

import com.portfolio.mfiordel.Entity.Experience;
import com.portfolio.mfiordel.Interface.IExperienceService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
public class ExperienceController {
    @Autowired IExperienceService iexperienceService;
    
    @GetMapping("/experience/get")
    public List<Experience> getExperience(){
        return iexperienceService.getExperience();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/experience/create")
    public String createExperience(@RequestBody Experience experience){
        iexperienceService.saveExperience(experience);
        return "La experiencia fue creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/experience/delete/{id}")
    public String deleteExperience(@PathVariable Long id){
        iexperienceService.deleteExperience(id);
        return "La experiencia fue eliminada correctamente";
    }
    
    //ToDo @RequestParam to @RequestBody
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/experience/edit/{id}")
    public Experience editExperience(@PathVariable Long id,
                                     @RequestParam("name_school") String newNameSchool,
                                     @RequestParam("is_actually") boolean newIsActually,
                                     @RequestParam("initial_date")@DateTimeFormat(pattern = "yyyy-MM-dd") Date newInitialDate,
                                     @RequestParam("end_date")@DateTimeFormat(pattern = "yyyy-MM-dd") Date newEndDate,
                                     @RequestParam("description") String newDescription,
                                     @RequestParam("url_img") String newUrlImage,
                                     @RequestParam("style") String newStyle
                                     //@RequestParam("person_id") Long newPersonId
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
        //experience.setPerson_id(newPersonId);
        
        iexperienceService.saveExperience(experience);
        return experience;
    }
    @GetMapping("/person/get/experience")
    public Experience findExperience(){
        return iexperienceService.findExperience((long)1);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/experience/editName/{id}")
    public Experience editExperience(@PathVariable Long id,
                                     @RequestParam("name_school") String newNameSchool
                                     ){
        
        Experience experience = iexperienceService.findExperience(id);
            
        experience.setName_school(newNameSchool);
        //experience.setPerson_id(newPersonId);
        //experience.setPerson_id(newPersonId);
        
        iexperienceService.saveExperience(experience);
        return experience;
    }
       
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/experience/editDescription/{id}")
    public Experience editDescExperience(@PathVariable Long id,
                                     @RequestParam("description") String newDescription
                                     ){
        
        Experience experience = iexperienceService.findExperience(id);
            
        experience.setDescription(newDescription);
        //experience.setPerson_id(newPersonId);
        //experience.setPerson_id(newPersonId);
        
        iexperienceService.saveExperience(experience);
        return experience;
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/experience/editInitialDate/{id}")
    public Experience editInitialDateExperience(@PathVariable Long id,
                                     @RequestParam("initial_date")@DateTimeFormat(pattern = "yyyy-MM-dd") Date newInitialDate
                                     ){
        
        Experience experience = iexperienceService.findExperience(id);
            
        experience.setInitial_date(newInitialDate);
        //experience.setPerson_id(newPersonId);
        //experience.setPerson_id(newPersonId);
        
        iexperienceService.saveExperience(experience);
        return experience;
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/experience/editEndDate/{id}")
    public Experience editEndDateExperience(@PathVariable Long id,
                                     @RequestParam("end_date")@DateTimeFormat(pattern = "yyyy-MM-dd") Date newEndDate
                                     ){
        
        Experience experience = iexperienceService.findExperience(id);
            
        experience.setEnd_date(newEndDate);
        //experience.setPerson_id(newPersonId);
        //experience.setPerson_id(newPersonId);
        
        iexperienceService.saveExperience(experience);
        return experience;
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/experience/editUrlImg/{id}")
    public Experience editUrlImgExperience(@PathVariable Long id,
                                     @RequestParam("url_img") String NewUrlImage,
                                     @RequestParam("style") String NewStyle
                                     ){
        
        Experience experience = iexperienceService.findExperience(id);
            
        experience.setUrl_img(NewUrlImage);
        experience.setStyle(NewStyle);
        //experience.setPerson_id(newPersonId);
        //experience.setPerson_id(newPersonId);
        
        iexperienceService.saveExperience(experience);
        return experience;
    }
}
