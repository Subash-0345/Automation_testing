Feature: Open the Project
Scenario: open the project For testing
	Given enter the URL "https://test.augio.io/login"
	When  enter username and enter password
	|"bisawa2173@dmtubes.com"|"Admin@123"|
	Then click the login button 
	And Verify the page and quit

