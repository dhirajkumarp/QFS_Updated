
@temp
Feature: Verify left Menu pane present for QA role
      
  Scenario Outline: TC to Verify left menu pane access for QA role
   Given login to application with QA role "<Role>"
    When I verify admin dashboard for role "<Role>" displayed "<adminDashboard>"
    When I verify history tab for role "<Role>" displayed "<History>"
    When I verify accuracy tab for role "<Role>" displayed "<Accuracy>"
    When I verify quality trending for role "<Role>" displayed "<qualityTrending>"
    Then I validate the menu

    Examples: 
      | Role  | adminDashboard | History | Accuracy | qualityTrending |
      | admin | yes            | yes     | yes      | yes             |
      | qa    | no             | no      | yes      | yes             |
