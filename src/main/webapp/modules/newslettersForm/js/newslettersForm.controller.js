module.controller('newslettersFormController', newslettersFormController);

function newslettersFormController(URL_RESOURCES, states, industries, newslettersFormRESTService) {
    var self = this;

    self.URL_RESOURCES = URL_RESOURCES;
    self.states = states;
    self.industries = industries;
    self.formSubmitted = false;
    self.model = {
        acceptTerms: true
    };
    
    self.save = save;
    
    function save(){
        self.form.$setSubmitted();
        if(self.form.$invalid || isEmpty(self.model.stateId) || isEmpty(self.model.industryId)){
            return;
        }
        newslettersFormRESTService.save(self.model, function onSuccess(){
            self.formSubmitted = true;
        });
    }
     
    function isEmpty(value) {
        return value === undefined || value === "" || value === null;
    }
}