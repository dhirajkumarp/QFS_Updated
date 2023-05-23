package starter.stepdefinitions;

import Pages.QFS;
import Pages.Verify_qa_dashboard;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import utility.Constants;

public class Verify_qa_dashbaordStepDefinition {
@Steps
QFS qfs;
Verify_qa_dashboard qa_dashboard;

@Given("login to application with admin")
public void login_to_application_with_qa_role() throws Exception {
	
	qfs.OpenApplications();
	qfs.enterUserName(Constants.adminUserName);
	qfs.enterPWD(Constants.adminPwd);
	qfs.clickLogin();
	qfs.verifyLogin();
	
   }

@When("I click on QA Dashboard tab")
public void I_click_on_QA_Dashboard_tab()
{
    qa_dashboard.verifyQADashboardTitle();

}
@And("I verify the page title")
public void i_verify_the_page_title() {
	qa_dashboard.click_on_QA_Dashboard_tab();
	}
@And("I verify the content present on page")
public void i_verify_the_content_present_on_page() {
	
	qa_dashboard.VerifyQADashboardContent();

    
}
@And( "I click on the My Productivity button")
public void I_click_on_the_My_Productivity_button()
{
	qa_dashboard.click_on_MyProductivity();
	}
@And( "I click on the Cancel button")
public void My_Productivity_Cancel_button()
{
	qa_dashboard.click_on_Cancel_MyProductivity();
	}
@And( "click on Go button")
public void My_Productivity_Go_button()
{
	qa_dashboard.click_on_Cancel_MyProductivity();
	}

@Then( "I validate the My Productivity Popup window content")
public void i_verify_the_My_Productivity_popup_content_present_on_page()

{
	qa_dashboard.verify_the_My_Productivity_popup_content();
	}
@Then("I validate the content present on page")
public void i_validate_the_content_present_on_page() {
	//qa_dashboard.validate_QA_Statistics();
	qa_dashboard.validate_QA_Dashboard_Section();
	qa_dashboard.validate_Fetch_manuscript();
	qa_dashboard.validate_OnHold_manuscript_section();
    
}


}
