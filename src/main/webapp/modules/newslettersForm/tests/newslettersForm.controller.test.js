describe('newslettersFormModule.newslettersFormController', function() {
    
    var scope, controller;
    var mockNewslettersFormRESTService;
    
    beforeEach(module('newslettersFormModule'));
    
    beforeEach(inject(function ($rootScope, $controller, $injector) {
        scope = $rootScope.$new();
        
        mockNewslettersFormRESTService = $injector.get('newslettersFormRESTService');
        
        controller = $controller('newslettersFormController', {
            URL_RESOURCES: "", 
            states: [], 
            industries: [], 
            newslettersFormRESTService: mockNewslettersFormRESTService
        });
        
        controller.form = {
            $setSubmitted: angular.noop,
            $invalid: false
        };
    }));
    
    it('should init controller attributes', function() {
        //Arrange
        //Act
        //Assert
        expect(controller.model).toBeDefined();
        expect(controller.model.states).toBeDefined();
        expect(controller.model.industries).toBeDefined();
        expect(controller.model.acceptTerms).toBe(true);
    });
    
    it('should call save fn to rest service', function() {
        //Arrange
        controller.model = {
            name: "name",
            lastName: "lastName",
            maternalLastName: "maternalLastName",
            stateId: 1,
            industryId: 1            
        };
        controller.form.$invalid = false;
        spyOn(mockNewslettersFormRESTService, 'save').and.callFake(function(data, onSuccess) {
            expect(data).toEqual(controller.model);
            onSuccess();
        });
        
        //Act
        controller.save();
        
        //Assert
        expect(mockNewslettersFormRESTService.save).toHaveBeenCalledTimes(1);
        expect(controller.formSubmitted).toBe(true);
    });
    
    it('should not call save fn when form is dirty', function() {
        //Arrange
        controller.model = {};
        controller.form.$invalid = true;
        spyOn(mockNewslettersFormRESTService, 'save').and.callThrough();
        
        //Act
        controller.save();
        
        //Assert
        expect(mockNewslettersFormRESTService.save).not.toHaveBeenCalled();
        expect(controller.formSubmitted).toBe(false);
    });
    
    it('should not call save fn when stateId is empty', function() {
        //Arrange
        controller.model = {
            stateId: ""
        };
        controller.form.$invalid = false;
        spyOn(mockNewslettersFormRESTService, 'save').and.callThrough();
        
        //Act
        controller.save();
        
        //Assert
        expect(mockNewslettersFormRESTService.save).not.toHaveBeenCalled();
        expect(controller.formSubmitted).toBe(false);
    });
    
    it('should not call save fn when industryId is empty', function() {
        //Arrange
        controller.model = {
            industryId: ""
        };
        controller.form.$invalid = false;
        spyOn(mockNewslettersFormRESTService, 'save').and.callThrough();
        
        //Act
        controller.save();
        
        //Assert
        expect(mockNewslettersFormRESTService.save).not.toHaveBeenCalled();
        expect(controller.formSubmitted).toBe(false);
    });    
});

