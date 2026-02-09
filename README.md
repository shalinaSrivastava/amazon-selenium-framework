# 🛒 Amazon Selenium Automation Project

## Project Overview

This project is an end-to-end UI automation framework built using **Java, Selenium WebDriver, TestNG, and Page Object Model (POM)**.
It automates major user flows on an Amazon-like e-commerce website including search, add to cart, cart operations, and checkout.

The framework is designed using real industry standards and best practices.

---

## Tech Stack

* Java
* Selenium WebDriver
* TestNG
* Page Object Model (POM)
* Maven (if used)
* TestNG Listeners (Screenshot on failure)
* DataProvider for test data
* Cross-browser support

---

##  Project Structure

Project1
│
├── base
│   └── BaseTest.java
│
├── pages
│   ├── HomePage.java
│   ├── SearchResultsPage.java
│   ├── AddToCartPage.java
│   ├── AddToCartPopupPage.java
│   ├── CartPage.java
│   ├── CheckoutPage.java
│   ├── LoginPage.java
│   └── RegistrationPage.java
│
├── tests
│   ├── search
│   ├── addtocart
│   ├── cart
│   ├── checkout
│   ├── login
│   └── registration
│
├── utils
│   ├── DataProviderUtils.java
│   ├── ConfigReader.java
│   └── ExcelUtils.java
│
├── listeners
│   ├── TestListener.java
│   └── RetryAnalyzer.java
│
└── testng.xml
```

---

##  Features Covered

### Search Module

* Search product with multiple inputs
* Validate search result keyword

### Add to Cart Module

* Add item from product details page
* Add item from search result popup
* Cancel add to cart popup
* Cart count validation

### Cart Module

* Verify item present in cart
* Update quantity
* Remove item
* Verify empty cart

### Checkout Module

* Guest checkout flow
* Logged-in checkout flow
* Redirect validation to sign-in

### Login Module

* Valid login
* Invalid login
* Empty fields validation

### Registration Module

* Valid registration
* Duplicate email check
* Weak password validation

---

## Testing Strategy

### Smoke Tests

* Search product
* Add to cart
* Basic checkout flow

### Regression Tests

* Full user journey
* Negative scenarios
* Edge cases

---

##  TestNG Features Used

* DataProvider for test data
* Groups:

  * `smoke`
  * `regression`
* Listeners:

  * Screenshot on failure
* Cross-browser execution via parameters

---

##  How to Run Tests

### Run Smoke Tests

Use `testng.xml` with:

```
<include name="smoke"/>
```

### Run Regression Tests

```
<include name="regression"/>
```

### Cross Browser Execution

Set browser parameter:

```
<parameter name="browser" value="chrome"/>
<parameter name="browser" value="edge"/>
```

---

## Screenshot Capture

* Automatically captures screenshots on test failure
* Stored inside:

```
/reports/screenshots/
```

---

##  Test Data

* Product data via DataProvider
* Login & Registration data supported

---

## Design Pattern Used

* Page Object Model (POM)
* Separation of:

  * Tests
  * Pages
  * Utilities
  * Config

---

## Purpose of Project

This project demonstrates:

* Real-world Selenium framework design
* Test automation best practices
* Structured and scalable test architecture
* Industry-ready QA portfolio work

---

##  Author

Name - Shalina Srivastava
QA Automation Enthusiast
Java | Selenium | TestNG | Manual + Automation Testing


- CI/CD Integration (Jenkins)
- Extent Reports
* Excel-driven data testing
* Parallel execution optimization
