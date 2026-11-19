/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.iie.chatapppart1;

import java.util.Random;
import java.io.File;
import java.nio.file.Files;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Student
 */
public class Message {
    private String messageID;
    private String recipient;
    private String message;
    private int messageCount;

    
    public Message(String recipient, String message, int messageCount) {
        this.messageID = generateMessageID();
        this.recipient = recipient;
        this.message = message;
        this.messageCount = messageCount;
    }

    
    private String generateMessageID() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(rand.nextInt(10));}
        return sb.toString();
    }
    
    public String getMessageID()
    { return messageID; }
    public void setMessageID(String id)
    { this.messageID = id; }
    public String getRecipient()
    { return recipient;}
    public String getMessage() { return message;}
    
    public boolean checkMessageID() {
        return messageID != null && messageID.length() == 10;
    }
    
    public String createMessageHash() {
        String[] words = message.trim().split("\\s+");
        String first = words[0].toUpperCase();
        String last = words[words.length - 1].toUpperCase();
        
        first = first.replaceAll("[^A-Z]", "");
        last = last.replaceAll("[^A-Z]", "");
        
        return messageID.substring(0,2) + ":" + messageCount + ":" + first + last;}
    
    // Strict regex - +27 + 9 digits only, no letters
    public String checkRecipientCell(){
        if (recipient != null && recipient.matches("\\+27\\d{9}")) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number.";
            
        }
        
    }
    
    public String 
            checkRecipientCellPhoneNumber(){
                return checkRecipientCell();
            }
    public String checkMessageLength() {
        if (message.length()<= 250) {
            return "Message ready to send.";
        } else{
            int over = message.length() - 250;
            
            return "Message exceeds 250 characters by " + over + ", please reduce size.";
        }
    }
    
    // Console only, no JOptionPane
    public String sentMessage(int option) {
        if (option == 1) {
            return "Message successfully sent.";}
        else if (option == 2 ){
            return "Press 0 to delete message."; 
        }else {
            return "Message successfully stored.";
        }
    }
    
   // Correct order - ID, Hash, Recipient, Message
    public static void printMessages(ArrayList<Message> list)
    {
        for (Message m : list) {
            System.out.println("Message ID: "+ m.getMessageID());
            System.out.println("Message Hash: " + m.createMessageHash());
            
            System.out.println("Recipient: " + m.getRecipient());
            
            System.out.println("Messsage: " + m.getMessage());
            
            System.out.println("--------------------");
        } 
    }
    
    // Valid JSON array, not comma-separated text
    public void storeMessage() {
        try {
            File file = new  File("storedMessages.json");
            String existing = "";
            if(file.exists()) {
                existing = Files.readString(file.toPath()).trim();
            }
            
            String escapeMsg = message.replace("\\", "\\\\").replace("\"", "\\\"");
            String newObj = "{\"id\":\"" + messageID + "\", \"hash\":\"" + createMessageHash() + "\", \"recipient\":\"" + recipient + "\", \"message\":\"" + escapeMsg + "\"}";
            
            String newContent;
            if (existing.isEmpty()|| existing.equals("[]")) {
                newContent = "[\n" + newObj + "\n]";
            } else {
                
                newContent = existing.substring(0, existing.lastIndexOf("]")) + ",\n" + newObj + "\n]";
            }
            
            FileWriter writer = new FileWriter(file);
            writer.write(newContent);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error storing message: " + e.getMessage());
        }
    }
}