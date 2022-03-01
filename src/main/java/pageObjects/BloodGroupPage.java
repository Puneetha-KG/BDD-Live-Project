package pageObjects;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.CommonFunctions;

public class BloodGroupPage {
	
	public WebDriver driver;
	public String bloodgroup;
	public String selectedStatus;
	CommonFunctions commonFunctions;
	
	//page locators
	public By menuHamburger = By.xpath("//a[@class='sidebar-toggle']");
	public By sidebar = By.xpath("//ul[@class=\"sidebar-menu\"]");
	public By bloodGroupsBtn = By.xpath("//span[contains(text(),'Blood Groups')]");
	public By doctorsBtn = By.xpath("//span[contains(text(),'Doctors')]");
	public By orderManagementBtn = By.xpath("//span[contains(text(),'Order Management')]");
	public By adminBtn= By.xpath("//span[contains(text(),'Admin')]");
	
	//create blood group
	public By newBtn=By.xpath("//span[contains(text(),'New')]");
	public By bloodGroupTxt=By.xpath("//input[@id='blood_group']");
	public By statusDropdown=By.xpath("//select[@class='form-control status select2-hidden-accessible']");
	public By bloodGroupSubmitBtn=By.xpath("//button[contains(text(),'Submit')]");
	public By listBtn=By.linkText("List");
	
	//filter blood group
	public By filterBtn=By.xpath("//span[contains(text(),'Filter')]");
	public By idFilterTxt=By.name("id");
	public By bloodGroupFilterTxt=By.name("blood_group");
	public By bgFilterStatusDropdown=By.xpath("//select[@name=\"status\"]");
	public By bloodGroupSearchBtn=By.xpath("//button[@class=\"btn btn-info submit btn-sm\"]");
	
	//Edit blood Group
	public By verticalDots=By.xpath("(//a[@class='dropdown-toggle'])[2]");
	public By editBtn=By.linkText("Edit");
	
	//Delete blood group
	public By deleteBtn=By.linkText("Delete");
	public By deleteConfirmBtn=By.xpath("//button[@class='swal2-confirm swal2-styled']");
	public By deleteSucessBtn=By.xpath("//button[contains(text(),'OK')]");
	
	//error message
	public By bgDontSubmitBtn=By.xpath("//button[@class='btn btn-primary']");
	public By NoBloodGroupErrMsg=By.xpath("//label[@class='control-label']");
	
	//Reset Blood Group
	public By resetBtn=By.xpath("//button[contains(text(),'Reset')]");
	
	//home breadcrumb
	public By homeBreadcrumb=By.partialLinkText("Home");
	
	//Blood Group list table
	public By bgTable=By.xpath("//table[@class='table table-hover grid-table']");
	
	//constructor
	public BloodGroupPage(WebDriver driver) {
		this.driver = driver;
		commonFunctions=new CommonFunctions(driver);
	}
	
	//page actions
	public WebElement getWebElement(By locator)
	{
		return driver.findElement(locator);
	}

	public String getPageTitle() {
		//System.out.println("Title of the current page: "+driver.getTitle());
		return driver.getTitle();
	}
	
	public boolean isSidebarDisplayed() {
		return commonFunctions.isElementDisplayed(getWebElement(sidebar));
	}
	
