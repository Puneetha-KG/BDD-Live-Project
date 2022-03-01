Feature: Login in Kare - Health Project

  Scenario: Login into the application with valid credentials
  	Given I am on the Login page URL "http://karehealth.menpaniproducts.com/admin/auth/login"
    When Enter userName "admin"
    When Enter Password  "admin"
    Then Click on Submit Button

   
