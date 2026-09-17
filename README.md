#PROG5121 Part 1 - ChatApp
**Student:** Afezwa Faith Mantla - ST19492608
**Module:** PROG5121 Programming 1A
**GitHub:** https://github.com/Afezwa/Prog5121Part1

## Project Description
Java console app for Chat Application registration and login. Validates username, password and SA cell phone number.

## Project Structure
CHATAPPPART1 
pom.xml
README.md
src/main/java/za/ac/iie/chatapppart1/
LoginTest.Java
MainApp.java
src/test/java/za/ac/iie/chatapppart1
LoginTest.java

## Features
- Username: contains '_' and max 5 chars - e.g. kyl_1
- Password: 8+ chars, capital letter, number, special char - e.g. Ch&sec@ke99!
- Cell: SA format '+27' + 9 digits using regex '^\+27\d{9}$' - e.g. +27838699867
- Login: returns welcome message or failure message

## How To Run
1. Clean and build project
2.Run MainApp.java
3.Right-click project -> Test to run JUnit tests

## Unit Tests 
1o tests in LoginTest.java:
- checkUserName valid and invalid
- checkPasswordComplexity valid and invalid
- checkCellPhoneNumber valid and invalid 
- registerUser, loginUser, returnLoginStatus

## References
- W3Schools Java Regex: https://www.w3schools.com/java/java_regex.asp
- StackOverflow SA Number Regex: https://stackoverflow.com/questions/15739050/south-africa-mobile-number-regex
