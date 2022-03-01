$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("BloodGroup.feature");
formatter.feature({
  "line": 1,
  "name": "Blood Group feature",
  "description": "",
  "id": "blood-group-feature",
  "keyword": "Feature"
});
formatter.background({
  "line": 3,
  "name": "User is Logged In",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "I am on the Login page URL \"http://karehealth.menpaniproducts.com/admin/auth/login\"",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Enter userName \"admin\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Enter Password  \"admin\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Click on Submit Button",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "http://karehealth.menpaniproducts.com/admin/auth/login",
      "offset": 28
    }
  ],
  "location": "Login.i_am_on_the_Login_page_URL(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "admin",
      "offset": 16
    }
  ],
  "location": "Login.enter_userName(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "admin",
      "offset": 17
    }
  ],
  "location": "Login.enter_password(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Login.click_Submit_Button()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 9,
  "name": "Verify the title of page Blood Group",
  "description": "",
  "id": "blood-group-feature;verify-the-title-of-page-blood-group",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": "am in Dashboard page with title \"Admin | Dashboard\"",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "I click on Blood Group option from the left menu bar",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "I should be navigated to Blood Group list page with title Admin | Blood Group",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.uri("login.feature");
formatter.feature({
  "line": 1,
  "name": "Login in Kare - Health Project",
  "description": "",
  "id": "login-in-kare---health-project",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Login into the application with valid credentials",
  "description": "",
  "id": "login-in-kare---health-project;login-into-the-application-with-valid-credentials",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I am on the Login page URL \"http://karehealth.menpaniproducts.com/admin/auth/login\"",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "Enter userName \"admin\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "Enter Password  \"admin\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Click on Submit Button",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "http://karehealth.menpaniproducts.com/admin/auth/login",
      "offset": 28
    }
  ],
  "location": "Login.i_am_on_the_Login_page_URL(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "admin",
      "offset": 16
    }
  ],
  "location": "Login.enter_userName(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "admin",
      "offset": 17
    }
  ],
  "location": "Login.enter_password(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Login.click_Submit_Button()"
});
formatter.result({
  "status": "skipped"
});
});