Feature: Select Dropdown List page feature

Scenario: Navigate to Select Dropdown List page
Given Input forms dropdown is shown on Select Dropdown List page
When Click on Select Dropdown List option after expanding Input forms dropdown
Then Select Dropdown List page should load properly


Scenario Outline: Check Select List Demo feature
Given Select List Demo option should shown on page
When Select a day dropdown appears then check for <dayvalue> option
Then Select Tuesday option
And Sucess message for Day selected <dayvalue> should shown

Examples:
|dayvalue|
|Tuesday|

Scenario Outline: Check Multi Select List Demo feature
Given Multi Select List Demo option should shown on page
When Multiselect list shown on page
Then Click on <First>,<Second>,<Third>
Then Click on First Selected Button
And Verify First Selected option <First>
Then Click on Get All Selected Buttton 
And Verify Get ALL selected option <First>,<Second>,<Third>

Examples:
|First|Second|Third|
|Florida|New York|Texas|

