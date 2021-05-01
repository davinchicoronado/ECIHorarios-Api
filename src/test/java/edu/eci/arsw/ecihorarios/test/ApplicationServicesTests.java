package edu.eci.arsw.ecihorarios.test;


import edu.eci.ecihorarios.model.bean.CredentialsUser;
import edu.eci.ecihorarios.persistence.db.DaoUser;
import edu.eci.ecihorarios.persistence.db.PersistenceException;
import edu.eci.ecihorarios.persistence.db.mongoimpl.MongoDAOUser;
import edu.eci.ecihorariosapi.SecurityConfigTest;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired; 
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner; 



@ContextConfiguration(locations ="/applicationContext.xml") 
@RunWith(SpringRunner.class)  
@SpringBootTest(classes = {MongoDAOUser.class, SecurityConfigTest.class}) 
public class ApplicationServicesTests {
    
    @Autowired
    private DaoUser daouser; 
    
    @Autowired 
    private BCryptPasswordEncoder encoder;
    
    /**
    @Test 
    public void saveUser() { 
        
        CredentialsUser user = new CredentialsUser(); 
        user.setUsername("david.coronado");
        user.setPassword(encoder.encode("admin123"));
      
        
        daouser.saveUser(user);  
        
        assertTrue(user.getPassword().equals(daouser.getUser("david.coronado").getPassword()));
    }
    **/ 
    
    @Test 
    public void nosaveUser() {
        CredentialsUser user = new CredentialsUser(); 
        user.setUsername("david.coronado");
        user.setPassword(encoder.encode("admin123"));
      
        
        try {  
            daouser.saveUser(user);
        } catch (PersistenceException ex) {
            Logger.getLogger(ApplicationServicesTests.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(true);         
        }
    }

    @Test 
    public void nogetUser() {
            
        try {
            daouser.getUser("pepito.perez");
        } catch (PersistenceException ex) {
            Logger.getLogger(ApplicationServicesTests.class.getName()).log(Level.SEVERE, null, ex); 
            assertTrue(true);
        }
        
    }
}
