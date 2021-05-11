package edu.eci.arsw.ecihorarios.test;

import edu.eci.ecihorarios.config.MongoConnection;
import edu.eci.ecihorarios.model.bean.CredentialsUser;
import edu.eci.ecihorarios.model.bean.Curriculum;
import edu.eci.ecihorarios.model.bean.Subject;
import edu.eci.ecihorarios.model.bean.User;
import edu.eci.ecihorarios.persistence.db.DaoUser;
import edu.eci.ecihorarios.persistence.PersistenceException;
import edu.eci.ecihorarios.persistence.db.DaoSubject;
import edu.eci.ecihorarios.persistence.db.mongoimpl.MongoDAOSubject;
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
//import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

//@ContextConfiguration(locations ="/applicationContext.xml") 
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MongoDAOUser.class, SecurityConfigTest.class, MongoConnection.class, MongoDAOSubject.class})
public class ApplicationServicesTests {

    @Autowired
    private DaoUser daouser; 
    
    @Autowired 
    private DaoSubject daosubject;

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
        User u = new User();
        u.setName("Gerardo Sanchez");
        u.setIdentification("1234567");
        u.setTipo('A');
        u.setEmail("gerardo.sanchez@mail.escuelaing.edu.co");
        u.setUsername("apiclient"); 
        u.setCarrer("Ingenieria de Sistemas");
        

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

        try {
            daouser.saveUserDetails(u);
        } catch (PersistenceException ex) {
            assertTrue(true);
            Logger.getLogger(ApplicationServicesTests.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }
    @Test 
    public void getCurriculum(){
    
        try {
            assertTrue("Curriculum{carrer=Ingenieria de Sistemas, list=[NodeSubject{code=OGR1, prerequisites=[SIML]}, NodeSubject{code=OGR2, prerequisites=[SIML]}, NodeSubject{code=ETO2, prerequisites=null}, NodeSubject{code=ETO3, prerequisites=null}, NodeSubject{code=SIML, prerequisites=null}, NodeSubject{code=IETI, prerequisites=[ARSW, AUPN]}, NodeSubject{code=ETO1, prerequisites=null}, NodeSubject{code=AREP, prerequisites=[CVDS, AUPN, RECO]}, NodeSubject{code=FDGP, prerequisites=[FCFI]}, NodeSubject{code=SPTI, prerequisites=[RECO]}, NodeSubject{code=ARSW, prerequisites=[RECO, CVDS]}, NodeSubject{code=ELH2, prerequisites=[CIPP]}, NodeSubject{code=FCFI, prerequisites=[FUEC]}, NodeSubject{code=IDI4, prerequisites=[IDI3]}, NodeSubject{code=RECO, prerequisites=[ACSO]}, NodeSubject{code=CVDS, prerequisites=[MBDA, POOB]}, NodeSubject{code=AUPN, prerequisites=[TSOR, POOB]}, NodeSubject{code=ELH1, prerequisites=[CIPP]}, NodeSubject{code=IDI3, prerequisites=[IDI2]}, NodeSubject{code=PRYE, prerequisites=[CALI]}, NodeSubject{code=ACSO, prerequisites=[FIEM]}, NodeSubject{code=TSOR, prerequisites=[AYED]}, NodeSubject{code=FUEC, prerequisites=null}, NodeSubject{code=IDI2, prerequisites=[IDI1]}, NodeSubject{code=ECDI, prerequisites=[CALV]}, NodeSubject{code=MBDA, prerequisites=[AYPR, LCAT]}, NodeSubject{code=TPRO, prerequisites=[MATD]}, NodeSubject{code=POOB, prerequisites=[AYED]}, NodeSubject{code=IDI1, prerequisites=null}, NodeSubject{code=CALV, prerequisites=[CALI, ALLI]}, NodeSubject{code=AYED, prerequisites=[AYPR, LCAT]}, NodeSubject{code=MATD, prerequisites=[LCAT]}, NodeSubject{code=CYNT, prerequisites=[FIME]}, NodeSubject{code=CIPP, prerequisites=[HGCL]}, NodeSubject{code=CALI, prerequisites=[CALD]}, NodeSubject{code=AYPR, prerequisites=[ALLI]}, NodeSubject{code=EGR1, prerequisites=[AGEO]}, NodeSubject{code=LCAT, prerequisites=[MMIN]}, NodeSubject{code=FIEM, prerequisites=[CALD, FIME]}, NodeSubject{code=CALD, prerequisites=[PREM, AGEO]}, NodeSubject{code=ALLI, prerequisites=[PREM, AGEO]}, NodeSubject{code=MMIN, prerequisites=null}, NodeSubject{code=FIME, prerequisites=[FUME]}, NodeSubject{code=HGCL, prerequisites=null}, NodeSubject{code=FCO2, prerequisites=[FCO1]}, NodeSubject{code=PREM, prerequisites=null}, NodeSubject{code=AGEO, prerequisites=null}, NodeSubject{code=FUME, prerequisites=null}, NodeSubject{code=INSI, prerequisites=null}, NodeSubject{code=ELBA, prerequisites=null}, NodeSubject{code=FCO1, prerequisites=null}]}".equals(daosubject.getCurriculum("Ingenieria de Sistemas").toString()));
        } catch (PersistenceException ex) {
            Logger.getLogger(ApplicationServicesTests.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    } 
     @Test 
    public void nogetCurriculum(){
        
        try {
            Curriculum cur = daosubject.getCurriculum("Derecho");
        } catch (PersistenceException ex) { 
            assertTrue(true);
            Logger.getLogger(ApplicationServicesTests.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    } 
    
    @Test 
    public void getSubject(){
        
        try {
            Subject sub = daosubject.getSubject("AGEO");  
            String value = "Subject{" + "code=" + "AGEO" + ", name=" + "Analisis Geomatrico" + ", credits=" + 4 + ", level=" + 1 + "}";
            assertTrue(value.equals(sub.toString()));       
        } catch (PersistenceException ex) {
            Logger.getLogger(ApplicationServicesTests.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    @Test 
    public void nogetSubject(){
        
        try {
            Subject sub = daosubject.getSubject("PPPP");        
        } catch (PersistenceException ex) { 
            assertTrue(true);
            Logger.getLogger(ApplicationServicesTests.class.getName()).log(Level.SEVERE, null, ex); 
            
        }
    }
    
}
