Feature: Login

  Scenario Outline: verify the Login Functionality with valid inputs
    Given I hit the Url
    Then I click on the login button
    And It will navigate to the another window
    When I enter "<User Name>" and "<password>"

    And I click on the Sign in button

    Then Click on the Gateway Tab
    And Click on the Trap Data
    And Verify all the details
    Then Click on the Excel Import Tab

    Examples:
      | User Name       | password |
      | FSAdministrator | FSA@2018 |



