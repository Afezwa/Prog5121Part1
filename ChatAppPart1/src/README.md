#PROG5121 Part 2 - ChatApp
**Student:** Afezwa Faith Mantla - ST10402608
**Module:** PROG5121 Programming 1A
**GitHub:** https://github.com/Afezwa/Prog5121Part1

## Project Description
Java console app for Chat Application registration and login. Validates username, password and SA cell phone number. In part 2, the app adds QuickChat functionality to send, store and display messages.

## Project Structure
CHATAPPPART1 
pom.xml
README.md
messages.json
src/main/java/za/ac/iie/chatapppart1/
Login.java
MainApp.java
Message.java
src/test/java/za/ac/iie/chatapppart1
LoginTest.java
MessageTest.java

## Features

## Part 1 - Registration anf Login
- Username: contains '_' and max 5 chars - e.g. kyl_1
- Password: 8+ chars, capital letter, number, special char - e.g. Ch&sec@ke99!
- Cell: SA format '+27' + 9 digits using regex '^\+27\d{9}$' - e.g. +27838699867
- Login: returns welcome message or failure message

## Part 2 - QuickChat
- Menu: 1 to send messages, 2 to show recently sent messages, 3 to quit
- User chooses how many messages to send
- Each message creates:
- Message ID: 10-digit random number
- Message Hash: First 2 letters of ID: message number : first and last word in CAPS
- Messages stored in JSON file (messages.json)
- Total number of messages sent is tracked and displayed

## How To Run
1. Clean and build project
2.Run MainApp.java
3. Register and Login
4. In QucikChat menu choose:
     - 1 = Send Messages
     - 2 = Show recently sent messages
     - 3 = Quit

## Unit Tests 
1o tests in LoginTest.java:
- checkUserName valid and invalid
- checkPasswordComplexity valid and invalid
- checkCellPhoneNumber valid and invalid 
- registerUser, loginUser, returnLoginStatus

Tests in MessageTest.java:
- chexkMessageLength valid and invalid
- checkMessageID creation
- checkMessageHash creation 
- sendMessage and storeMessage

To run tests: Right-click project -> Test

## References
- W3Schools Java Regex: https://www.w3schools.com/java/java_regex.asp
- StackOverflow SA Number Regex: https://stackoverflow.com/questions/15739050/south-africa-mobile-number-regex

## Technologies Used 
- Java 17
- Maven
- NetBeans
- JUnit 5
- JSON (for storing messages)

## Example Usage
- Username: kyl_1
- Password: Ch&sec8ke99!
- Cell Number: +2783869967
- Expected output: "Username successfully captured / Password succesfully captured / Cell phone number successfully added"
- Login output: "Welcome Afezwa, it is great to see you again"
- Message sent: "Hi Mike, can you join us for dinner tonight"
- Message Hash example: 00:0:HI TONIGHT

## How o Run Tests
Right-click project -> Test 
All 10 tests in LoginTest.java should pass