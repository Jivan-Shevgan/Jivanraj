

	@CreateAccount
	Feature: Enter neccessary detail to create an 5paisa Trading account

	@Paisa
	Scenario Outline:
	Given appPackage And appActivity Land on open a Free Account
	When I enter mobile No and Belongs to 
	Then click on register button 
	
	
	Examples:
	| MobileNo   | 
	| 8855873119 |
	
	
	
	@Zerodha
	Scenario Outline:
		Scenario Outline:
	Given I am Jivan
	When JivanRaj Hello
	Then Bye Bye miss good night 

	#Background:
	#Given i am background
	#When Bye
	#Then Hello
	