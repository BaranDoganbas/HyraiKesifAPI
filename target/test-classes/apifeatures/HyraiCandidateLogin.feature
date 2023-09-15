@API @hyrai
Feature: Candidate Login

  Scenario: User must be able to log in as candidate
    When user sends Post request to login as candidate
    Then user validates login response data