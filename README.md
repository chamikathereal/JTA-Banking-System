# 🚀 JTA-Banking-System

## 📝 Overview Of Banking System 

**JTA-Banking-System** is a simple yet practical Java EE application simulating core banking operations. The system allows users to register, log in, create accounts, and perform secure fund transfers between accounts. Each operation is designed to ensure data consistency, reliability, and security using enterprise Java best practices. The banking process involves:

- ✅ **User Registration:** New users can sign up and their details are persisted securely.
- ✅ **User Login:** Registered users can log in to access their accounts.
- ✅ **Account Management:** Users can manage their bank accounts, view balances, and initiate transfers.
- ✅ **Fund Transfer:** Users can transfer funds between accounts, with all changes managed transactionally to guarantee atomicity and consistency.

---

## 📽️ Demo Video
[![JTA-Banking-System Project Demo](https://github.com/chamikathereal/JTA-Banking-System/blob/main/JTA-Banking-System.png)](https://youtu.be/bZokMHj12PA)

---

## 🗂️ Project Structure

```
JTA-Banking-System/
├── src/
│   └── main/
│       ├── java/
│       │   └── lk.jiat.ee.bank/
│       │       ├── ejb/
│       │       │   ├── remote/
│       │       │   │   ├── AccountService.java
│       │       │   │   ├── LoginService.java
│       │       │   │   ├── RegisterService.java
│       │       │   │   └── TransferService.java
│       │       │   ├── AccountServiceBean.java
│       │       │   ├── BeanA.java
│       │       │   ├── BeanB.java
│       │       │   ├── LoginServiceBean.java
│       │       │   ├── RegisterServiceBean.java
│       │       │   └── TransferServiceBean.java
│       │       ├── entity/
│       │       │   ├── Account.java
│       │       │   └── User.java
│       │       ├── filter/
│       │       │   └── RequestFilter.java
│       │       └── servlet/
│       │           ├── Login.java
│       │           ├── Register.java
│       │           ├── Test.java
│       │           └── Transfer.java
│       ├── resources/
│       │   └── META-INF/
│       │       ├── persistence.xml
│       │       └── ehcache.xml
│       └── webapp/
│           ├── home.jsp
│           ├── index.jsp
│           ├── login.jsp
│           └── register.jsp
├── pom.xml
```
> *Key files for transaction testing: `BeanA.java`, `BeanB.java`, and `Test.java`.*

---

## 🗄️ Caching & Persistence Configuration

### 🗃️ Persistence Layer

- ✅ **JPA & Hibernate:** The project uses JPA (via Hibernate) for ORM, mapping `User` and `Account` entities to database tables.
- ✅ **persistence.xml:** Configures the persistence unit, database dialect, and JTA transaction platform.
- ✅ **Database:** MySQL is the default database, with connection settings and schema management handled via Hibernate.

### ⚡ Ehcache Integration

- ✅ **Second-Level Cache:** Hibernate’s second-level cache is enabled using Ehcache, improving performance by caching frequently accessed entities like `User` and `Account`.
- ✅ **ehcache.xml:** Defines cache regions, expiry policies, and persistence directory for caching user and account data.
  - ✅ `account-cache` region for `Account` entities
  - ✅ Cache entries have a TTL (time-to-live) of 60 minutes and persistent disk storage

---

## 🔄 Transaction Testing

A major highlight of this project is the demonstration of Java EE transaction management using JTA.  
Special EJBs—**BeanA** and **BeanB**—along with the **Test** servlet, are dedicated to testing and illustrating transaction boundaries, propagation, and bean-managed transactions.

- ✅ **BeanA & BeanB:** Both are stateless beans using bean-managed transactions. Methods like `doAction()` and `doWork()` are used to test transaction context propagation and behavior between beans.
- ✅ **Test Servlet:** Invokes methods on BeanA and BeanB to trigger and observe transaction scenarios, making it easy to experiment with JTA features in a real application context.

This setup is ideal for anyone looking to understand or demonstrate how JTA transactions work in Java EE, especially around manual transaction demarcation, propagation, and rollback scenarios.

---

## 🔁 Project Workflow

- ✅ User registers via the registration form (`register.jsp`), handled by `Register` servlet and `RegisterServiceBean`.
- ✅ User logs in using the login form (`login.jsp`), processed by `Login` servlet and `LoginServiceBean`.
- ✅ Authenticated user accesses their dashboard (`home.jsp`) and can perform transfers.
- ✅ Fund transfers are initiated via the `Transfer` servlet, which delegates to `TransferServiceBean` for transactional operations.
- ✅ Transaction testing can be triggered via the `Test` servlet, which calls methods in `BeanA` and `BeanB` to demonstrate JTA behavior in action.

---

## ✨ Summary

JTA-Banking-System is a concise, practical Java EE project that covers both the essentials of a banking application and advanced transaction management with JTA. It features clean separation of concerns, robust persistence and caching, and dedicated modules for experimenting with enterprise transaction concepts. This makes it a valuable learning resource for students, developers, and anyone interested in enterprise Java application design and transaction handling.

---

## 🧑‍💻 Author

Chamika Gayashan  
Undergraduate Software Engineer | Sri Lanka  
Linkedin: @chamikathereal  
Current date: Saturday, June 14, 2025, 7:55 PM +0530
