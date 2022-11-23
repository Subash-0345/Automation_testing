 Feature: check link is displayed
	Scenario: search links is displayed
  Given user is entering google.co.in
  When  user is typing the search term "python"
  And enter the return key
  Then the user should see the link is displayed. 
  