	public void clickOnBloodGroupsBtn()
	{
		getWebElement(menuHamburger).click();
		WebElement bloodGroupElement= getWebElement(bloodGroupsBtn);
		
		//Javascript executor to scroll to the web element 
		commonFunctions.scrollToElement(bloodGroupElement);
		
	    bloodGroupElement.click();
		
		//Explicit wait
	    WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(bgTable));
	
	}
	
	public void clickOnNewBtn()
	{
		//new button clicked
		getWebElement(newBtn).click();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void  enterBloodGroupDetails(String bloodGroup, String status)
	{
		
		//Blood group details entered
		getWebElement(bloodGroupTxt).clear();
		getWebElement(bloodGroupTxt).sendKeys(bloodGroup);
		Select select=new Select(getWebElement(statusDropdown));
		select.selectByVisibleText(status);
		System.out.println("Blood Groups->"+bloodGroup+"Status->"+status); 	
		
	}
	
	public void createBloodGroup()
	{
		//click on submit- new blood group created
		getWebElement(bloodGroupSubmitBtn).click();
		
	}
	
	public void clickOnEdit() 
	{
		getWebElement(verticalDots).click();
			
		getWebElement(editBtn).click();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void clickOnListButton()
	{
		//click on submit- new blood group created
		getWebElement(listBtn).click();
	}

	public Boolean searchBloodGroup(String id,String bloodGroup, String status)
	{
		//Filter button clicked
		getWebElement(filterBtn).click();
		
		//Enter Blood group details 
		getWebElement(idFilterTxt).sendKeys(id);
		getWebElement(bloodGroupFilterTxt).sendKeys(bloodGroup);
		Select select=new Select(getWebElement(bgFilterStatusDropdown));
		select.selectByVisibleText(status);
		
		//click on search after entering blood group details
		getWebElement(bloodGroupSearchBtn).click();
		
		driver.navigate().refresh();
		
        Boolean searchStatus=false;
		
		// To locate table.
		WebElement bgListTable = driver.findElement(bgTable);

		// To locate rows of table.
		List<WebElement> rows_table = bgListTable.findElements(By.tagName("tr"));

		// To calculate no of rows In table.
		int rows_count = rows_table.size();
		System.out.println("rows_count::" + rows_count);

		// Loop will execute for all the rows of the table
		for (int row = 0; row < rows_count; row++) {

			// To locate columns(cells) of that specific row.
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));

			// To calculate no of columns(cells) In that specific row.
			int columns_count = Columns_row.size();
			System.out.println("Number of cells In Row " + row + " are " + columns_count);

			if (columns_count > 1) {
				String bloogGroupId;
				if(id.equals(""))
				{
					bloogGroupId = Columns_row.get(1).getText();
					System.out.println(" bloogGroupId empty");
				}
				else
				{
				bloogGroupId = Columns_row.get(1).getText();
				System.out.println(" bloogGroupId not empty");
				}
				String bloogGroupColumnData = Columns_row.get(2).getText();
				String statusColumnData = Columns_row.get(3).getText();
				 System.out.println("bloogGroupId: "+bloogGroupId);
				 System.out.println("bloogGroupColumnData: "+bloogGroupColumnData);
				 System.out.println("statusColumnData: "+statusColumnData);

				if (bloogGroupId.equalsIgnoreCase(id) && bloogGroupColumnData.equalsIgnoreCase(bloodGroup) && statusColumnData.equalsIgnoreCase(status) ) {
					System.out.println("Search result matched");
					searchStatus=true;
					break;
				}
				else
				{
					System.out.println("Search is unsuccessful");
					searchStatus=false;
				}
			} else {
				System.out.println("Search result not matched:: No Records found");
				searchStatus=false;
			}

		}//for
		return searchStatus;
		
	}
	
	public void selectBloodGroups()
	{
		//checkbox group
		List<WebElement> checkboxGrp = driver.findElements(By.xpath("(//ins[@class='iCheck-helper'])[4]"));
		
		/*for(int i=2; i<4; i++)
		{
			checkboxGrp.get(i).click();
			
		}*/
		/*WebElement Element= driver.findElement(By.xpath("(//input[@class='grid-row-checkbox'])[1]"));
		//driver.findElement(By.xpath("(//input[@class='grid-row-checkbox'])[1]")).click();
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", Element);*/
	}
	
	//Delete
	public void clickOnDelete() 
	{
		getWebElement(verticalDots).click();
		getWebElement(deleteBtn).click();
		getWebElement(deleteConfirmBtn).click();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		getWebElement(deleteSucessBtn).click();
	}
	
	//validate mandatory fields
	public Boolean validateMandatoryFields(String expectedErrorText) 
	{
		String actualErrorText=getWebElement(NoBloodGroupErrMsg).getText();
		System.out.println("Actual error txt:"+actualErrorText+" expectedErrorText:"+expectedErrorText);
		if(actualErrorText.equalsIgnoreCase(actualErrorText))
			return true;
		else
			return false;
		
	}
	
	public void dontCreateBloodGroup()
	{
		getWebElement(bgDontSubmitBtn).click();
	}
	
	//Reset blood group
	public void clickOnReset()
	{
		bloodgroup=getWebElement(bloodGroupTxt).getAttribute("value").trim();
		WebElement status=getWebElement(statusDropdown);
		selectedStatus = new Select(status).getFirstSelectedOption().getText().trim();
		System.out.println("bloodgroup:"+bloodgroup+" status:"+selectedStatus);
		getWebElement(resetBtn).click();
	}
	public Boolean resetBloodGroup()
	{
	
		String resetBloodgroup=getWebElement(bloodGroupTxt).getText().trim();
		WebElement resetStatus=getWebElement(statusDropdown);
		String resetselectedStatus = new Select(resetStatus).getFirstSelectedOption().getText().trim();
		System.out.println("resetBloodgroup:"+resetBloodgroup+" resetStatus:"+resetselectedStatus);
		if(resetBloodgroup.equalsIgnoreCase("") && selectedStatus.equalsIgnoreCase(resetselectedStatus))
			return true;
		else
			return false;
		
	}
	
	//home breadcrumb
	public void clickOnHomeBreadcrumb()
	{
		getWebElement(homeBreadcrumb).click();
		driver.navigate().refresh();
	}

}
