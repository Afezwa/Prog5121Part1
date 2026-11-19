/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.iie.chatapppart1;
 
 import javax.swing.JOptionPane;
 import java.util.Scanner;
 import java.util.ArrayList;
/**
 *
 * @author Student
 */
public class MainApp  {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        // Fixed: Created Login with empty constructor - will save in registerUser
        Login login = new  Login();
        
        //   Registration Section
        
        System.out.println(" USER REGISTRATION ");
        
        System .out.print("Enter your first name");
               String firstName = sc.nextLine();
            
        System.out.print("Enter your last name");
               String lastName = sc.nextLine();
               
        System.out.print("Enter a username: ");
              String username = sc.nextLine();
              
        System.out.print("Enter a password: ");
              String password = sc.nextLine();
              
              System.out.print("Enter cell number (+27...): ");
               String cellPhoneNumber = sc.nextLine();
              
        System.out.println(login.registerUser(username, password, cellPhoneNumber, firstName, lastName));
        
// --- Login ---

System.out.print("Enter username to login: ");
 String loginUser = sc.nextLine();
 
System.out.print("Enter password to login: ");
 String loginPass = sc.nextLine();
 
  boolean success = login.loginUser(loginUser, loginPass);
  
System.out.println(login.returnLoginStatus(success));
   if (!success) {
       return;
   }
   
 System.out.println("Welcome to QuickChat.");

            ArrayList<Message> sentMessages = new ArrayList<>();
            ArrayList<Message> storedMessages = new ArrayList<>();
            ArrayList<String> disregardedMessages = new ArrayList<>();
            ArrayList<String> messageHashes = new ArrayList<>();
            ArrayList<String> messageIDs = new ArrayList<>();
            
