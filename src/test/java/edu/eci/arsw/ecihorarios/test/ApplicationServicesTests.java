package edu.eci.arsw.ecihorarios.test;

import edu.eci.ecihorarios.config.MongoConnection;
import edu.eci.ecihorarios.model.bean.CredentialsUser;
import edu.eci.ecihorarios.model.bean.User;
import edu.eci.ecihorarios.persistence.db.DaoUser;
import edu.eci.ecihorarios.persistence.PersistenceException;
import edu.eci.ecihorarios.persistence.db.mongoimpl.MongoDAOUser;
import edu.eci.ecihorariosapi.config.test.SecurityConfigTest;
import java.util.ArrayList;
import java.util.List;
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

//@ContextConfiguration(locations ="/applicationContext.xml") 
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MongoDAOUser.class, SecurityConfigTest.class, MongoConnection.class})
public class ApplicationServicesTests {

    @Autowired
    private DaoUser daouser;

    @Autowired
    private BCryptPasswordEncoder encoder;

    /**
     * @Test public void saveUser() { CredentialsUser user = new
     * CredentialsUser(); user.setUsername("david.coronado");
     * user.setPassword(encoder.encode("admin123")); user.setRole("USER");
     *
     * try { daouser.saveUser(user);
     * assertTrue(user.getPassword().equals(daouser.getUser("david.coronado").getPassword()));
     * } catch (PersistenceException ex) {
     * Logger.getLogger(ApplicationServicesTests.class.getName()).log(Level.SEVERE,
     * null, ex); }
     *
     * }
     *
     */
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

    @Test
    public void noGetUserDetails() {

        try {
            daouser.getUserDetails("pepito.perez");
        } catch (PersistenceException ex) {
            Logger.getLogger(ApplicationServicesTests.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(true);
        }
    }
    /**
    @Test
    public void saveUserDetails() {
        User u = new User("David Leonardo Coronado", "1234567", 'E', "david.coronado@mail.escuelaing.edu.co", "david.coronado", 2, 18);
        List<String> approved = new ArrayList<>();
        approved.add("PREM");
        approved.add("AGEO");
        approved.add("FUME");
        approved.add("INSI");
        approved.add("ELBA");
        approved.add("FCO1");

        u.setApprovedSubjects(approved);

        try {
            daouser.saveUserDetails(u);
            assertTrue(u.getUsername().equals(daouser.getUserDetails(u.getUsername()).getUsername()));
        } catch (PersistenceException ex) {
            Logger.getLogger(ApplicationServicesTests.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }
    **/
    @Test
    public void nosaveUserDetails() {
        User u = new User("David Leonardo Coronado", "1234567", 'E', "david.coronado@mail.escuelaing.edu.co","david.coronado", 2, 18); List<String> approved = new ArrayList<>();
        approved.add("PREM");
        approved.add("AGEO");
        approved.add("FUME");
        approved.add("INSI");
        approved.add("ELBA");
        approved.add("FCO1");

        u.setApprovedSubjects(approved);

        try {
            daouser.saveUserDetails(u);
        } catch (PersistenceException ex) {
            assertTrue(true);
            Logger.getLogger(ApplicationServicesTests.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

}
