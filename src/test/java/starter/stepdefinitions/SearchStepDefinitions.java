package starter.stepdefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import Pages.QFS;
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

public class SearchStepDefinitions {
@Steps
QFS qfs;


   

@Given("Login to Application")
public void login_to_application() throws JsonMappingException, JsonProcessingException {
    // Write code here that turns the phrase above into concrete actions
System.out.println("hi"); 
qfs.OpenApplications();
}

@And("enter user name {string}")
public void enterUserName(String userName) {
	qfs.enterUserName(userName);

}
@And("enter Password {string}")
public void enterpws(String pwd) {
	qfs.enterPWD(pwd);
}
@When("Click on Login")
public void clickLogin() throws Exception
{
	qfs.clickLogin();
	}
@Then("login must be successful")
public void verifyLogin()
{
	qfs.verifyLogin();
	}
@And("login must be unsuccessful")
public void login_UnSucess()
{
	qfs.login_Unsuccessfully();
	
	}
@And("user logout from application")
public void logoutapplication()
{
	qfs.logoutApplication();
}

}
