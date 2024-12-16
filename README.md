# Automation Infrastructure Project
## Demo Video

[demo video: Tests Run With Jenkins](videos/Running%20Tests%20Using%20Jenkins.mp4)


## Description

This project showcases an intelligent and modular automation infrastructure. The framework is organized hierarchically, with modules containing various classes and methods. Key modules include main, common, helpers, actions, and page objects, enabling the creation of tests with minimal code. The design supports working with different types of applications, offering flexibility. One of the major strengths of this infrastructure is its ease of maintenance, making it highly adaptable and efficient for ongoing development.

## Features

- Modular Test Framework: Scalable architecture for adding new tests and features easily.  
- Web and Mobile Automation: Supports both **web-based testing** with Selenium and **mobile testing** with Appium.  
- API Testing: Includes automated testing for REST APIs, ensuring endpoint functionality and data integrity.  
- Electron App Testing: Supports testing for desktop applications built with Electron.  
- Database Testing: Validates data consistency and correctness by interacting with **MySQL** databases.  
- Data-Driven Testing: Tests can be executed with various datasets sourced from CSV files, ensuring broader test coverage.  
- Test Reporting and Logging: Detailed reports are generated after each test run. 
- Video Recording: Records videos of test executions for visual debugging and analysis.  
- Cross-Platform Testing: Designed to work on multiple platforms, making it suitable for both desktop and mobile environments.  
- CI/CD Ready: The framework is ready to be integrated into continuous integration/continuous deployment pipelines (with Jenkins). 

## Project Structure  

- **src/main/java**: Contains the core test framework, page object models, utilities, and base classes.  
- **src/test/java**: Contains the test cases and test suites.  
- **test-recordings**: Directory where videos/screenshots are saved (if enabled).  
- **pom.xml**: Maven project configuration file, where dependencies are managed.  

## Acknowledgments  

This project utilizes the following technologies:  

- **Selenium WebDriver**: For web automation.  
- **Appium**: For mobile application testing.  
- **TestNG Testing Framework**: For managing and running test cases.  
- **Listeners Interface**: Used to generate logs and customize the TestNG reports.  
- **Maven**: For dependency management and building the project.  
- **Jenkins**: For executing tests as part of a CI/CD pipeline.  
- **MySQL Free Online DB**: For database testing and validation.  
- **REST Assured**: For API testing.  
- **Allure Reports**: Provides detailed and visually appealing test reports.


## Applications Used in This Project  

- **React Shopping Cart**: A demo web-based application.  
- **Unit Converter**: A mobile application.  
- **ReqRes.in**: A demo REST API platform.  
- **Electron Application**: A desktop application built with Electron.


## Installation

### Prerequisites

Before running the project, make sure the following software is installed:

- **Java 11** (for running Selenium and Appium tests)
- **Maven** (for dependency management and project builds)
- **Git** (for cloning the repository)
- **IntelliJ IDEA** or your preferred Java IDE

### Steps to Install

1. **Clone the Repository:**

   Open your terminal and clone the repository:
   ```bash
   git clone https://github.com/ritadim/FinalProject.git
   ```


   
2. **Navigate to the Project Directory:**
   
   ```bash
   mvn test
   ```



3. **Install Project Dependencies:**

   Use Maven to install the required dependencies:
   ```bash
   mvn install
   ```



4. **Open the Project in IntelliJ IDEA:**
 
    Open the project in your IDE.



   
## Usage  

To run all tests in the project, use the following command:  
```bash
mvn test
```
To run a specific test suite, use the following command:
```bash
mvn test -P<the suite profile name in the pom.xml>
```
To review the test reports, use the command:
```bash
allure serve allure-results
```

## Test Execution  

Each application in this project includes several demonstration tests. These tests are easy to develop thanks to the well-structured infrastructure, which simplifies the process of creating and managing test cases (e.g., Sanity Tests).
