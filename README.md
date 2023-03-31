# guru99BankingDemoProject
This is a Demo project for Automation Testing using Selenium.
#### Project website link: http://demo.guru99.com/v4/ <br>

------------------------------------------------

## Technology <br>
Tool: selenium <br>
Build tool: Maven <br>
Language: Java <br>
Framework: TestNG,Data Driven Framework(DDF) <br>
Report: Extent<br>
Project Structure: Page object Model(POM)<br>
Dependency Used:apache poi,extentreports,log4j,testng,selenium-java,etc<br>
IDE: Intellij<br>

--------------------------------------------------

### To Run the project with Different Test Runner:<br>

Use the following command from the Cmd: mvn clean test -Dfilename=testNG_File_name.xml<br>
Example: mvn clean test -Dfilename=regression_testng.xml<br>

--------------------------------------------------

Number Of Module: 3 <br>
Total testcase: 98 <br>
Total Bug:11<br>

### Test Report Location: <br>
> project root -> test-output-> Test-Report-date.html <br>

### Sample Report Screenshot <br>
#### Deposit section Report
![deposit](https://user-images.githubusercontent.com/38497405/115549550-957ca700-a2ca-11eb-9478-46b1710325c4.PNG)
#### Fund Transfer section Report
![fund](https://user-images.githubusercontent.com/38497405/115549636-b0e7b200-a2ca-11eb-8516-306749c18c6d.PNG)
#### WithDrawal section Report
![withdrawal](https://user-images.githubusercontent.com/38497405/115549850-f7d5a780-a2ca-11eb-9c7a-0cfcb1b107bd.PNG)

----------------------------------------------------------

## Jenkins Related Info:<br>
This project is basically a demo test automation site provided by guru99 where we have brought three modules (Account, Customer, Manager) under test automation. In this project, we have applied data-driven testing and we created four types of test runners (Sanity, Regression, Parallel, and Master)using testNG framework. We can define which browser to test and in which mode (Headed/Headless) the browser will run as parameters in this test runner file.<br>
In the pom.xml file, we have configured to dynamically import the test runner file using maven-surefire-plugin, so now if you provide any test runner file name from the command line, the test will be run automatically through the expected test runner.<br>

We have done jenkins integration in this project. In Jenkins, we create a maven project where we have given the Git repository link so that whenever these will be first imported the updated codes and then postscript will run as per the script given in the video.In the video, we have used the script to run the regression test and the name of this script is sent dynamically i.e. if we write another test runner name after the filename parameter then the tests of the test runner will be run, and finally, after the test run is completed a testNG report will be generated.<br>

To See the Demo Video click [here](https://youtu.be/qM3hXO2TbMM)<br>
