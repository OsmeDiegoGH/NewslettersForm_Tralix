package org.newsletters.restcontroller;

import org.newsletters.model.ResponseErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/newsletters")
public class NewslettersRESTController {
    
    private final int INTERNAL_ERROR_CODE = 500;
    
    public class SaveDTO {
        public String uniqueId;
    }
    
    @RequestMapping(value = "/form/save", method = RequestMethod.POST)
    public ResponseEntity<?> save(
            @RequestBody SaveDTO dto
    ) {
        try {
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            //TODO:log full exception
            return new ResponseEntity<>(new ResponseErrorModel(INTERNAL_ERROR_CODE, ex.toString()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
