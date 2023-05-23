package starter.stepdefinitions;

import org.testng.asserts.SoftAssert;

import Pages.QFS;
import Pages.Verify_qa_role_;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Steps;
import starter.navigation.NavigateTo;
import starter.search.LookForInformation;
import starter.search.WikipediaArticle;
import utility.Constants;

public class qa_view_StepDefinitions {
@Steps
QFS qfs;
Verify_qa_role_ vqr;




@Given("login to application with role {string}")
public void login_to_application_with_qa_role(String role) throws Exception {
	
	qfs.OpenApplications();
	switch(role) {
	case "admin":
		qfs.enterUserName(Constants.adminUserName);
		qfs.enterPWD(Constants.adminPwd);
		break;
	case "qa":
		qfs.enterUserName(Constants.qaUserName);
		qfs.enterPWD(Constants.qaPwd);
		break;
	}
	
	qfs.clickLogin();
	qfs.verifyLogin();
   }


@When("I verify admin dashboard for role {string} displayed {string}")
public void i_verify_admin_dashboard_for_role_displayed(String role, String value) {
	vqr.verifyAdminDashboardDisplayed(role, value);
	}
@When("I verify QA dashboard for role {string} displayed {string}")
public void I_verify_QA_dashboard_for_role_displayed(String role, String value) {
	vqr.verifyQADashboardDisplayed(role, value);
	}

@When("I verify history tab for role {string} displayed {string}")
public void i_verify_history_tab_for_role_displayed(String role, String value) {
	vqr.verifyHistorTabDisplayed(role, value);    
}

@When("I verify Accuracy tab for role {string} displayed {string}")
public void i_verify_accuracy_tab_for_role_displayed(String role, String value) {
     vqr.verifyAccuracytabDisplayed(role,value);
}
@When("I verify User Master tab for role {string} displayed {string}")
public void I_verify_UserMaster_Tab_for_role_Role_displayed(String role, String value) {
     vqr.VerifyUserMaster(role,value);
}

@When("I verify Quality Trending tab for role {string} displayed {string}")
public void i_verify_quality_trending_for_role_displayed(String role, String value) {
     vqr.verifyQualityTrendingDisplayed(role, value);
  }


@When("I verify the left menu pane for role {string} displayed {string}")
public void i_verify_the_left_menu_pane(String role, String value) {
   
	vqr.verifyAdminDashboardDisplayed(role, value);
	vqr.verifyHistorTabDisplayed(role, value);
	//vqr.navigateToMenu(value);
	 
}

@And("I navite to QADashboard page")
public void navigateToDashboard() {
	vqr.navigateToMenu("dashboard");
}

@And("I navite to Report page")
public void navigateTorReport() {
	vqr.navigateToMenu("report");
}
@Then("I validate the menu")
public void i_validate_the_menu() {
	
	
   
    
}


}
