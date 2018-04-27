# itmd515finalproject

# Deborah Barndt & Thomas Boller: Group 4
*ITMD 415/515 Advanced Software Programming
*Dr. Carl R. Carlson & Professor James Papademas
*Final Project: Car Services App
*4-24-18

# Instructions to run HITCH

HITCH is our car services app that allows you to register, login, look at your profile, request a ride, request a delivery, allows drivers to set their location and get customer requests, and an admin to manage the accounts.

# How to run HITCH:
1.	Import the file to Eclipse Oxygen as a project
2.	Run Maven Clean Verify
3.	Create local MySQL Server and get credentials
4.	Go into geekbitjava.test and open the TestJdbc.java file. Enter your credentials on lines 27-29.
5.	Open hibernate.cfg.xml under src/main/resources
6.	Alter lines 11-13 to fit your credentials
7.	Right click on TestJdbc.java and run as java application. Tables should be created and populated 
(tested 6 times, worked 5).
8.	Add the project to Tomcat server
9.	Start the Tomcat server
10.	Open your browser and go to http://localhost:8080/hitchwebapp or http://localhost:8080 
11.	Login to Hitch using the email “xstorm@email.com” and password “lightning” or register for your own account.

# Future Additions to HITCH:
1.	Adding Google API to ride requests and delivery requests
2.	Adding an admin dashboard panel
