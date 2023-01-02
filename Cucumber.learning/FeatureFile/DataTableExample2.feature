Feature: Open the Augio
Scenario: Open the Augio For testing
	Given the user enter the URL "https://test.augio.io/"
	When  the userenter username and enter password
	|Username								 |Password   |
	|bisawa2173@dmtubes.com  |Admin@123  |
	Then user click the login button 
	And verify the page and quit