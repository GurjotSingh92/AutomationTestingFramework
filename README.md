# AutomationTestingFramework
Automation test framework

Overview
This is a test automation framework designed for auto. The approach used in the framework is Page-Object-Model combined with test driven approach using TestNG.The language used in this framework is Java. The framework is built with Selenium and Java. However, I have also provided Appium handling as well, if needed in future. Each test is independent and meaningful exception handling is done for each individual test case level. 

Framework Features:
1. All the tests are independent
2. Framework is capable of all types of platforms - Mobile,Web and API
3. Design pattern is type of Singleton pattern, which means single driver instance is maintained all across the framework. 
4. Cart gets cleared before executing any set of test cases
5. Reusable “setup” script that runs before each test suite.
6. Re-runnable an infinite number of times.
7. Maven is used as a dependency manager and all the dependencies are kept in pom.xml file
8. Test suite also contains a reusable “teardown” script that restores the web shop cart to its original state.
9. Extent Reports are provided for reporting. Screenshots are inbuilt in report itself
10. Utilities along with customized wrappers are also provided for re-usability purpose and are framework independent. 
11. pom.xml : build and versions maintenance, defining surefire plugin, source, resource directory etc, defining suit xml to run

List of Dependencies

Selenium (3.14.0)
Appium (1.10.0)
Maven (3.8.0)
Extent Report (2.41.2)
Apache POI (3.9)
Java (8)
Test NG (6.14.3)
Extent Reports (2.41.2)


Instructions to setup:

Pre-requisites:
1. Java 8 should be installed
2. Eclipse (any latest Eclipse version) is installed.
3. Maven command line is installed [Optional] - Download link

Step 1 - Import the framework
1. Download the zip folder attached in the email > Unzip it
2. Open Eclipse > Select workspace > Import the extracted zip folder.

Step 2: Install TestNG and Maven in Eclipse
1. Eclipse > Help > Eclipse Marketplace
2. Search for TestNG and Maven > Install it
3. Restart eclipse to reflect changes.

Step 3: Load all the dependencies
1. In framework > go to ‘pom.xml’ file > here you can see all the dependencies that are used for creation of the automation environment. 
2. Though dependencies will load automatically, if it doesn’t follow below steps:
3. Right click on pom.xml > Run As > Maven Install

Step 4 : Execute the framework
Method 1 (Via Eclipse):
Under ‘suits’ folder > there will be suit.xml file
Right click on suit.xml > Run As > TestNG Suite

Method 2 (Via Maven Commandline):
Navigate to the framework via command line. 
Execute command : mvn clean test

Step 5 : Reporting
Go to ‘ExtentReports’ folder > Refresh Eclipse 
There will be a report ‘Suite_Report_x_.html’ > Open and observe the execution results. 
