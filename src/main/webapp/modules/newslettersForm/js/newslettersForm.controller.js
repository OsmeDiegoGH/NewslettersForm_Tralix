module.controller('newslettersFormController', newslettersFormController);

function newslettersFormController(URL_RESOURCES, newslettersFormRESTService) {
    var self = this;

    self.URL_RESOURCES = URL_RESOURCES;
     
    function isEmpty(value) {
        return value === undefined || value === "" || value === null;
    }
}