# **RPM-API**

A **Remote Patient Monitoring** API built using **Spring Boot**. This API allows healthcare systems to manage patients, monitor their vital signs, and handle alerts for anomalies in real-time.

## 🩺 Overview

The RPM-API provides RESTful services to:

- Add and update patient records
- Submit and track patient vital signs
- Generate alerts based on critical thresholds
- Simulate data for testing purposes (via JSON config files)

## 🚀 Technologies Used

- Java 11+
- Spring Boot
- Spring Data JPA
- H2 In-Memory Database
- Maven

## 📦 Installation

### 1. Clone the repository

```bash
git clone https://github.com/Sofre/RPM-API.git
cd RPM-API
```

### 2. Build the project 

```bash
mvn clean install
```

### 3. Run the project 

```bash
mvn spring-boot:run
```


##  🌐 API Access
Once the application is running, the API is available at: 

```bash
mvn spring-boot:run
```

## 🚚 Postman Testing
Test the API on Postman or use standard curl commands ! 



## 🛠 H2 Database Console
You can access the H2 database console for debugging or testing:

URL: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:testdb

Username: sa

Password: 23052001



## 📑 Sample Files
The following files are included to help you test and configure the API:

* CONFIG FOR API.txt – contains configuration info

* TEST JSON FOR API.txt – sample JSON payloads to use with the endpoints




## 🚀 Cloud Deployment on Podman 




## 👤 Author
Dushko Sofronievski
