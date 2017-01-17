package org.newsletters.mappers;

import org.newsletters.entities.Suscriptor;
import org.newsletters.restcontroller.NewslettersRESTController.SaveDTO;

public class SuscriptorMapper {
    
    public Suscriptor map_SaveDTO_To_Suscriptor(SaveDTO dto){
        Suscriptor suscriptor = new Suscriptor();
        
        suscriptor.setEmail(dto.email);
        suscriptor.setName(dto.name);
        suscriptor.setLastName(dto.lastName);
        suscriptor.setMaternalLastName(dto.maternalLastName);
        suscriptor.setStateId(dto.stateId);
        suscriptor.setIndustryId(dto.industryId);
        
        return suscriptor;
    }
    
}
