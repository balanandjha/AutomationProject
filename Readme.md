


# 🚀 AutomationProject

A modular, Java-based test automation framework built for scalability, speed, and cloud execution. Designed for efficient test runs with LambdaTest integration, headless browser support, and rich reporting/logging systems.

---

## 🧰 Tech Stack

- ☕ **Java 11**
- ✅ **TestNG** – Structured testing and suite configuration
- 🌐 **LambdaTest** – Cross-browser cloud test execution
- 🧠 **OpenCSV** & **Gson** – Data-driven testing (CSV & JSON)
- 📋 **Apache POI** – Excel file handling
- 🎭 **Faker** – Fake data generation
- 📊 **Extent Reports** – Visual HTML reporting (`reports.html`)
- 🪵 **Log4j** – Detailed logging (`logs/` folder)

---


## 📦 Project Structure

AutomationProject/
├── src/
│   ├── main/java/
│   │   ├── core/             # Base classes and test infrastructure
│   │   ├── utils/            # Utility classes (data handling, logging, etc.)
│   │   ├── datadriven/       # Classes for OpenCSV, Gson, Apache POI usage
│   │   ├── fakerdata/        # Fake data generators using Faker
│   │   ├── lambdatest/       # LambdaTest configuration & execution logic
│   ├── test/java/
│   │   └── tests/            # TestNG test cases and test suites
├── testng.xml                # Central configuration for TestNG
├── pom.xml                   # Maven project file with dependencies
├── reports/                  # Folder for generated Extent Reports
│   └── reports.html          # Visual test report output
├── logs/                     # Log4j logs captured during test runs
└── README.md                 # Project documentation


## ⚙️ How to Run Tests

You can execute tests via Maven Surefire Plugin with custom parameters:

```bash
mvn test -Dbrowser=chrome -DisLambdaTest=true -DisHeadless=true

