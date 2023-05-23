@All
Feature: Login to Application

  @temp1
  Scenario Outline: TC_Login_to_the_application_with_valid_credentials
    Given Login to Application
    And enter user name "<userName>"
    And enter Password "<password>"
    When Click on Login
    Then login must be successful
    And user logout from application

    Examples: 
      | userName | password |
      | sgt5442  | sgt5442  |
      | vale01   | vale01   |

	@temp1
  Scenario Outline: TC_Login_to_the_application_with_invalid_credentials
    Given Login to Application
    And enter user name "<userName>"
    And enter Password "<password>"
    When Click on Login
    Then login must be unsuccessful
    

    Examples: 
      | userName | password |
      | sg442    | sg442    |
      | vale1    |          |
      |          |   vale   |
  #@Smoke
  #Scenario Outline: TC_Login_to_the_application_with_invalid_credentials
    #Given Login to Application
    #And enter user name "<userName>"
    #And enter Password "<password>"
#
    #Examples: 
      #| userName | password |
      #| abc      | sdsad    |
      #| sfdsdf   | sdfsfd   |
