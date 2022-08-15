package com.portfolio.mfiordel.Interface;

import com.portfolio.mfiordel.Entity.Experience;
import java.util.List;

public interface IExperienceService {
    //Get Experience
    public List<Experience> getExperience();
    
    //Save Experience
    public void saveExperience(Experience experience);
    
    //Delete object Experience by Id
    public void deleteExperience(Long id);
    
    //Search object Experience by Id
    public Experience findExperience(Long id);

}
