**Department & Employee Management Web App (JSP | Servlet | JDBC | MVC)**

A Java-based HR management web application built using JSP, Servlets, JDBC, HikariCP, and MySQL, following the MVC architecture.
This project allows HR users to authenticate securely, view department details, and list employees department-wise.

**Features**

HR Login Authentication using JDBC + MySQL

Department List Display

View Employees of a Selected Department

Custom JSP Tag Handlers for Data Iteration

HikariCP Connection Pool for fast DB access

MVC Pattern (Controller → Model → JSP)

JSP Views secured inside WEB-INF

Clean and simple UI with minimal CSS

----------------------------------------------------------------------------------------------------
**Tech Stack**

Backend:
Java (JDK 24+)

JSP  

Servlets (Jakarta EE )

JDBC

HikariCP

Frontend: JSP , HTML5 , CSS3

Database: MySQL
Tables: hrusers, dept, emp

-----------------------------------------------------------------------------------------------------------------------------
**Project Structure**

MVCApp/
│
├─ src/main/java/app/components/
│ ├─ HRControllerServlet.java
│ ├─ LoginModelBean.java
│ ├─ DeptEntry.java
│ ├─ EmpEntry.java
│ ├─ DeptListTag.java
│ ├─ EmpListTag.java
│ ├─ HRDB.java
│
├─ src/main/webapp/
│ ├─ WEB-INF/
│ │ ├─ pages/
│ │ │ ├─ login-view.jsp
│ │ │ ├─ departments-view.jsp
│ │ │ └─ employees-view.jsp
│ │ └─ taglib.tld
│ └─ web.xml
│
├─ pom.xml
└─ README.md

----------------------------------------------------------------------------------------------------
**Database Setup**

Create tables:

CREATE TABLE hrusers (
  userid VARCHAR(20) PRIMARY KEY,
  password VARCHAR(20)
);

CREATE TABLE dept (
  deptno INT PRIMARY KEY,
  dname VARCHAR(20),
  loc VARCHAR(20)
);

CREATE TABLE emp (
  empno INT PRIMARY KEY,
  ename VARCHAR(20),
  job VARCHAR(20),
  mgr INT,
  hiredate DATE,
  sal DECIMAL(10,2),
  comm DECIMAL(10,2),
  deptno INT
);

Insert a sample HR user:

INSERT INTO hrusers VALUES ('hr', 'hr123');

----------------------------------------------------------------------------------------------
**Database Configuration**

Edit your db.properties:

jdbcUrl=jdbc:mysql://<your-ip>:3306/cdac?useSSL=false&allowPublicKeyRetrieval=true
username=root
password=root




**Author**

Saurabh Amrutkar
Email: saurabhamrutkar259@gmail.com
GitHub: https://github.com/Saurabh9292
