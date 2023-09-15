@API @US060
Feature: US060 As a user, I should be able to add user name

  Scenario: User should be able to set new name of user
    When user sends a Post request to set name
    Then user validates response data