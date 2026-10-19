/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.iie.chatapppart1;
import java.util.Random;
import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Student
 */
public class Message {
    private String messageID;
    private String recipient;
    private String message;
    private String messageHash;
    private int messageNum;
    private static int totalMessages = 
            0;
    
    private static List<Message>
            sentMessages = new ArrayList<>();
    private static List<Message>
            storedMessages = new ArrayList<>();
    
    public Message(String recipient, String message, int messageNum) {
        this.messageID =
                generateMessageID();
        this.recipient = recipient;
        this.message = message;
        this.messageNum = messageNum;
        this.messageHash = createMessageHash();
    }
    
    // For testing and allowing setting ID to test hash
    public void setMessageID(String id)
    { this.messageID = id; this.messageHash = createMessageHash();}
    public String getMessageID()
    { return messageID; }
    public String getRecipient()
    { return recipient; }
    public String getMessage() { return message; }
    public String getmessageHash()
    { return messageHash; }
    
    private String generateMessageID() {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++)
            sb.append(r.nextInt(10));
        return sb.toString();
    }
    
    public boolean checkMessageID() {
        return messageID != null && messageID.length() <= 10;
    }
    
    public String checkRecipientCell() {
        if (recipient != null && recipient.length() <= 13 && recipient.startsWith("+")) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
       }
     public String checkMessageLength() {
         if (message.length() <= 250) {
             return "Message ready to send.";
         } else {
             int excess = message.length() - 250;
             return "Message exceeds 250 characters by " + excess + "; please reduce the size.";
         }
         }
     
     public String createMessageHash() {
         if (message == null || messageID == null) return "";
         String[] words =message.trim().split("\\s+");
         String first = words[0].toUpperCase().replace("?", "").replace(".", "").replace(",", "" ).replace("!", "");
         String last = words[words.length - 1].toUpperCase().replace("?", "").replace(".", "").replace(",", "").replace("!", "");
         return messageID.substring(0, 2) + ":" + messageNum + ":" + first + last;
     }
     public String SentMessage() {
         String msg = "What would you like to do?\n1. Send Message\n2. Disregard Message\n3. Store Message to send later";
         String input = JOptionPane.showInputDialog(msg);
         int choice = 0;
         if (input != null) {
             try { choice = Integer.parseInt(input); } catch (Exception e) { choice = 1; }
         }
     
     if (choice == 1) {
         totalMessages++;
         sentMessages.add(this);
         return"Message successfully sent.";
     } else if (choice == 2) {
         return "Press 0 to delete the message.";
     } else {
         storeMessage();
         return "Message successfully stored.";
     }
     }
     
     // For tests, no popup
     public String SentMessageTest(int choice) {
         if (choice == 1) return "Message successfully sent.";
         if (choice == 2) return "Press 0 to delete the message.";
         return "Message successfully stored.";
     }
     
         public void storeMessage() {
             storedMessages.add(this);
             try {
                 FileWriter fw = new FileWriter("storedMessages.json", true);
                 fw.write(messageID + "," + messageHash + "," + recipient + "," + message + "\n");
                 fw.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }
             }
         
     
     public String printMessages() {
         StringBuilder sb = new 
                 StringBuilder();
         for (Message m : sentMessages)
         {
             sb.append("Message ID:").append(m.messageID).append("\n");
             sb.append("Message Hash:").append(m.messageHash).append("\n");
             sb.append("Recipient:").append(m.recipient).append("\n");
             sb.append("Message:").append(m.message).append("\n\n");
         }
       return sb.toString();
     }
     public int returnTotalMessages() {
         return totalMessages;
     
             
         }
     }

