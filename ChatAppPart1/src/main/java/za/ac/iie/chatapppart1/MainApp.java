/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.iie.chatapppart1;

 import java.util.Scanner;
/**
 *
 * @author Student
 */
public class MainApp  {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        // Fixed: Created Login with empty constructor - will save in registerUser
        Login login = new  Login();
        
        //   Registration Section
        
        System.out.println("=== USER REGISTRATION ===");
        
        System .out.print("Enter your first name");
               String firstName = input.nextLine();
            
        System.out.print("Enter your last name");
               String lastName = input.nextLine();
               
        System.out.print("Enter a username: ");
              String username = input.nextLine();
              
        System.out.print("Enter a password: ");
              String password = input.nextLine();
              
        System.out.print("Enter your South African cell number (+27...):");
              String cellPhoneNumber = input.nextLine();
              
              String response = login.registerUser(firstName, lastName, username, password, cellPhoneNumber);
                 System.out.println(response);
                 
                 //If registration failed, stop the program
                 if (!response.equals("User registered successfully.")) {
                     System.out.println("Registration failed. Please try again.");
                     return;
                 }
                 
                 // LOGIN SECTION
                 System.out.println("\n=== USER LOGIN ===");
                 
                 System.out.print("Enter your username:");
                 String loginUsername = input.nextLine();
                 
                 System.out.print("Enter your password:");
                 String loginPassword = input.nextLine();
                 
                 //Call loginUser to check if details match the stored ones
                 boolean loggedIn = login.loginUser(loginUsername, loginPassword);
                 
                 //Print out correct login message
                 String loginMessage = login.returnLoginStatus(loggedIn);
                 System.out.println(loginMessage);
    }
}
