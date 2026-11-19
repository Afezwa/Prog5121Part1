/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import za.ac.iie.chatapppart1.Message;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class MessagePart3Test {
    Message m1 = new Message("+27834557896", "Did you get the cake?", 0);
    Message m2 = new Message("+27838884567", "Where are you? You are late! I have asked you to be on time.", 1);
    Message m3 = new Message("+27834484567", "Yohoooo, I am at your gate.", 2);
    Message m4 = new Message("0838884567", "It is dinner time!", 3);
    Message m5 = new Message("+27838884567", "Ok, I am leaving without you.", 4);
    
    @Test 
    public void testSentMessagesArrayCorrectlyPopulated() {
        ArrayList<String> sent = new ArrayList<>();
        sent.add(m1.getMessage());
        sent.add(m4.getMessage());
        assertEquals("Did you get the cake?", sent.get(0));
        assertEquals("It is dinner time!", sent.get(1));
    }
    
    @Test
    public void testDisplayLongestMessage() {
        ArrayList<Message> all = new ArrayList<>();
        all.add(m1); 
        all.add(m2);
        all.add(m3);
        all.add(m4);
        all.add(m5);
        
        Message longest = all.get(0);
        for (Message m : all) {
            if (m.getMessage().length()> longest.getMessage().length()) longest = m;
        }
        assertEquals("Where are you? You are late! I have asked you to be on time.", longest.getMessage());
    }
        @Test
        public void testSearchForMessageID() {
            assertEquals("0838884567", m4.getRecipient());
            assertEquals("It is dinner time!", m4.getMessage());
        }
        
        @Test
        public void testSearchByRecipient() {
            ArrayList<String> found = new ArrayList<>();
            Message[] all = {m1, m2, m3, m4, m5};
            for(Message m : all ) {
                if (m.getRecipient().equals("+27838884567")) found.add(m.getMessage());
            }
            assertEquals(2, found.size());
            assertEquals("Where are you? You are late! I have asked you to be on time.", found.get(0));
            assertEquals("Ok, I am leaving without you.", found.get(1));
        }
        
        @Test
        public void testDeleteByHash() {
            ArrayList<Message> stored = new ArrayList<>();
            stored.add(m2); 
            stored.add(m5);
            String hashToDelete = m2.createMessageHash();
            stored.removeIf(m -> m.createMessageHash().equals(hashToDelete));
            
            assertEquals(1, stored.size());
            assertEquals("Ok, I am leaving without you.", stored.get(0).getMessage());
            
        }
        
        @Test
        public void testDisplayReport() {
            String report = "Hash: " + m1.createMessageHash() + " Recipient: " + m1.getRecipient() + " Message: " + m1.getMessage();
            
            assertTrue(report.contains(m1.getRecipient()));
            
            assertTrue(report.contains(m1.getMessage()));
            
            assertTrue(report.contains(m1.createMessageHash()));
        }
    }
    
