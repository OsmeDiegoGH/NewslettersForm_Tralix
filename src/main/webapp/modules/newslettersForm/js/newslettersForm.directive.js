module.directive('newslettersForm', function(){
    return {
        restrict: 'E',
        replace: true,
        controller: 'newslettersFormController',
        controllerAs: 'newslettersFormCtrl',
        bindToController: true,
        templateUrl: 'newslettersForm/templates/newslettersForm.html'
    };
});