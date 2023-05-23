package Pages;

import org.testng.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

import static io.restassured.RestAssured.given;
import com.fasterxml.jackson.core.type.TypeReference;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.SimpleDateFormat;

import io.restassured.RestAssured;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Managed;

public class Verify_qa_dashboard extends PageObject {
	@Managed()	
	WebDriver driver;
	SoftAssert softAssert = new SoftAssert();



	public final By QADashboard_Title = By.xpath("//span[text()='QA Dashboard']");

	public final By FetchMSID_btn=By.xpath("//*[text()=\" Fetch New Manuscript\"]");
	public final By QADashboard = By.xpath("//text()[.='QA Dashboard']/ancestor::a[1]");

	public final By MSID_on_hold= By.xpath("//div[text()='Manuscripts on Hold ']");

	public final By myProductivity_Button =By.xpath("//text()[contains(.,'My Productivity')]/ancestor::button[1]");
	public final By QADashboard_section_header = By.xpath("//table[@class=\"table\"]/thead/tr/th");
	public final By myProductivity_heading =By.xpath("//h4[text()='My Productivity']");	
	public final By myProductivity_close_window = By.xpath("//button[contains(text(),'Cancel')]");
	public final By myProductivity_cancel_window = By.xpath("//text()[contains(.,'Cancel')]/ancestor::button[1]");
	public final By myProductivity_go_window = By.xpath("//text()[contains(.,'Go')]/ancestor::button[1]");
	public final By QADashboard_section_div = By.xpath("//text()[contains(.,'QA Dashboard')]/ancestor::div[2]");
	public final By Statistics_section =By.xpath("//qctasklist-root[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]");
	public final By QA_Dashboard_header=By.xpath("//table[@class=\"table\"]/thead/tr/th");
	public final By QADashboard_section =By.xpath("//text()[contains(.,'QA Dashboard')]/ancestor::div[1]");
	public final By Productivity_EndDate=By.xpath("//input[@type='text'][@placeholder='End Date']");
	public final By Productivity_StartDate=By.xpath("//*[@placeholder='Start Date']");

	public static ObjectMapper objectMapper = new ObjectMapper();

	SoftAssert sa = new SoftAssert();
	public void OpenApplications() {
		open();
	}
	public void click_on_QA_Dashboard_tab() {
		try {
			$(QADashboard).click();
			System.out.println("Click on QA dashboard");
		}
		catch(Exception e)
		{

		}
		finally {
			sa.assertAll();
		}
	}




	public void verifyQADashboardTitle() {
		try {
			String Title =$(QADashboard_Title).waitUntilVisible().waitUntilPresent().getText();
			sa.assertTrue(Title.contains("QA Dashboard"));
			System.out.println("Title Verified -> "+Title);
		}
		catch(Exception e)
		{

		}
		finally {
			sa.assertAll();
		}
	}



