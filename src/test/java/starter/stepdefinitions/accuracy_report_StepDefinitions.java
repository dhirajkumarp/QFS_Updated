package starter.stepdefinitions;

import org.bouncycastle.asn1.tsp.Accuracy;

import Pages.QFS;
import Pages.Verify_qa_dashboard;
import Pages.accuracy_report;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import utility.Constants;

public class accuracy_report_StepDefinitions {
@Steps
QFS qfs;
accuracy_report accuracy;


@Given("Login to Application with admin")
public void login_to_application_with_valid_user() throws Exception {
	
	qfs.m1();
	
   }

@When ("I click on Accuracy report tab")
public void click_on_accuracy_report_tab()
{
	accuracy.click_on_Accuracy_tab();
	System.out.println("Click on Acccuracy report tab menu");
	}

@And ("I verify the Accuracy report page title")
public void verify_accuracy_report_title()
{
	accuracy.Verify_Accuracy_tital();	
	System.out.println("Verify the Accuracy title");
	}

@And ("I verify the Accuracy content present on page")
public void Verify_accuracy_report_content()
{
	System.out.println("Click on Acccuracy report tab menu");
	}

@Then ("I validate the Accuracy content present on page")
public void validate_accuracy_report_content()
{
	accuracy.validate_search_filter_content();
	System.out.println("Validate Accuracy search filter");
	}



}