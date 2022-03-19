# Selenium Webdriver Framework Demo Project
Automating Functional Testing Framework project uses the Page Object Model (POM) Design Pattern.

## Stack and Libraries
- Java
- TestNG
- Maven
- Selenium Webdriver
- Allure Report

## Prerequisties
- IDE (IntelliJ IDEA)
- JDK (8 or 11)
- OS (Windows 10)
- Maven Configuration ---> Put the (bin) folder path in The System Path of your device
- Allure Report Configuration ---> Put the (bin) folder path in the System Path of your device

## How to run Tests
- Right Click on testng.xml file and Click run.
- From Terminal run the following command:
```
mvn clean test
```

## Tests Report
- Open *target/surefire-reports/emailable-report.html* file by any browser
- From Terminal run the following command:
```
allure serve allure-results
```