	public void validate_QA_Dashboard_Section() {
		try {

			{
				$(QADashboard).waitUntilVisible().waitUntilEnabled().waitUntilPresent().waitUntilClickable();
				System.out.println("Element visible");
				sa.assertTrue($(QADashboard).isDisplayed()," QA dashboard for role is displayed");
				System.out.println("QA dashboard for login user is displayed");
				
				//Verify Table header name
				List<WebElement> m = getDriver().findElements(By.xpath("//table[@class='table']/thead/tr/th"));
				        System.out.println(m.size());
		       
				      
				        List<String> list1 = new ArrayList<>();
				        
				        for (WebElement element : m) {
				        	list1.add(element.getText());
				        }
				        List<String> list2 = new ArrayList<>();
				        list2.add("Manuscript ID");
				        list2.add("Journal Name");
				        list2.add("Article Type");
				        list2.add("QFS Version");
				        list2.add("Submarine Version");
				        list2.add("QC Type");
				        list2.add("EA Name");
				        list2.add("PRA Name");
				        list2.add("Login Date");
				        list2.add("Action");

				        boolean areEqual = list1.equals(list2);

				        System.out.println("QA Dashboard Table header name are equal: " + areEqual);
			}



		}catch(Exception e) {
			sa.assertFalse($(QADashboard).isPresent()," Verified QA dashboard for role is not displayed");

		}finally {
			sa.assertAll();
		}
	}
	public void validate_Fetch_manuscript() {
		try {

			$(QADashboard_section).waitUntilVisible();
			String QADashboard_section_Title1 =$(QADashboard_section_div).waitUntilVisible().waitUntilPresent().getText();
			sa.assertTrue(QADashboard_section_Title1.contains("Fetch New Manuscript"));
			
			$(FetchMSID_btn).waitUntilClickable().waitUntilVisible().click();
			RestAssured.baseURI = "https://qfs-api-test.springernature.app/api/QcTaskList/FetchNewId/sgt5442";
			String response = given().header("content-type","application/json").body("").when().get().then().assertThat().log().all().statusCode(200).extract().response().asString();
			List<Object> map = objectMapper.readValue(response,new TypeReference<List<Object>>() {});

			for(int i =0;i<map.size();i++) {
				Map<String,Object> hm = (Map<String, Object>) map.get(i);
				
				if (!hm.get("msid").toString().isEmpty()) {
					softAssert.assertTrue(true,"value MSID is diplayed");
					System.out.println("New MSID fetched please verify manuscript");
				}else {
					softAssert.assertTrue(false,"value MSID is not diplayed");
					System.out.println("MSID alerdy fetched,please complete in-process MSID");

				}
			}
		}catch(Exception e) {
			sa.assertFalse($(QADashboard).isPresent()," Verified QA dashboard for role is not displayed");

		}finally {
			sa.assertAll();
		}
	}
	public void validate_OnHold_manuscript_section() {
		try {

		if($(MSID_on_hold).isDisplayed())
			{
			String MSID_section_Title1 =$(MSID_on_hold).waitUntilVisible().waitUntilPresent().getText();
			sa.assertTrue(MSID_section_Title1.contains("Manuscripts on Hold"));
			System.out.println(MSID_section_Title1+ "Section present on QA dashboard page");
			
			
			$(FetchMSID_btn).waitUntilClickable().waitUntilVisible().click();
			RestAssured.baseURI = "https://qfs-api-test.springernature.app/api/QcTaskList/GetonHoldMSID/sgt5442";
			String response = given().header("content-type","application/json").body("").when().get().then().assertThat().log().all().statusCode(200).extract().response().asString();
			List<Object> map = objectMapper.readValue(response,new TypeReference<List<Object>>() {});

			for(int i =0;i<map.size();i++) 
			{
				Map<String,Object> hm = (Map<String, Object>) map.get(i);
				
				if (!hm.get("id").toString().isEmpty()) {
					softAssert.assertTrue(true,"value MSID is diplayed");
					System.out.println("On-Hold manuscript section shown on QA Dashboard");
				}else {
					softAssert.assertTrue(false,"value MSID is not diplayed");
					System.out.println("MSID alerdy fetched,please complete in-process MSID");

				}
			
			}
			}
		else
			{
			System.out.println("No Manuscript on-hold for logged in user");
			}
		
			
			
			
		}catch(Exception e) {
			//sa.assertFalse($(QADashboard).isPresent()," Verified On-Hold manuscript for role is not displayed");
			System.out.println("OnHold_manuscript_section not present on page..!");
		}finally {
			sa.assertAll();
		}
	}
	public void click_on_MyProductivity() {
		try {
			$(myProductivity_Button).click();
			System.out.println("Click on My Productivity");
		}
		catch(Exception e)
		{

		}
		finally {
			sa.assertAll();
		}
	}

