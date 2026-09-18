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

    String firstName;
    String lastName;        
    String username;
    String password;
    String cellPhoneNumber;
    
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
    
    //Step 7: Cell number validation - using researched regex
    //Regex source: W3Schools Java RegEx Article and StackOverFlow - South African mobile number validation
    //URL: https://www.w3schools.com/java/java_regex.asp AND https://stackoverflow.com/questions/15739050/south-african-mobile-number-regex
    //Accessed: 2026-09-17
    //The pattern ^\+27\d{9}$ checks that number starts with +27 and has exactly 9 more digits (total 12 chars with +)
    public boolean checkCellPhoneNumber(String phone) {
        return phone.matches("^\\+27\\d{9}$");
    }
    
    //Step 8: Register user - returns the EXACT messages they want
    public String registerUser(String firstName, String lastName, String username, String password, String cellPhoneNumber) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number and a special character";
        }
        if (!checkCellPhoneNumber(cellPhoneNumber)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;      

        return "User registered successfully.";

    }
    
    //Step 9: Login feature
    public boolean loginUser(String username, String password) {
        return this.username != null && this.username.equals(username) && this.password.equals(password);
    }
    
    public String
            returnLoginStatus(boolean success) {
                if (success){

                    return "Welcome " + firstName + "" + lastName + " it is great to see you again.";

                } else {
                    return "Username or password incorrect, please try again.";
                }
            }
}
