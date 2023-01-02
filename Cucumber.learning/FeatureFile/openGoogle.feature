Feature: open google Feature
Scenario: open google website and search
	Given user is enter a link "https://www.google.com/"
	When user is entering search word "Cucumber"
	And enter the search button
	Then user should reach the result page   

