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
              
              String response = login.registerUser(username, password, cellPhoneNumber, firstName, lastName);
                 System.out.println(response);
                 
                 //If registration failed, stop the program
                if (response.contains("incorrectly") 
                        || response.contains("not correctly"))
                        {
                            return;
                                    }
                        
                 // LOGIN SECTION
                 System.out.println("\n=== USER LOGIN ===");
                 
                 System.out.print("Enter your username:");
                 String loginUsername = input.nextLine();
                 
                 System.out.print("Enter your password:");
                 String loginPassword = input.nextLine();
                 
                 //Print out correct login message
                 String loginMessage = login.returnLoginStatus(loginUsername, loginPassword);
                 System.out.println(loginMessage);   

    // Part 2: Messaging
    if (!loginMessage.contains("Welcome"))
    {
    System.out.println("Login failed. Exiting.");
    return;
}
    System.out.println("\nWelcome to QuickChat.");
    
    // Storage for sent messages
    String[] sentMessages = new String[100] ;
    String[] sentRecipients = new String[100];
    String[] sentIDs = new String[100];
    String[] sentHashes = new String[100];
    int totalMessages = 0;
    
    while (true) {
        System.out.println("\nMenu:");
        System.out.println("1) Send Messages");
        System.out.println("2) Show recently sent messages");
        System.out.println("3) Quit");
        System.out.println("Choose an option:");
        String option = input.nextLine();
    
    if(option.equals("1")) {
    System.out.println("How many messages do you wish to send? ");
    int numMessages = Integer.parseInt(input.nextLine());
    
    for(int i = 0; i < numMessages; i++) {
    System.out.println("Enter recipient number: ");
       String recipient = input.nextLine();
    
       System.out.println("Enter message: ");
          String messageText = input.nextLine();
    
    // Message class: new Message(recipient, messageText, index)
    Message msg = new Message(recipient, messageText, totalMessages);
    
    //Check recipient
    String recipientResult = msg.checkRecipientCell();
    System.out.println(recipientResult);
    if
            (recipientResult.contains("incorrectly")) {
    continue; 
    // Skip this message
}
    //Check length
    String lengthResult = msg.checkMessageLength();
    System.out.println(lengthResult);
    if
            (lengthResult.contains("exceeds")) {
    continue;
}
    //Store it
    sentRecipients[totalMessages] = recipient;
        sentMessages[totalMessages] = messageText;
        sentIDs[totalMessages] = msg.getMessageID();
        sentHashes[totalMessages] = msg.createMessageHash();
    totalMessages++;
    
    System.out.println("Message successfully sent.");
    System.out.println("Message ID: " + msg.getMessageID());
    System.out.println("Message Hash: " + msg.createMessageHash());
}
    
}else if (option.equals("2")) {
    System.out.println("\n=== Recently Sent Messages ===");
    if (totalMessages == 0) {
    System.out.println("No messages sent yet.");
} else {
    for (int j = 0; j < totalMessages; j++) {
    System.out.println("To: " + sentRecipients[j]);
    
    System.out.println("Message: " + sentMessages[j]);
    System.out.println("ID: " + sentIDs[j]);
    System.out.println("Hash: " + sentHashes[j]);
    System.out.println("___");
}
   }
 }else if (option.equals("3")) {
    System.out.println("Total messages sent: " + totalMessages);
    System.out.println("Goodbye!");
    break;
} else {
    System.out.println("Invalid option. Try again.");
     } 
    }
    }
}
    
        




