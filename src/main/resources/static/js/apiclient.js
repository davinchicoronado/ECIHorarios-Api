var apiclient = (function () { 
    
    var Url = 'http://localhost:8080/ecihorarios/';
  
    return{
          checkUser : function(username,password,callback){
              
              $.get(Url+username+"/"+password, function(resp){
                  callback(resp);
              });
              
          }   
    };
})();