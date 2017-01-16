package org.newsletters.restcontroller;

import org.newsletters.mappers.SuscriptorMapper;
import org.newsletters.model.ResponseErrorModel;
import org.newsletters.repositories.SuscriptorRepository;
import org.newsletters.utils.HttpHeadersUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/newsletters")
public class NewslettersRESTController {
    
    private final int INTERNAL_ERROR_CODE = 500;
    private final SuscriptorRepository repository = new SuscriptorRepository();
    private final SuscriptorMapper mapper = new SuscriptorMapper();
    
    public class SaveDTO {
        public String uniqueId;
        public String email;
        public String name;
        public String lastName;
        public String maternalLastName;
        public int stateId;
        public int industryId;
        public String industryOther;
    }
    
    @RequestMapping(value = "/form/save", method = RequestMethod.POST)
    public ResponseEntity<?> save(
            @RequestBody SaveDTO dto
    ) {
        try {
            repository.insert(mapper.map_SaveDTO_To_Suscriptor(dto));
            return new ResponseEntity<>(HttpHeadersUtils.INSTANCE.generateCustomHeaders(MediaType.TEXT_PLAIN), HttpStatus.OK);
        } catch (Exception ex) {
            //TODO:log full exception
            return new ResponseEntity<>(new ResponseErrorModel(INTERNAL_ERROR_CODE, ex.toString()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
}
