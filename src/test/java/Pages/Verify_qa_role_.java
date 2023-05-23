package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Managed;

public class Verify_qa_role_ extends PageObject {
	@Managed()	
	WebDriver driver;

	
	public final By username = By.id("username");
	public final By password = By.id("password");
	public final By HistoryTab = By.xpath("//text()[.='History']/ancestor::a[1]");
	public final By AdminDashboard = By.xpath("//text()[.='Admin Dashboard']/ancestor::a[1]");
	public final By QADashboard = By.xpath("//text()[.='QA Dashboard']/ancestor::a[1]");
	public final By AccuracyTab = By.xpath("//text()[.='Accuracy']/ancestor::app-sidebar-nav-link-content[1]");
	public final By UserMaster = By.xpath("//text()[.='User Master']/ancestor::a[1]	");
	public final By QualityTrendingTab = By.xpath("//text()[.='Quality Trending']/ancestor::app-sidebar-nav-link-content[1]");
	
	public final By Welcome = By.xpath("//span[contains(text(),'Welcome')]");
	public final By ProfileIcon= By.xpath("//img[@class='img-avatar']");
	public final By logoutClick= By.xpath("//text()[contains(.,'Logout')]/ancestor::a[1]");
	public final By loginFailedMessage=By.xpath("//div[contains(text(),\"Username\") or contains(text(),\"Password\") ]");
	

	SoftAssert sa = new SoftAssert();
	public void OpenApplications() {
		open();
	}
	public void verifyAdminDashboardDisplayed(String role,String value) {
		try {
			
			if(value.equals("yes")) {
				$(AdminDashboard).waitUntilVisible().waitUntilEnabled().waitUntilPresent().waitUntilClickable();
				System.out.println("Element visible");
				sa.assertTrue($(AdminDashboard).isDisplayed()," admin dashboard for role " + role +" is displayed");
				
			}else {
				System.out.println("Element not visible");
				$(AdminDashboard).waitUntilVisible().waitUntilEnabled().waitUntilPresent().waitUntilClickable();
				sa.assertFalse($(AdminDashboard).isPresent()," Verified admin dashboard for role " + role +" is not displayed");
				
			}
		}catch(Exception e) {

		}finally {
			sa.assertAll();
		}
	}
	public void verifyQADashboardDisplayed(String role,String value) {
		try {
			
			if(value.equals("yes")) {
				$(QADashboard).waitUntilVisible().waitUntilEnabled().waitUntilPresent().waitUntilClickable();
				System.out.println("Element visible");
				sa.assertTrue($(QADashboard).isDisplayed()," QA dashboard for role " + role +" is displayed");
				
			}else {
				System.out.println("Element not visible");

				sa.assertFalse($(QADashboard).isPresent()," Verified QA dashboard for role " + role +" is not displayed");
				
			}
		}catch(Exception e) {

		}finally {
			sa.assertAll();
		}
	}
	public void verifyAccuracytabDisplayed(String role,String value) {
		try {
			
			if(value.equals("yes")) {
				$(AccuracyTab).waitUntilVisible().waitUntilEnabled().waitUntilPresent().waitUntilClickable();
				System.out.println("Element visible");
				sa.assertTrue($(AccuracyTab).isDisplayed()," Accuracy Tab for role " + role +" is displayed");
				
			}else {
				System.out.println("Element not visible");
				$(AccuracyTab).waitUntilVisible().waitUntilEnabled().waitUntilPresent().waitUntilClickable();
				sa.assertFalse($(AccuracyTab).isPresent()," Verified Accuracy Tab for role " + role +" is not displayed");
				
			}
		}catch(Exception e) {

		}finally {
			sa.assertAll();
		}
	}

	public void verifyHistorTabDisplayed(String role,String value) {
		
		try {
			
			if(value.equals("yes")) {
				$(HistoryTab).waitUntilVisible().waitUntilEnabled().waitUntilPresent().waitUntilClickable();
				System.out.println("Element visible");
				sa.assertTrue($(HistoryTab).isDisplayed()," History Tab for role " + role +" is displayed");
				
				//$(HistoryTab).click();
				
			}else {
				System.out.println("Element not visible");
				$(HistoryTab).waitUntilVisible().waitUntilEnabled().waitUntilPresent().waitUntilClickable();
				sa.assertFalse($(HistoryTab).isDisplayed()," History Tab for role " + role +" is not displayed");
				
			}
		}catch(Exception e) {

		}finally {
			sa.assertAll();
		}
	}
	public void VerifyUserMaster(String role,String value) {
		try {
			
			if(value.equals("yes")) {
				$(UserMaster).waitUntilVisible().waitUntilEnabled().waitUntilPresent().waitUntilClickable();
				sa.assertTrue($(UserMaster).isDisplayed()," User Master Tab for role " + role +" is displayed");
				
			}else {
				System.out.println("Element not visible");				
				$(UserMaster).waitUntilVisible().waitUntilEnabled().waitUntilPresent().waitUntilClickable();
				sa.assertFalse($(UserMaster).isPresent()," Verified User Master Tab for role " + role +" is not displayed");
				
			}
		}catch(Exception e) {

		}finally {
			sa.assertAll();
		}
	}
	public void verifyQualityTrendingDisplayed(String role,String value) {
		try {
			
			if(value.equals("yes")) {
				$(QualityTrendingTab).waitUntilVisible().waitUntilEnabled().waitUntilPresent().waitUntilClickable();
				sa.assertTrue($(QualityTrendingTab).isDisplayed()," Quality Trending Tab for role " + role +" is displayed");
				
			}else {
				System.out.println("Element not visible");				
				$(QualityTrendingTab).waitUntilVisible().waitUntilEnabled().waitUntilPresent().waitUntilClickable();
				sa.assertFalse($(QualityTrendingTab).isPresent()," Verified Quality Trending Tab for role " + role +" is not displayed");
				
			}
		}catch(Exception e) {

		}finally {
			sa.assertAll();
		}
	}

	public void navigateToMenu(String value) {
		
		try {
		switch(value) {
		case "dashboard":
			break;
		case "qa dashboard":
			break;
		case "report":
			break;
		
		}
		}catch(Exception e) {

		}finally {
			sa.assertAll();
		}
	}

}
