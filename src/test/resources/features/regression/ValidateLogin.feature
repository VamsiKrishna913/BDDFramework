#this feature use to check the login functionality of the Adactiin Hotel app
Feature: To Validate Login Functionality Of Adaction Hotel App

Background: 
Given user starts "chrome" the browser
And user launch the app using the url "https://adactinhotelapp.com/index.php"

@Smoke @Regression
Scenario: To Validate Login Using Valid Username and Valid Password

When user enters the text "Vamsi7984" in the text using xpath "//input[@name='username']"
When user enters the text "0J7ISI" in the text using xpath "//input[@name='password']"
And user clicks the login button using xpath "//input[@name='login']"
Then user verify the title of the page to be "Adactin.com - Search Hotel"


@Regression @Smoke @wip1907
Scenario: To Validate Login Using Valid Username and Invalid Password Creditials


When user enters the text "Vamsi7984" in the text using xpath "//input[@name='username']"
When user enters the text "0J7IAS" in the text using xpath "//input[@name='password']"
And user clicks the login button using xpath "//input[@name='login']"
Then user verify the presence of text using xpath "//div[@class='auth_error']/b"
|error message|
|Invalid Login details or Your Password might have expired. Click here to reset your password| 
Then user verify the title of the page to be "Adactin.com - Hotel Reservation System"

@Regression @wip1907
Scenario: To Validate Login Using InValid Username and valid Password Creditials


When user enters the text "Vamsi7945" in the text using xpath "//input[@name='username']"
When user enters the text "0J7ISI" in the text using xpath "//input[@name='password']"
And user clicks the login button using xpath "//input[@name='login']"
Then user verify the presence of text using xpath "//div[@class='auth_error']/b"
|error message|
|Invalid Login details or Your Password might have expired. Click here to reset your password| 
Then user verify the title of the page to be "Adactin.com - Hotel Reservation System"

@Regression  @wip1907
Scenario: To Validate Login Using InValid Username and Invalid Password Creditials

 
When user enters the text "Vamsi7456" in the text using xpath "//input[@name='username']"
When user enters the text "0J7IAS" in the text using xpath "//input[@name='password']"
And user clicks the login button using xpath "//input[@name='login']"
Then user verify the presence of text using xpath "//div[@class='auth_error']/b"
|error message|
|Invalid Login details or Your Password might have expired. Click here to reset your password| 
Then user verify the title of the page to be "Adactin.com - Hotel Reservation System"