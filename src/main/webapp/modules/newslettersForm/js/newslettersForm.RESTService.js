module.factory('newslettersFormRESTService', newslettersFormRESTService);

function newslettersFormRESTService(restService){
    
    return{
        save: save
    };
        
    function save(data, onSuccess, onError){
        if(typeof(onSuccess) !== 'function'){
            onSuccess = angular.noop;
        }
        if(typeof(onError) !== 'function'){
            onError = angular.noop;
        }
       
        return restService.doPOST('newsletters/form/save', data, function successCallback(response){
            onSuccess(response);
        }, function errorCallback(response){
            onError(response.errorMessage || 'Not error specified', response.errorCode || 'No Message specified', response);
        });
    }   
}