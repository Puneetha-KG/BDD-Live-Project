$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("login.feature");
formatter.feature({
  "line": 1,
  "name": "Login in Kare - Health Project",
  "description": "",
  "id": "login-in-kare---health-project",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3323406583,
  "status": "passed"
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
  "duration": 3298771708,
  "status": "passed"
});
formatter.after({
  "duration": 43209,
  "status": "passed"
});
});