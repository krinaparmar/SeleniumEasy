Feature: Simple form page feature

Scenario Outline: Check single input field feature
Given Single input field page is shown on page
When <usermessage> is passes in text field and click on show button
Then Message should appear in your message area
And Validate both message

Examples:

|usermessage|
|Hello User|


Scenario: Check two input field feature
Given two input field page is shown on page
When Value for 5 field and value for 7 field passed then click on get total
Then Total should appear
And Validate total value




