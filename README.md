# 🧾 Employee Management System

A console-based application built using **Core Java**, **JDBC**, and **PostgreSQL** to perform **CRUD operations** on employee records. The application provides a simple, menu-driven interface for managing employee data effectively.

---

 **Features

- **Add Employee**: Add a new employee record to the database.
- **View All Employees**: Fetch and display all employee records.
- **Update Employee**: Update an employee's details (e.g., name, age, department, salary).
- **Delete Employee**: Remove an employee from the database by ID.
- **Menu-Driven Interface**: Easy-to-use console-based menu system.
- **Collections**: Uses Java Collections (e.g., List) to retrieve and manage employees.

---

**Technologies Used

- **Core Java** – Application logic using OOP principles.
- **JDBC** – Java Database Connectivity to PostgreSQL.
- **PostgreSQL** – Relational database to store employee data.
- **Maven** – Dependency and build management.

---

** Dependencies

The following Maven dependency is required:

```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.6.0</version>
</dependency>
Add this to your pom.xml.


**Prerequisites
Ensure the following are installed on your system:

JDK 17 or higher

Apache Maven 3.8.6 or higher

PostgreSQL 15 or higher

 PostgreSQL Database Setup
Create the following table in your PostgreSQL database:


**sql


Copy code
CREATE TABLE employees (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    department VARCHAR(100) NOT NULL,
    salary DECIMAL(10, 2) NOT NULL
);
 Make sure your database connection details are correctly set in your Java project.

**Structure

<img width="447" height="557" alt="image" src="https://github.com/user-attachments/assets/64c8e170-d7e6-41ef-9fe0-5074ae41f342" />


**Output Console

<img width="421" height="227" alt="image" src="https://github.com/user-attachments/assets/02353735-2eed-45ea-8193-dd6fb56548a9" />

**Group member

Shreya Shankar Tonape
Sakshi Shivaji Khandagale

 **Contact

Your Name: Shreya Shankar Tonape
 Email: shreyatonape65@gmail.com
 GitHub: Shreyatonape

Enjoy using this Management System! 🚀


