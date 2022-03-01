package stepdefinitions;

import pageObjects.BloodGroupPage;
import testBase.BaseTest;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.testng.asserts.SoftAssert;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BloodGroupSD extends BaseTest {
	
	public String title;
	String bloodGroup;
    String status;
	
	BloodGroupPage bloodGroupPage=new BloodGroupPage(driver);
	
	@Given("^left sidebar is displayed$")
	public void left_sidebar_is_displayed() throws Throwable {
		Assert.assertTrue(bloodGroupPage.isSidebarDisplayed());
	}

	@When("^I click on Blood Group option from the left sidebar$")
	public void i_click_on_Blood_Group_option_from_the_left_sidebar() throws Throwable {
		bloodGroupPage.clickOnBloodGroupsBtn();
	}

	@Then("^I should be navigated to Blood Group list page with title \"([^\"]*)\"$")
	public void i_should_be_navigated_to_Blood_Group_list_page_with_title(String expectedTitleName) throws Throwable {
		title = bloodGroupPage.getPageTitle().trim();
		System.out.println("Inside Step actualTitle is "+title+" expectedTitleName:"+expectedTitleName);
		Assert.assertTrue(title.contains(expectedTitleName));
	}
	@Given("^I am on Blood Group list page with title \"([^\"]*)\"$")
	public void i_am_on_Blood_Group_list_page_with_title(String expectedTitleName) throws Throwable {
		bloodGroupPage.clickOnBloodGroupsBtn();	
		title = bloodGroupPage.getPageTitle().trim();
		//System.out.println("Inside Step actualTitle is:: "+title);
		Assert.assertTrue(title.contains(expectedTitleName));
	}
	
	@When("^I enter new Blood Group details$")
	public void i_enter_new_Blood_Group_details(DataTable details) throws Throwable {
		 bloodGroupPage.clickOnNewBtn();
		 List<List<String>> data = details.raw();  
	     bloodGroup=data.get(1).get(0);
	     status=data.get(1).get(1);
	     System.out.println("Blood Groups::"+bloodGroup+"Status::"+status); 
	     bloodGroupPage.enterBloodGroupDetails(bloodGroup,status);
	}

	@When("^click on Submit$")
	public void click_on_Submit() throws Throwable {
		  bloodGroupPage.createBloodGroup();
	}

	@Then("^a new Blood Group should be created\\.$")
	public void a_new_Blood_Group_should_be_created() throws Throwable {
		//bloodGroupPage.searchBloodGroup("",bloodGroup,status);
	}
	@When("^I navigate to Blood Group create page$")
	public void i_navigate_to_Blood_Group_create_page() throws Throwable {
		 bloodGroupPage.clickOnNewBtn();
	}

	@When("^click on List$")
	public void click_on_List() throws Throwable {
		bloodGroupPage.clickOnListButton();
	}

	@Then("^I should be navigated to Blood Group list with \"([^\"]*)\"$")
	public void i_should_be_navigated_to_Blood_Group_list_with(String expectedTitleName) throws Throwable {
		title = bloodGroupPage.getPageTitle().trim();
		System.out.println("Inside Step actualTitle2 is:: "+title);
		Assert.assertTrue(title.contains(expectedTitleName));
	}

	@When("^I enter Blood Group details and click on Search$")
	public void i_enter_Blood_Group_details_and_click_on_Search(DataTable details) throws Throwable {
		 List<List<String>> data = details.raw();  
		  String id=data.get(1).get(0);
	      String bloodGroup=data.get(1).get(1);
	      String status=data.get(1).get(2);
	      bloodGroupPage.searchBloodGroup(id,bloodGroup,status);
	}

	@Then("^search results should be displayed\\.$")
	public void search_results_should_be_displayed() throws Throwable {
	    
	}
	
   @When("^I edit a blood group with details$")
   public void i_edit_a_blood_group_with_details(DataTable details) throws Throwable {
	 bloodGroupPage.clickOnEdit();
	 List<List<String>> data = details.raw();  
     String bloodGroup=data.get(1).get(0);
     String status=data.get(1).get(1);
     System.out.println("Blood Groups::"+bloodGroup+"Status::"+status); 
     bloodGroupPage.enterBloodGroupDetails(bloodGroup,status);
}

@Then("^Blood Group details should be changed to new details$")
public void blood_Group_details_should_be_changed_to_new_details() throws Throwable {
    
}

@When("^I select blood group enteries for deletion and click on Delete$")
public void i_select_blood_group_enteries_for_deletion_and_click_on_Delete() throws Throwable {
	bloodGroupPage.selectBloodGroups();
}

@Then("^selected blood group should be deleted$")
public void selected_blood_group_should_be_deleted() throws Throwable {
   
}

//Delete
@When("^I select a specific blood group for deletion and click on Delete$")
public void i_select_a_specific_blood_group_for_deletion_and_click_on_Delete() throws Throwable {
	 bloodGroupPage.clickOnDelete(); 
}

//verify mandatory fields
@When("^I do not enter Blood Group and click on Submit$")
public void i_do_not_enter_Blood_Group_and_click_on_Submit() throws Throwable {
	  bloodGroupPage.clickOnNewBtn();
	  bloodGroupPage.dontCreateBloodGroup();
}

@Then("^new Blood Group should be created and error message \"([^\"]*)\" should be displayed\\.$")
public void new_Blood_Group_should_be_created_and_error_message_should_be_displayed(String expectedErrorMsg) throws Throwable {
	//System.out.println("error message equal status:"+bloodGroupPage.validateMandatoryFields(expectedErrorMsg));
	assertTrue(bloodGroupPage.validateMandatoryFields(expectedErrorMsg)); 
}

//Reset functionality for Blood Group
@When("^click on Reset$")
public void click_on_Reset() throws Throwable {
	bloodGroupPage.clickOnReset();
}

@Then("^Blood Group details should be reset\\.$")
public void blood_Group_details_should_be_reset() throws Throwable {
	//System.out.println("resetBloodGroup?:"+bloodGroupPage.resetBloodGroup());
	//SoftAssert softAssert = new SoftAssert();
	//softAssert.assertTrue(bloodGroupPage.resetBloodGroup());
	//softAssert.assertAll();
}

//breadcrumb
@When("^I click on Home breadcrumb$")
public void i_click_on_Home_breadcrumb() throws Throwable {
	bloodGroupPage.clickOnHomeBreadcrumb();
}

@Then("^I should be navigated to dashbaord page with title \"([^\"]*)\"$")
public void i_should_be_navigated_to_dashbaord_page_with_title(String expectedTitleName) throws Throwable {
	title = bloodGroupPage.getPageTitle().trim();
	System.out.println("Inside Step actualTitle3 is:: "+title);
	Assert.assertTrue(title.contains(expectedTitleName));
}


}
