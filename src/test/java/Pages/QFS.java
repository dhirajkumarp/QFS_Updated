package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

import static io.restassured.RestAssured.given;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Managed;
import utility.Constants;

public class QFS extends PageObject{

	@Managed()
	WebDriver driver;

	public final By username = By.id("username");
	public final By password = By.id("password");
	public final By loginClick = By.xpath("//button[text()='Login']");
	public final By Welcome = By.xpath("//span[contains(text(),'Welcome')]");
	public final By ProfileIcon= By.xpath("//img[@class='img-avatar']");
	public final By logoutClick= By.xpath("//text()[contains(.,'Logout')]/ancestor::a[1]");
	public final By loginFailedMessage=By.xpath("//div[contains(text(),\"Username\") or contains(text(),\"Password\") ]");

//	
//	public static ObjectMapper objectMapper = new ObjectMapper();
	SoftAssert sa = new SoftAssert();
public void OpenApplications() throws JsonMappingException, JsonProcessingException {
//		RestAssured.baseURI = "https://qfs-api-test.springernature.app/api/QcTaskList/GetJournalGroupData/sgt5442";
//		String response = given().header("content-type","application/json").body("").when().get().then().assertThat().log().all().statusCode(200).extract().response().asString();
//		List<Object> map = objectMapper.readValue(response,new TypeReference<List<Object>>() {});
//		Map<String,Object> hm = (Map<String, Object>) map.get(0);
//		
//		int a = Integer.parseInt(hm.get("initialQC").toString());
//		//Data creation
//		// call API
//		// strore value in b
//		if(a<b) {
//			
//		}
//		System.out.println(hm.get("revisionQC").toString());
//		System.out.println(hm.get("embFinding").toString());
		open();
	}
	public void login()
	{
		$(username).waitUntilVisible().waitUntilPresent().waitUntilEnabled().sendKeys("admin");
		$(username).waitUntilVisible().waitUntilPresent().waitUntilEnabled().waitUntilClickable().click();
	}

	public void enterUserName(String userName)
	{
		$(username).waitUntilVisible().waitUntilPresent().waitUntilEnabled().sendKeys(userName);
		String usernames= $(username).getText();
				
//		JavascriptExecutor js= (JavascriptExecutor) driver;  
//		String usernames=js.executeScript("return $(username).value").toString();
//		System.out.println("Username is : "+usernames);

	}

	public void enterPWD(String pwd) 
	{
		$(password).waitUntilVisible().waitUntilPresent().waitUntilEnabled().sendKeys(pwd);
	}
	public void clickLogin() throws Exception
	{
		$(loginClick).waitUntilVisible().waitUntilPresent().waitUntilEnabled().waitUntilClickable().click();
		Thread.sleep(2000);
	}
	public void verifyLogin()
	{

		Assert.assertTrue($(Welcome).isDisplayed());
		System.out.print("Login successfully..!!");

	}
	public void logoutApplication() {
		// TODO Auto-generated method stub
		$(ProfileIcon).waitUntilVisible().waitUntilPresent().waitUntilEnabled().waitUntilClickable().click();
		$(logoutClick).waitUntilVisible().waitUntilPresent().waitUntilEnabled().waitUntilClickable().click();		
	}
	public void login_Unsuccessfully()
	{
		Assert.assertTrue($(loginFailedMessage).isVisible());
		System.out.print("Login unsuccessful..!!");

	}

	public void verifyAdminDashboardDisplayed(String role,String value) {
		try {
			$(loginClick).waitUntilVisible().waitUntilEnabled().waitUntilPresent().waitUntilClickable();
			if(value.equals("yes")) {
				sa.assertTrue($(loginClick).isDisplayed()," admin dashboard for role " + role +" is displayed");
			}else {
				sa.assertFalse($(loginClick).isDisplayed()," admin dashboard for role " + role +" is displayed");
			}
		}catch(Exception e) {

		}finally {
			sa.assertAll();
		}
	}
	
	public void m1()
	{
		try
		{OpenApplications();
		enterUserName(Constants.adminUserName);
		enterPWD(Constants.adminPwd);
		clickLogin();
		verifyLogin();
		}
		catch(Exception e){
			
		}
	}
	
	public void verifyHistorTabDisplayed(String role,String value) {
		try {
			$(loginClick).waitUntilVisible().waitUntilEnabled().waitUntilPresent().waitUntilClickable();
			if(value.equals("yes")) {
				sa.assertTrue($(loginClick).isDisplayed()," admin dashboard for role " + role +" is displayed");
			}else {
				sa.assertFalse($(loginClick).isDisplayed()," admin dashboard for role " + role +" is displayed");
			}
		}catch(Exception e) {

		}finally {
			sa.assertAll();
		}
	}

}