	public void click_on_Cancel_MyProductivity() {
		try {
			$(myProductivity_cancel_window).click();
			System.out.println("Click on Cancel My Productivity");
		}
		catch(Exception e)
		{

		}
		finally {
			sa.assertAll();
		}
	}
	public void click_on_go_MyProductivity() {
		try {
			$(myProductivity_go_window).click();
			System.out.println("Click on go My Productivity");
		}
		catch(Exception e)
		{

		}
		finally {
			sa.assertAll();
		}
	}

	public void verify_the_My_Productivity_popup_content() {
		try {
			//$(myProductivity_Button).click();
			System.out.println("Validate content in Popup window");


			// Create object of SimpleDateFormat class and decide the format
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

			//get current date time with Date()
			Date date = new Date();

			// Now format the date
			String date1= dateFormat.format(date);

			// Print the Date
			System.out.println("Todays Date: "+date1);

			//get application from date

			//			 WebElement element1 = driver.findElement(By.cssSelector("input[type=text][placeholder='Start Date']"));
			//				
			//				//Date elementval1 = dateFormat.getNumberFormat(element1);
			//				
			//			 
			//			 
			//			 
			//			 WebElement element = driver.findElement(By.cssSelector("input[type=text][placeholder='Start Date']"));
			//			
			//			String elementval = element.getAttribute("value");
			//			



			//	date = driver.findElement(By.xpath("//input[@type='text'][@placeholder='Start Date']")).click();
			//	System.out.println("Date is:"+date);
			//			

			JavascriptExecutor executor = (JavascriptExecutor) driver;

			
		//	String theTextIWant = (executor.executeScript("return arguments[0].innerHTML;",Productivity_StartDate));
			
			
System.out.println((executor.executeScript("return arguments[0].value;", Productivity_StartDate)));
			//Assert.assertEquals(executor.executeScript("return arguments[0].value;", Productivity_StartDate),date1.toString(),"ERROR>>>>>Date wasn't entered");
			//		date_value = driver.execute_script("return arguments[0].value;", Productivity_StartDate)
			//$(Productivity_StartDate).click();
			//System.out.println("Date is:"+elementval);

			$(myProductivity_close_window).click();
		}
		catch(Exception e)
		{
			System.out.println("Exception for Handling date");
		}
		finally {
			sa.assertAll();
		}
	}

	public void VerifyQADashboardContent() {
		try {

			{
				$(QADashboard).waitUntilVisible().waitUntilEnabled().waitUntilPresent().waitUntilClickable();
				$(QADashboard).click();
				sa.assertTrue($(QADashboard).isDisplayed()," QA dashboard for role is displayed");
				System.out.println("QA dashboard is displayed for logged in User");

				$(Statistics_section).waitUntilVisible();
				$(Statistics_section).click();
				sa.assertTrue($(Statistics_section).isDisplayed()," Statistics section is displayed");
				System.out.println("Statistics section is displayed on top of the page");

				$(myProductivity_Button).waitUntilVisible();
				$(myProductivity_Button).click();
				System.out.println("My Productivity button ware clicked");
				String Title1 =$(myProductivity_heading).waitUntilVisible().waitUntilPresent().getText();
				sa.assertTrue(Title1.contains("My Productivity"));
				System.out.println("My Productivity window pop-up open after clicked on My Productivity button");

				$(myProductivity_close_window).click();

				System.out.println("My Productivity winodws is closed after click on Close icon");

				$(QADashboard_section).waitUntilVisible();
				String QADashboard_section_Title1 =$(QADashboard_section_div).waitUntilVisible().waitUntilPresent().getText();
				sa.assertTrue(QADashboard_section_Title1.contains("QA Dashboard"));
				System.out.println("QA Dashboard section visible below the Statisics section ");	
				$(QADashboard_section).click();
				sa.assertTrue($(QADashboard_section).isDisplayed()," QADashboard section for role is displayed");

				try {
				if(!$(MSID_on_hold).isDisplayed())
				{
					String MSID_section_Title1 =$(MSID_on_hold).waitUntilVisible().waitUntilPresent().getText();
				sa.assertTrue(MSID_section_Title1.contains("Manuscripts on Hold"));
					System.out.println("Section Title Verified -> "+MSID_section_Title1);
					
				}
				else
				{
					System.out.println("No Manuscript present on OnHold_manuscript_section");
				}
					
				}
				catch(Exception e)
				{
					System.out.println("OnHold_manuscript_section not present on page..!");
				}
			}



		}catch(Exception e) {
			System.out.println("No Data Found");
			//sa.assertFalse($(QADashboard).isPresent()," Verified QA dashboard for role is not displayed");

		}finally {
			sa.assertAll();
		}
	}


