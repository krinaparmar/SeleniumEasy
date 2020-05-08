Feature: Radio button Demo page feature

Scenario: Navigate to Radio Button Demo page
Given Input forms dropdown is shown on Check Box demo page
When Click on Radio button demo option after expanding Input forms dropdown
Then Radio Button Demo page should load properly


Scenario: Check Radio button Demo feature
Given Radio Button Demo option should shown on page
When Radio option appears then click on "Male" Radio button option
Then Click on Get Checked Value button
And Sucess message for "Male" radio button should show underneath check box

Scenario: Check Group Radio Buttons Demo feature
Given Group Radio Buttons Demo option should shown on page
When Sex and Age group options shows on page
Then Click on "Male" radio button
Then Click on "5 to 15" Age group
Then Click on Get Values options
And Verify Sex "Male" and "5 - 15" values


