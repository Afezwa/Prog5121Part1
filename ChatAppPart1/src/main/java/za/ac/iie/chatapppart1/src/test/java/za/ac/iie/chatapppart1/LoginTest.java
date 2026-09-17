/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.iie.chatapppart1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

        
/**
 *
 * @author Student
 */
public class LoginTest {
    
    String validUsername = "kyl_1";
    String invalidUsername = "kyl!!!!!!!!!!!!!";
    String validPassword = "Ch@ke99";
    String invalidPassword = "password";
    String validCellPhoneNumber = "+27838699867";
    String invalidCellPhoneNumber = "0838699867";
    String firstName = "Kyle";
    String lastName = "Smith";
    
    @Test
    public void testCheckUserName_CorrectlyFormatted(){
        Login login = new Login();
        
        assertTrue(login.checkUserName(validUsername), "kyl_1 should be valid - contains _ and <=5 chars");
    }
    @Test
    public void  testCheckUserName_IncorrectlyFormatted(){
        Login login = new Login();
        
        assertFalse(login.checkUserName(invalidUsername), "kyle!!!!!!!!! should be invalid");
    }
    
    @Test
    public void testCheckPasswordComplexity_MeetsRequirements(){
        Login login = new Login();
        
        assertTrue(login.checkPasswordComplexity(validPassword), "Ch&sec@ke99! meets all requirements");
    }
      
    @Test
    public void testCheckPasswordComplexity_DoesNotMeetRequirements(){
        Login login = new Login();
        
        assertFalse(login.checkPasswordComplexity(invalidPassword), "password should fail");
    }
    
    @Test
    public void testCheckCellPhoneNumber_CorrectlyFormatted(){
        Login login = new Login();
        assertTrue(login.checkCellPhoneNumber(validCellPhoneNumber), "+27838699867 should be valid");
    }
    
    @Test
    public void testCheckCellPhoneNumber_IncorrectlyFormatted(){
        Login login = new Login();
        assertFalse(login.checkCellPhoneNumber(invalidCellPhoneNumber), "0838699867 should be invalid - no +27");
    }
    
    @Test
    public void testRegisterUser_Successful(){
        Login login = new Login();
        String result = login.registerUser(firstName, lastName, validUsername, validPassword, validCellPhoneNumber);
        assertEquals("User registered successfully.", result);
    }
    
    @Test
    public void testLoginUser_Successful(){
        Login login = new Login();
        login.registerUser(firstName, lastName, validUsername, validPassword, validCellPhoneNumber);
        assertTrue(login.loginUser(validUsername, validPassword));
        assertEquals("Welcome Kyle Smith it is great to see you again.", login.returnLoginStatus(true));
    }
    
    @Test
    public void testLoginUser_Failed(){
        Login login = new Login();
        login.registerUser(firstName, lastName, validUsername, validPassword, validCellPhoneNumber);
        assertFalse(login.loginUser(validUsername, "wrongPassword"));
        assertEquals("Username or password incorrect, please try again.", login.returnLoginStatus(false));
    }
    
    @Test 
    public void testReturnLoginStatus_Messages(){
        Login login = new Login();
        login.registerUser(firstName, lastName, validUsername, validPassword, validCellPhoneNumber);
        
        String successMsg = "Welcome " + firstName + lastName + "it is great to see you again.";
        String failMsg = "Username or password incorrect, please try again.";
        
        assertEquals(successMsg, login.returnLoginStatus(true));
        assertEquals(failMsg, login.returnLoginStatus(false));
    }
}

