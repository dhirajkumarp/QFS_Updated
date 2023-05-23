@tag
Feature: Verify role wise access of module

  @temp1
  Scenario Outline: TC to Verify left menu pane role wise access modulewise
    Given login to application with role "<Role>"
    When I verify admin dashboard for role "<Role>" displayed "<adminDashboard>"
    When I verify QA dashboard for role "<Role>" displayed "<QADashboard>"
    When I verify history tab for role "<Role>" displayed "<History>"
    When I verify Accuracy tab for role "<Role>" displayed "<Accuracy>"
    When I verify User Master tab for role "<Role>" displayed "<Accuracy>"
    When I verify Quality Trending tab for role "<Role>" displayed "<qualityTrending>"
    Then I validate the menu
    And user logout from application

    Examples: 
      | Role  | adminDashboard | QADashboard | History | Accuracy | Usermaster | qualityTrending |
      | admin | yes            | yes         | yes     | yes      | yes        | yes             |
      | qa    | no             | yes         | no      | no       | no         | no              |

  @temp1
  Scenario Outline: TC to Verify History Tab left menu pane role wise access
    Given login to application with role "<Role>"
    When I verify the left menu pane for role "<Role>" displayed "<History>"
    Then I validate the menu
    And user logout from application

    Examples: 
      | Role  | History | Accuracy | qualityTrending |
      | admin | yes     | yes      | yes             |
      | qa    | no      | no       | yes             |

  @temp1
  Scenario Outline: TC to Verify Accuracy Tab left menu pane role wise access
    Given login to application with role "<Role>"
    When I verify the left menu pane for role "<Role>" displayed "<adminDashboard>"
    Then I validate the menu
    And user logout from application

    Examples: 
      | Role  | adminDashboard | QADashboard | History | Accuracy | qualityTrending |
      | admin | yes            | yes         | yes     | yes      | yes             |
      | qa    | no             | no          | yes     | yes      | no              |
