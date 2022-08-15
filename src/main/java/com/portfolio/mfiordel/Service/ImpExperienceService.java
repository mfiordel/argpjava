package com.portfolio.mfiordel.Service;

import com.portfolio.mfiordel.Entity.Experience;
import com.portfolio.mfiordel.Interface.IExperienceService;
import com.portfolio.mfiordel.Repository.IExperienceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpExperienceService implements IExperienceService{
    @Autowired IExperienceRepository iexperienceRepository;

    @Override
    public List<Experience> getExperience() {
        List<Experience> experience = iexperienceRepository.findAll();
        return experience;
    }

    @Override
    public void saveExperience(Experience experience) {
        iexperienceRepository.save(experience);
    }

    @Override
    public void deleteExperience(Long id) {
        iexperienceRepository.deleteById(id);
    }

    @Override
    public Experience findExperience(Long id) {
        Experience experience = iexperienceRepository.findById(id).orElse(null);
        return experience;
    }
}
