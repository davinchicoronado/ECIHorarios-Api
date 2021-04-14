var apiclient = (function () { 
    
    var Url = 'https://ecihorarios.herokuapp.com/ecihorarios/';
  
    return{
          checkUser : function(username,password,callback){
              
              $.get(Url+username+"/"+password, function(resp){
                  callback(resp);
              });
          },
          
          getUser : function(username,callback){
              $.get(Url+username, function(resp){
                  callback(resp);    
              });
     
          }, 
          
          getSubjectAvailable: function(username,callback){
              $.get(Url+"/subjects/"+username, function(resp){
                  callback(resp);    
              });
              
          }, 
          getSchedule: function(idschedule,callback){
             $.get(Url+"/schedule/"+idschedule, function(resp){
                  callback(idschedule,resp);    
              });
              
          }, 
          
          saveSchedule:function(username,subjects,callback){   
                $.ajax({
                        type: 'POST',
                        url: Url+username,
                        contentType: 'application/json',
                        data: JSON.stringify(subjects),
                        success: function(resp){
                            callback();
                        }
                    });              
              callback();
              
          }
          
    };
})();