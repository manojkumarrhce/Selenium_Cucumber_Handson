Feature: Mercury Tours

Scenario: Verify login Test

Given Mercury registration page is launched
When Username and Password are entered
Then Find A Flight page is displayed 

#Scenario: Verify functionality of Flight finder page
#
#Given Flight finder page is displayed
#When All flight details are entered
#And All preferences are entered and click on continue
#Then select flight page should be displayed
#
#Scenario: Select depart and return flight
#
#Given SelectFlight page is displayed
#When Depart flight is selected
#And Return flight is selected 
#Then click on continue and Book A Flight page should be displayed
#
#Scenario: Check Summary and enter passenger and billing address
#
#Given Book a Flight page is displayed
#When Summary section is verified
#And Enter the passenger details
#And Enter the billing address 
#Then click on secure purchase button and verify Flight confirmation page should be displayed
#
#Scenario: Check flight confirmation page details
#
#Given Flight confirmation page is displayed
#When Booking confirmation text is verified


#Scenario Outline:: Register the user information
#
#Given Mercury registeration page is launched
#When <Username> and <Password> and <ConfirmPassword> is entered
#And Submit button is clicked
#Then User should be registered


#Examples:
#|Username|Password|ConfirmPassword|
#|Manoj123|Manoj123|Manoj1234|
#|Test123|Rapid|Rapid|
#
#Scenario: Sign in with user information
#
#Given Mercury registeration page is launched
#When Username and Password is entered
#|Manoj123|Manoj123|
#And SignIn button is clicked
#Then User should be able to sign in
