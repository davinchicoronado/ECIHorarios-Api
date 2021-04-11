var app = (function(){  
    
    var direction = "js/apiclient.js";
    
    
    var checkLoginUser= function(username,value){
        $.getScript(direction,function(){        
            apiclient.checkUser(username,value,callbackLog);  
        });
        
    };
    
    var callbackLog = function(resp){
        if(resp.status){
            window.location.replace("menu.html");        
        }else{
            alert("Username or Password incorrect");
            
        }   
    };
    
    
    return{
      loginUser:function(username,password){
          checkLoginUser(username,password); 
          event.preventDefault();
      }  
        
        
    };



})();