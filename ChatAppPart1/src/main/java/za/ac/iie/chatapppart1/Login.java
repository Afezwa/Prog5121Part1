/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.iie.chatapppart1;

/**
 *
 * @author Student
 */
public class Login  {
    String username;
    String password;
    String cellNumber;
    
    // Step 5: Username validation - must contain _ and <= 5 chars
    public boolean checkUserName(String username){
        return username.contains("_") && username.length() <= 5;
    }
    
    //Step 6: Password validation - 8 chars, capital, number, special char
    public boolean checkPasswordComplexity(String password)  {
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;
        
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if(Character.isUpperCase(c)) {
                hasCapital = true ; }
            else if (Character.isDigit(c)) {
                hasNumber = true;}
            else if (!Character.isLetterOrDigit(c)){
                hasSpecial = true;
            
            }
        }
        
        return password.length() >= 8 && hasCapital && hasNumber && hasSpecial;
    }
    
    //Step 7: Cell number validation - must start with +27 and <=12 chars
    public boolean checkCellPhoneNumber(String phone) {
        return phone.startsWith("+27") && phone.length() <= 12;
    }
    
    //Step 8: Register user - returns the EXACT messages they want
    public String registerUser(String username, String password, String phoneNumber) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more that five characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the passwprd contains at least eight characters, a capital letter, a number and a special character";
        }
        if (!checkCellPhoneNumber(phoneNumber)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
        this.username = username;
        this.password = password;
         this.cellNumber = phoneNumber;      
         return "User registered successfully.";
    }
    
    //Step 9: Login feature
    public boolean loginUser(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
    
    public String
            returnLoginStatus(boolean success) {
                if (success){
                    return "Welcome" + username + "it is great to see you agan.";
                } else {
                    return "Username or passsword incorrect, please try again.";
                }
            }
}