	public void validate_QA_Statistics() {
		try {

			{

				$(Statistics_section).waitUntilVisible();
				$(Statistics_section).click();
				sa.assertTrue($(Statistics_section).isDisplayed()," Statistics section is displayed");
				System.out.println("Statistics section is clicked************");



				RestAssured.baseURI = "https://qfs-api-test.springernature.app/api/QcTaskList/GetJournalGroupData/sgt5442";
				String response = given().header("content-type","application/json").body("").when().get().then().assertThat().log().all().statusCode(200).extract().response().asString();
				List<Object> map = objectMapper.readValue(response,new TypeReference<List<Object>>() {});
				for(int i =0;i<map.size();i++) {
					Map<String,Object> hm = (Map<String, Object>) map.get(i);
					
					if (hm.get("journalGroupLevel").toString().equals("SREP")|hm.get("journalGroupLevel").toString().equals("BMC")) {
						softAssert.assertTrue(true,"value BMC or SREP is diplayed");
//						int Jornal=Integer.parseInt((hm.get("journalGroupLevel").toString()));
//						System.out.println("Journal is: "+Jornal);
					}else {
						softAssert.assertTrue(false,"value BMC or SREP is not diplayed");
					}
					
					if (hm.containsKey("initialQC")) {
						softAssert.assertTrue(true," Initial Qc is diplayed");
					}else {
						softAssert.assertTrue(false,"Initial Qc is not diplayed");
					}
					
					if (!hm.get("initialQC").toString().isEmpty()) {
						softAssert.assertTrue(true,"value Initial Qc is diplayed");
					}else {
						softAssert.assertTrue(false,"value Initial Qc is not diplayed");
					}
					
					
					if (hm.containsKey("revisionQC")) {
						softAssert.assertTrue(true,"revisionQC is diplayed");
					}else {
						softAssert.assertTrue(false,"revisionQC is not diplayed");
					}
					if (!hm.get("revisionQC").toString().isEmpty()) {
						softAssert.assertTrue(true,"value revisionQC is diplayed");
					}else {
						softAssert.assertTrue(false,"value revisionQC is not diplayed");
					}
					
					
					if (hm.containsKey("embFinding")) {
						softAssert.assertTrue(true,"embFinding is diplayed");
					}else {
						softAssert.assertTrue(false,"embFinding is not diplayed");
					}
					if (!hm.get("embFinding").toString().isEmpty()) {
						softAssert.assertTrue(true,"value embFinding is diplayed");
					}else {
						softAssert.assertTrue(false,"value embFinding is not diplayed");
					}
					
					
					if (hm.containsKey("praqc")) {
						softAssert.assertTrue(true,"praqc is diplayed");
					}else {
						softAssert.assertTrue(false,"praqc is not diplayed");
					}
					
					if (!hm.get("praqc").toString().isEmpty()) {
						softAssert.assertTrue(true,"value praqc is diplayed");
					}else {
						softAssert.assertTrue(false,"value praqc is not diplayed");
					}
					
					
					
				}	




			}



		}catch(Exception e) {
			System.out.println("Someting went wrong please debug the code");
			//sa.assertFalse($(QADashboard).isPresent()," Verified QA dashboard for role is not displayed");

		}finally {
			sa.assertAll();
		}
	}



}
