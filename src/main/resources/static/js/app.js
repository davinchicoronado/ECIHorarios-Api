var app = (function(){  
    
    var direction = "js/apiclient.js";
    var username;
    var user;
  
    
    var checkLoginUser= function(uname,value){
        username=uname;
        $.getScript(direction,function(){        
            apiclient.checkUser(username,value,callbackLog);  
        });
        
    };
    
    var getUser = function(){
        
        
    };
    
    var callbackLog = function(resp){
        if(resp.status){
            getUser();
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