     boolean running = true;
     while (running) {
         
         System.out.println("\nWelcome to QuickChat");
           System.out.println("1) Add Message");
           System.out.println("2) Coming Soon");
           System.out.println("3) Quit");
           System.out.println("4) Stored Messages");
           System.out.println("Choose: ");
           
           String choice = sc.nextLine();
           
               if (choice.equals("1")) {
                   System.out.print("How many messages do you want to send? ");
                   
                   int num = Integer.parseInt(sc.nextLine());
                   
                   for (int i = 0; i < num; i++) {
                       
                       System.out.print("Enter recipient (+27...) :");
                       String recipient = sc.nextLine();
                       
                       System.out.print("Enter message (max 250 chars): ");
                       String text = sc.nextLine();
                       
                       Message m = new Message(recipient, text, sentMessages.size());
                       
                       // Validation
                       
                       System.out.println(m.checkRecipientCell());
                       
                       System.out.println(m.checkMessageLength());
                       
                       sentMessages.add(m);
                       disregardedMessages.add(m.getMessage());
                       storedMessages.add(m);
                       m.storeMessage();
                       
                       
                       if(! m.checkRecipientCell().equals("Cell phone number successfully captured.")
                               || ! m.checkMessageLength().equals("Message ready to send.")) {
                           
                           System.out.println("Message not sent, try again.");
                           continue;
                       }
                       // This is the fix
                       
             System.out.println("Choose an option:");
             
             System.out.println("1) Send Message");
             
             System.out.println("2) Disregard Message");
             
             System.out.println("3) Store Message");
             
             System.out.print("Choice: ");
             String opt = sc.nextLine();
             
             if (opt.equals("1")) {
                 
                 sentMessages.add(m);
                 
                 System.out.println(m.sentMessage(1));
                 
                 System.out.println("message ID: " + m.getMessageID());
                 
                 System.out.println("Recipient: " + m.getRecipient());
                 
                 System.out.println("Message: " + m.getMessage());
             } else if
                     (opt.equals("2")) {
                 
                 disregardedMessages.add(m.getMessage());
                 
                 System.out.println(m.sentMessage(2));
             } else if
                 (opt.equals("3")) {
                 storedMessages.add(m);
                 
                 m.storeMessage(); 
                 
                 System.out.println(m.sentMessage(3));
             }
                   }
                   
                   if (! sentMessages.isEmpty()) {
                       
                       System.out.println("\n--- Sent Messages ---");
                       
                       Message.printMessages(sentMessages);
                   }
             } 
               else if
                     (choice.equals("2")) {
                 
                 System.out.println("Coming Soon.");
             } 
               else if
                     (choice.equals("3")) {
                 
                 System.out.println("Total messages sent: " + sentMessages.size());
                 running = false;
             } 
               else if  (choice.equals("4")) {
                 loadStoredFromJSON(storedMessages);
                 showStoredMessagesMenu(sc, storedMessages, sentMessages);
             } 
               else{
         
         System.out.println("Invalid option.");
             }
             
             
                   }
     sc.close();
               }
    
    public static void showStoredMessagesMenu(Scanner sc, ArrayList<Message> stored, ArrayList<Message> sent){
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Stored Messages ---");
            System.out.println("a) Display sender and recipient of stored messages");
            System.out.println("b) Display longest stored message");
            System.out.println("c) Search by Message ID");
            System.out.println("d) Search by Recipient");
            System.out.println("e) Delete by Message Hash");
            System.out.println("f) Display Report");
            System.out.println("g) Back");
            System.out.println("Choose: ");
            String c = sc.nextLine().toLowerCase();
            
            if (c.equals("a")){
                for (Message m : stored) {
                    
                    System.out.println("Sender: " + m.getMessageID() + " | Recipient: " + m.getRecipient());
                }
                if (stored.isEmpty())
                    System.out.println("No stored messages.");
            }
            else if (c.equals("b")) {
                
                Message longest = null;
                for (Message m : stored) {
                    if (longest == null || m.getMessage().length() > longest.getMessage().length()) {
                        longest = m;
                        
                    }
                }
                if (longest != null)
                    System.out.println("Longest: " + longest.getMessage());
            }
            else if (c.equals("c")) {
                
                System.out.println("Enter Message ID: ");
                String id = sc.nextLine();
                boolean found = false;
                for (Message m : stored) {
                    if 
                            (m.getMessageID().equals(id) || m.getRecipient().equals(id)) {
                        
                        System.out.println("Recipient: " + m.getRecipient());
                        
                        System.out.println("Message: " + m.getMessage());
                        
                        found = true;
                    }
                }
                for (Message m : sent) {
                    if
                            (m.getMessageID().equals(id) || m.getRecipient().equals(id)) {
                        
                        System.out.println("Recipient: " + m.getRecipient());
                        System.out.println("Message: " + m.getMessage());
                        found = true;
                    }
                }
                if (!found)
                    System.out.println("Message ID not found.");
            }
            else if (c.equals("d")) {
                System.out.println("Enter Recipient: ");
                String rec = sc.nextLine();
                for (Message m : stored) {
                    if 
                            (m.getRecipient().equals(rec)) {
                        
                        System.out.println(m.getMessage());
                    }
                }
                for (Message m : sent) {
                    if
                            (m.getRecipient().equals(rec)) {
                        System.out.println(m.getMessage());
                    }
                }
            }
            else if (c.equals("e")) {
                System.out.println("Enter Message Hash: ");
                String hash = sc.nextLine();
                Message toRemove = null;
                for (Message m : stored) {
                    if
                            (m.createMessageHash().equals(hash)) {
                        toRemove = m;
                        break;
                    }
                }
                if  (toRemove != null) {
                    stored.remove(toRemove);
                    
                    System.out.println("Message: \"" + toRemove.getMessage() + "\" successfully deleted.");
                }
                else {
                    System.out.println("Hash not found.");
                }
            }
            else if (c.equals("f")) {
                System.out.println("\n--- Full Report ---");
                for (Message m : stored) {
                    
                    System.out.println("Message Hash: " + m.createMessageHash());
                    
                    System.out.println("Recipient: " + m.getRecipient());
                    
                    System.out.println("Message: " + m.getMessage());
                    
                    System.out.println("-------------------");
                }
            }
            else if (c.equals("g")) {
                back = true;
            }
            }
    }
    
    public static void loadStoredFromJSON(ArrayList<Message> stored) {
        try {
            String content = new 
                String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get("storedMessages.json")));
            
            if (stored.isEmpty() && content.contains("message")) {
                System.out.println("Loaded stored messages from storedMessages.json");
            }
        } catch (Exception e) {
        }
        }
}

    
        
    
                
            
        
    
     
 
              
              
                

    
        




