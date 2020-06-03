Feature: ConfigurationTools

  @smoke
  Scenario Outline: Verify the login functionality with valid inputs
    Given I hit the Urls
    Then I click on the login buttons
    And It will navigate to the another windows
    When I fill the "<User Name>" and "<Password>"
    And I click on the Sign in buttons
    Then I click on the confiTab
    And Click on the ProductTab
    Then I click on the edit button

    Examples:
      | User Name       | Password |
      | FSAdministrator | FSA@2018 |

