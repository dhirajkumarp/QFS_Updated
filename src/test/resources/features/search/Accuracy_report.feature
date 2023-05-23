@tag1
Feature: Verify Accuracy report functionality

  Background: Login feature
    Given Login to Application with admin

  @temp
  Scenario: Verify Accuracy tab on left menu pane
    When I click on Accuracy report tab
    And I verify the Accuracy report page title
    Then I validate the Accuracy content present on page
    And user logout from application
