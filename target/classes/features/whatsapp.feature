Feature: Whats app launching 

Scenario: Whats app contact creation 

	Given launched the whats app APP 
	When  user accept the alert 
	Then user clicks on agree and continue button 
	Then user select the country from the dropdown 
	Then verify the selected country 
	Then user fill the phone number 
