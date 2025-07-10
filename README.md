# Hibernate Country-Region CRUD Project

This project is a console-based Java application using **Hibernate Native API**, **PostgreSQL**, and **Maven**, designed to perform CRUD operations on `countries` and `regions` tables in a relational database.

---

## Features

- **Add Region**: Insert new region data.
- **View All Regions**: Display all regions from the database.
- **Update Region**: Modify existing region name.
- **Delete Region**: Remove region by ID.

- **Add Country**: Insert a new country under a region.
- **View All Countries**: Display all countries with associated region details.
- **Update Country**: Modify country name or region.
- **Delete Country**: Delete a country by ID.

---

## Technologies Used

- **Core Java** – Console interaction and business logic.
- **Hibernate (Native API)** – ORM tool for database interaction using native `Session` and `Query`.
- **PostgreSQL** – Relational database for storing region and country data.
- **Maven** – Project and dependency management.

---

##Dependencies

Add this to your `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>org.hibernate</groupId>
        <artifactId>hibernate-core</artifactId>
        <version>5.6.15.Final</version>
    </dependency>
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <version>42.6.0</version>
    </dependency>
</dependencies>


Database Schema
Execute these SQL commands in your PostgreSQL environment:

sql
Copy
Edit
CREATE TABLE regions (
    region_id SERIAL PRIMARY KEY,
    region_name VARCHAR(25) DEFAULT NULL
);

CREATE TABLE countries (
    country_id CHAR(2) PRIMARY KEY,
    country_name VARCHAR(40) DEFAULT NULL,
    region_id INT NOT NULL,
    FOREIGN KEY (region_id) REFERENCES regions(region_id) ON DELETE CASCADE ON UPDATE CASCADE
);


Project Structure
css
Copy
Edit
HibernateCountryRegionCRUD/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/
│   │   │       ├── model/
│   │   │       │   ├── Region.java
│   │   │       │   └── Country.java
│   │   │       ├── dao/
│   │   │       │   ├── RegionDAO.java
│   │   │       │   └── CountryDAO.java
│   │   │       └── main/
│   │   │           └── Main.java
│   └── resources/
│       └── hibernate.cfg.xml
├── pom.xml
└── README.md
⚙️ Configuration (hibernate.cfg.xml)
Place this file in src/main/resources/:

xml
Copy
Edit
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://hibernate.org/dtd/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
    <session-factory>
        <property name="hibernate.connection.driver_class">org.postgresql.Driver</property>
        <property name="hibernate.connection.url">jdbc:postgresql://localhost:5432/Hibernate</property>
        <property name="hibernate.connection.username">postgres</property>
        <property name="hibernate.connection.password">pass@123</property>
        <property name="hibernate.dialect">org.hibernate.dialect.PostgreSQLDialect</property>

        <property name="show_sql">true</property>
        <property name="format_sql">true</property>
        <property name="hbm2ddl.auto">update</property>

        <mapping class="com.example.model.Region"/>
        <mapping class="com.example.model.Country"/>
    </session-factory>
</hibernate-configuration>

 How to Run

Clone or download the project.

Import it as a Maven Project into your IDE (e.g., IntelliJ, Eclipse).

Configure PostgreSQL database and update credentials in hibernate.cfg.xml.

Run the Main.java file.

Use the console menu to perform CRUD operations.

## Author
Name: Shreya Shankar Tonape
Email: —shreyatonape65@gmail.com
GitHub: —Shreyatonape

 ##Notes
Uses Hibernate native API (i.e., Session, Query, not JPA).

Uses @Entity, @Table, @Id, @ManyToOne, @JoinColumn annotations.



