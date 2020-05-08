Feature: checkbox page feature

Scenario: Navigate to CheckBox Demo page
Given Input forms dropdown is shown on Simple Form demo page
When Click on Check box Demo option after expanding Input forms dropdown
Then Check box Demo page should load properly


Scenario: Check Single Checkbox Demo feature
Given Single Checkbox Demo option should shown on page
When Check box is shown and click on check box option
Then Check box should shown ticked
And Sucess message should shown underneath check box

Scenario: Check Multiple Checkbox Demo feature
Given Multiple Checkbox Demo option should shown on page
When Check All option shown on page then click on it
Then It should turn to Uncheck All 
Then Check if all button checked
Then Untick two check box options
And Check if button turned to Check All from Uncheck All button


