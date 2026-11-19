/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.iie.chatapppart1;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author Student
 */
public class MessageTest {
    
    @Test
    public void testMessageLengthSuccess() {
        Message m = new Message("+27718693002", "Hi Mike, can you join us for dinner tonight?", 0);
        assertEquals("Message ready to send.", m.checkMessageLength());
    }
    
    @Test
    public void testMessageLengthFailure() {
        String longMsg = "x".repeat(300);
        Message m = new 
            Message("_27718693002", longMsg, 0);
        
        assertTrue(m.checkMessageLength().contains("Message exceeds 250 characters by 50"));
    }
    
    @Test
    public void testRecipientSuccess() {
        Message m = new
            Message("+27718693002", "Hi Mike, can you join us for dinner tonight?", 0);
        assertEquals("Cell phone number successfully captured.", 
        m.checkRecipientCell());
    }
        
            @Test
            public void testRecipientFailure()
            {
                Message m = new 
                    Message("08575975889", "Hi Keegan, did you recieve the payment?", 1);
                assertEquals("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number.", 
                m.checkRecipientCell());
            }
            
            @Test
            public void testSentMessage() {
                Message m = new
                    Message("+27718693002", "Hi Mike, can you join us for dinner tonight?", 0);
                assertEquals("Message successfully sent.", m.sentMessage(1));
            }
            
            @Test
            public void testDisregardedMessage() {
                Message m = new 
                    Message("+27718693002", "Hi Mike, can you join us for dinner tonight?", 0);
                assertEquals("Press 0 to delete message.", m.sentMessage(2));
            }
            
            @Test
            public void testStoreMessage() {
                Message m = new
                    Message("+27718693002", "Hi test store", 0);
                
                java.io.File f = new 
                    java.io.File("storedMessages.json");
                if(f.exists()) f.delete();
                m.storeMessage();
                assertTrue(f.exists());
                try {
                    String content = java.nio.file.Files.readString(f.toPath());
                    
                    assertTrue(content.contains("+27718693002"));
                    
                    assertTrue(content.startsWith("["));
                    
                    assertTrue(content.trim().endsWith("]"));
                } catch (Exception e){
                    fail("Could not read JSON file");
                }
            }
            
            @Test
            public void testPrintMessages(){
                Message m = new 
                    Message("+27718693002", "Hi Mike, can you join us for dinner tonight?", 0);
                ArrayList<Message> list = new
                    ArrayList<>();
                list.add(m);
                
                Message.printMessages(list);
                assertEquals(1, list.size());
            }
            
            @Test
            public void testMessageHash() {
            Message m = new
                Message("+27718693002", "Hi Mike, can you join us for dinner tonight?", 0);
            
            m.setMessageID("0012345678"); // starts with 00
            assertEquals("00:0:HITONIGHT", m.createMessageHash());
        }
            
            @Test
            public void testMessageID() {
            Message m = new
                    Message("+277186930022", "Hi", 0);
            assertTrue(m.checkMessageID());
            assertEquals(10, m.getMessageID().length());
        }
    }
    
            
    

