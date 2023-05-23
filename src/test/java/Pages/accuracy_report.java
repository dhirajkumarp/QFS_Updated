package Pages;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.SimpleDateFormat;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Managed;

public class accuracy_report extends PageObject {
	@Managed()	
	WebDriver driver=this.getDriver();
		
	
	public final By Accuracy_Tab = By.xpath("//text()[.='Accuracy']/ancestor::a[1]");	
	public final By Accuracy_SearchByMonth=By.xpath("//input[@type='radio'][@class='ng-untouched ng-pristine ng-valid']");	
	public final By Accuracy_SearchByDate= By.xpath("//input[@type='radio'][@class='ng-valid ng-touched ng-dirty']");	
	public final By Accuracy_StartDate= By.cssSelector("*[placeholder='Start Date']");
	public final By Accuracy_EndDate= By.cssSelector("*[placeholder='End Date']");	
	public final By Accuracy_Month=By.cssSelector("input[type=text][placeholder='Select Month']");	
	public final By Accuracy_Breadcrumb=By.cssSelector("*[class='breadcrumb']");
	public final By Accuracy_search=By.cssSelector("button[class='btn btn-success']");
	public final By Accuracy_MonthSelect=By.xpath("//*[@class='selected']");
	public final By Accuracy_TeamLeaddrpdown=By.xpath("//text()[.='Select Team Lead']/ancestor::span[1]");
	public final By Accuracy_TeamMemberdrpdown=By.xpath("//text()[.='Select Team Member']/ancestor::span[1]");
	public final By Accuracy_CheckTypedrpdown=By.xpath("//span[text()='Select Check Type']");


	
	

	SoftAssert sa = new SoftAssert();
	public void OpenApplications() {
		open();
	}
	public void click_on_Accuracy_tab() {
		try {
			String Breadcrumb1=$(Accuracy_Breadcrumb).getText();
			System.out.println("Page Path is : "+Breadcrumb1);
			$(Accuracy_Tab).waitUntilEnabled().waitUntilPresent().waitUntilVisible().waitUntilClickable();
			$(Accuracy_Tab).click();
			
			}
		catch(Exception e)
			{
			
			}
								}
	
	public void Verify_Accuracy_tital() {
		try {
			Thread.sleep(5000);
			String Breadcrumb=$(Accuracy_Breadcrumb).getText();
			System.out.println("Page Path is : "+Breadcrumb);
			Assert.assertTrue("Verify Match",Breadcrumb.contains("Accuracy Report"));

			}
		catch(Exception e)
			{
			
			}
								}
	
	public void Verify_Accuracy_Content() {
		try {
			
			String Breadcrumb=$(Accuracy_Breadcrumb).getText();
			Thread.sleep(5000);
			System.out.println("Page Path is : "+Breadcrumb);
			Assert.assertTrue("Verify Match",Breadcrumb.contains("Accuracy Report"));

			}
		catch(Exception e)
			{
			
			}
								}
	public void validate_search_filter_content() {
		try {
			System.out.println("Validate Search FIlter1");
			$(Accuracy_SearchByMonth).waitUntilVisible().waitUntilPresent();
			boolean selectState = $(Accuracy_SearchByMonth).isSelected();
			Assert.assertTrue($(Accuracy_SearchByMonth).isSelected());
			
			// To get system current Month
			YearMonth thisMonth    = YearMonth.now();			
			DateTimeFormatter monthYearFormatter = DateTimeFormatter.ofPattern("MMMM");
			String thismonths=thisMonth.format(monthYearFormatter);
			//System.out.printf("Today: %s\n", thisMonth.format(monthYearFormatter)); 
			$(Accuracy_Month).click();
			
			//Get the selected current month
			String test2 = $(Accuracy_MonthSelect).getText();
			Assert.assertEquals(thismonths,test2);
				
		//	Verify default selection is By Month
				if(selectState == true) {
				if($(Accuracy_Month).isCurrentlyVisible()){
					$(Accuracy_Month).waitUntilEnabled().waitUntilPresent().waitUntilVisible();
					
		//Verify all content should be visible
					
				$(Accuracy_search).waitUntilVisible().waitUntilClickable();	
				System.out.println("Search button visible");
				$(Accuracy_StartDate).waitUntilVisible().waitUntilPresent().isDisabled();
				System.out.println("Start date field present but disabled");

				$(Accuracy_EndDate).waitUntilVisible().waitUntilPresent().isDisabled();
				System.out.println("End date field present but disabled");
				$(Accuracy_SearchByDate).waitUntilVisible().waitUntilPresent().isDisplayed();
				System.out.println("Search by date is displayed");
				$(Accuracy_TeamLeaddrpdown).waitUntilVisible().waitUntilPresent().isDisplayed();
				System.out.println("Team lead dropdown is present");
				$(Accuracy_TeamMemberdrpdown).waitUntilVisible().waitUntilPresent().isDisabled();
				System.out.println("Team Member dropdown is present");

				$(Accuracy_CheckTypedrpdown).waitUntilVisible().waitUntilPresent();
				System.out.println("Team lead dropdown is present");



					//$(Accuracy_MonthSelect).waitUntilEnabled().waitUntilClickable().waitUntilVisible();
					//$(Accuracy_MonthSelect).click();
					//System.out.println("Selected month "+Months1);
					//  js.executeScript("document.getElementsByTagName('input')[1].value='Dec/2022';");
					// js.executeScript("document.getElementsByTagName('input')[1].text()");
					
////					((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", $(Accuracy_Month));
//				String test1=$(Accuracy_Month).getText();
//				System.out.println("Selected value using getText() :"+test1);
//				test1=$(Accuracy_Month).getAttribute("innerText");
//				System.out.println("Selected value using getAttribute() :"+test1);
//				test1=$(Accuracy_Month).getAttribute("textContent");
//				System.out.println("Selected value using getAttribute() :"+test1);
//				test1=$(Accuracy_Month).getAttribute("innerHTML");
//				System.out.println("Selected value using getAttribute() :"+test1);
//				test1 = (String) ((JavascriptExecutor)driver).executeScript("return $(arguments[0]).text();",  $(Accuracy_Month));
//				System.out.println("Selected value using jse text :"+test1);
			//	$(Accuracy_Month).sendKeys("Jan/2023");
				
				
				}
				else {
					System.out.println("Accuracy Month isn't visible");
				}
				}
			
			}
		catch(Exception e)
			{

			
			System.out.println("Exception occured "+e.getMessage());
			}
								}

	
	
}