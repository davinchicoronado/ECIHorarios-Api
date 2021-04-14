var app = (function(){  
    
    var direction = "js/apiclient.js";
    var username;
    var user;
    var view = "#login";
    var subjects;
    var idSubject; 
    var creditsLimitcopy; 
    var creditsCurrentSub;
    
    var checkLoginUser= function(uname,value){
        username=uname;
        $.getScript(direction,function(){        
            apiclient.checkUser(username,value,callbackLog);  
        });
        
    };
    
    var getUser = function(){ 
       
       $.getScript(direction,function(){        
            apiclient.getUser(username,callbackUser);  
        });
        
    }; 
    
    var getAvailableSubject = function(){
        
       
       subjects=[]; 
       creditsLimitcopy=user.limitCredits;
       $.getScript(direction,function(){        
            apiclient.getSubjectAvailable(username,callbackSubjects);  
        });
        

      
        
    }; 
    
    var getSchedule = function(){ 
        
        
        $( "#TableSubject tbody tr" ).on( "click", function() {
            var currentRow=$(this).closest("tr");
            idSubject = currentRow.find("td:eq(0)").text().trim();
            nameSchedule = currentRow.find("td:eq(1)").text().trim(); 
            creditsCurrentSub = parseInt(currentRow.find("td:eq(2)").text().trim()); 
            
            
            
            $("#titleSchedule").empty();
            
            
            $("#titleSchedule").html(`${nameSchedule}`); 
            
            $.getScript(direction,function(){        
                apiclient.getSchedule(idSubject,callbackSchedule);  
            });
            
         });
        
        
    };
    var enrollSubject = function(){
        
        
        $( "#TableSchedule" ).on( "click",".btn", function() { 
            
            if(creditsLimitcopy-creditsCurrentSub<0){
                alert("No tienes mas creditos");
            }
            else{
                var currentRow=$(this).closest("tr");

                var groupid = currentRow.find("td:eq(0)").text().trim();

                creditsLimitcopy = creditsLimitcopy-creditsCurrentSub;
                $("#credits").html("Creditos: "+`${creditsLimitcopy}`);



                subjects.push({group:parseInt(groupid),subjectid:idSubject});

                
                alert("Materia Agregada"); 
                $(".btn-primary").attr("disabled", true);
            }
             
            
        });
        
        
    }; 
    
    var saveSchedule = function(){
        if(subjects.length==0){
            alert("Debes agregar alguna materia"); 
            
        }
        else{
            $.getScript(direction,function(){        
                apiclient.saveSchedule(user.name,subjects,callbacksaveSchedule);  
            });
            
        }
    }; 
    var queryScheduleStudents = function(){ 
        
           
            hideCurrentView();
            $("#HorariosEst").show();
            view="#HorariosEst";
        
        
    };

    
    //Permite consultar los datos al usuario y ver el menu
    var callbackLog = function(resp){
        if(resp.status){
            getUser();
  
            hideCurrentView();
            $("#menu").show(); 
            $("#Inicio").show();
            view="#Inicio";
            
        }else{
            alert("Username or Password incorrect");
        }   
    }; 
    
 
    //Permite guardar la información del usuario
    var callbackUser = function(resp){
        user=resp;
    };
    
    var callbackSubjects = function(resp){
        
        
        $("#credits").html("Creditos: "+`${creditsLimitcopy}`);
        $("#saveSchedule").hide();
        
        hideCurrentView();
        $("#Preinscribir").show();
        view = "#Preinscribir";
       
        $("#tbody2").empty();
        $("#tbody").empty(); 
        
        for(let subject of resp){
            $("#tbody").append(
                  `
                      <tr onclick="app.getSchedule()">
                       <td>${subject.id} </td>
                       <td>${subject.name}</td>
                       <td>${subject.credits}</td>
                       <td>${subject.level}</td>
                      </tr>
                      `
                    );
            
        }
        
        
    };
  
    var callbackSchedule = function(idSchedule, resp){ 
        
        
        $("#saveSchedule").show();
        $("#tbody2").empty(); 
        
        for(let schedule of resp){
            $("#tbody2").append(
                   `
                   <tr> 
                       <td>${schedule.numGroup} </td>
                       <td>${schedule.teacher}</td>
                       <td>${schedule.limit}</td>
                       <td>
                            <table class="table"  id="Subtable">
                                        <tr>
                                              <th>Hora</th>
                                              <th>Salon</th>
                                              <th>Dia</th>
                                        </tr>
                                        <tbody id=${schedule.numGroup}>


                                        </tbody>

                            </table>  
            
                       </td>   
                       <td onClick="app.enrollSubject()"><button class="btn btn-primary">Enroll</button></td>
                   </tr>
                    `
                    );
            
            
        } 
        isAddSchedule(idSchedule);
        for(let schedule of resp){ 
            for(let group of schedule.lessons){
                
                $("#"+`${schedule.numGroup}`).append(
                        `
                        <tr>
                            <td>${group.hour} </td>
                            <td>${group.classRoom}</td>
                            <td>${group.day}</td>
                        </tr>
                        `
                        );
                
            }
        }
        
    }; 
    
    var callbacksaveSchedule = function(){
            
            alert("Horario Guardado");
            
            hideCurrentView();
            
            $("#Inicio").show(); 
            view = "#Inicio";
            
        
    };
    
    var isAddSchedule = function(idSch){
        if(!(subjects.length==0)){
            for(let subject of subjects){
                if(subject.subjectid==idSch){
                    
                    $(".btn-primary").attr("disabled", true);
                }
            }
            
        }
        
    }; 
    
    var viewMenu = function(){
        
        hideCurrentView();
        $("#Inicio").show();
        view = "#Inicio";
    };
        
    var hideCurrentView = function(){
        $(view).hide();
        
    };
    
    return{
      loginUser:function(username,password){
          checkLoginUser(username,password); 
          event.preventDefault();
      },
      querySubject :function(){
          getAvailableSubject();
          event.preventDefault();
      },
      getSchedule: function(){
          getSchedule();
          event.preventDefault();
      },
      
      enrollSubject: function(){ 
          enrollSubject();
          event.preventDefault();
      },
      
      saveSchedule: function(){
          saveSchedule();
          event.preventDefault();
      },
      
      menuIni:function(){ 
            viewMenu(); 
            event.preventDefault();
      }, 
      queryScheduleStudents:function(){
          queryScheduleStudents();
          event.preventDefault();
      },
      
      exit : function(){
          hideCurrentView();
          $("#menu").hide();
          $("#login").show();
          view = "#login";
          
      }
      
      
    };



})();