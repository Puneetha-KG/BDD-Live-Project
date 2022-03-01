Feature: Blood Group feature

Background: User is Logged In
   	Given I am on the Login page URL "http://karehealth.menpaniproducts.com/admin/auth/login"
    When Enter userName "admin"
    When Enter Password  "admin"
    Then Click on Submit Button
 #1.   
 Scenario: Verify the title of page Blood Group list page
 Given left sidebar is displayed
 When I click on Blood Group option from the left sidebar   
 Then I should be navigated to Blood Group list page with title "Admin | Blood Group"
 
 #2.
 #Scenario: Verify creation of new Blood Group
 #Given I am on Blood Group list page with title "Admin | Blood Group"
 #When I enter new Blood Group details 
 #|Blood Group|Status|
 #|O-|Pending for approval|
 #And click on Submit
 #Then a new Blood Group should be created.
 #
 #3.
 #Scenario: Verify entering of mandatory fileds for Blood Group creation
 #Given I am on Blood Group list page with title "Admin | Blood Group"
 #When I do not enter Blood Group and click on Submit
 #Then new Blood Group should be created and error message " The Blood Group field is required." should be displayed.
 #
 #4.
 #Scenario: Verify Reset functionality of a Blood Group
 #Given I am on Blood Group list page with title "Admin | Blood Group"
 #When I enter new Blood Group details 
 #|Blood Group|Status|
 #|O-|Pending for approval|
 #And click on Reset
 #Then Blood Group details should be reset.
 #
 #5.
 #Scenario: Verify the functionality of List button in Blood Group Edit screen.
 #Given I am on Blood Group list page with title "Admin | Blood Group"
 #When I navigate to Blood Group create page
 #And click on List
 #Then I should be navigated to Blood Group list with "Admin | Blood Group"
   #
 #6. 
 #Scenario: Verify search of a Blood Group
 #Given I am on Blood Group list page with title "Admin | Blood Group"
 #When I enter Blood Group details and click on Search 
 #|Id|Blood Group|Status|
 #|340|O-|Pending for approval|
 #Then search results should be displayed.
#
 #7.  
 #Scenario: Verify Edit functionality for Blood Group
 #Given I am on Blood Group list page with title "Admin | Blood Group"
 #When I edit a blood group with details
 #|Blood Group|Status|
 #|O-|Active|
 #And click on Submit
 #Then Blood Group details should be changed to new details
#
 #8.
 #Scenario: Verify Delete functionality for a specific Blood Group
 #Given I am on Blood Group list page with title "Admin | Blood Group"
 #When I select a specific blood group for deletion and click on Delete
 #Then selected blood group should be deleted
 #
 #9.
 #Scenario: Verify navigation to dashboard using home breadcrumb
 #Given I am on Blood Group list page with title "Admin | Blood Group"
 #When I click on Home breadcrumb
 #Then I should be navigated to dashbaord page with title "Admin | Dashboard"
  #
 #10.
 #Scenario: Verify reset of filter details
 #Given I am on Blood Group list page with title "Admin | Blood Group"
 #When I enter Blood Group details and click on Search 
 #|Id|Blood Group|Status|
 #|340|O-|Pending for approval|
 #And reset the filter details
 #Then filter details should be cleared and I should be navigated to Blood Group list
 #
 #11.
 #Scenario: Verify Delete functionality for Blood Group
 #Given I am on Blood Group list page with title "Admin | Blood Group"
 #When I select blood group enteries for deletion and click on Delete
 #Then selected blood groups should be deleted
 