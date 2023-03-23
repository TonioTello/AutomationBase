Feature: Login

  This feature deals with the login funcionality of the application

  Scenario: Login with the correctly username and password

    Given I navigate to the login page
    When I enter the credentials correctly
    And I enter the credentials "tomsmith" and "SuperSecretPassword!" correctly
    Then I can access to the home page

#    Examples:
#         When I enter the credentials <username> and <password> correctly
#    |username|password|
#    |tomsmith|SuperSecretPassword!|
