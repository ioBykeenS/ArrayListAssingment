# ATM Machine - OOP Array & Methods

Name: Halis Ibrahim Kumala Chandra

Student ID: F1D02410049

## Description

This project is a simple **ATM Machine simulation** built using Java. The program demonstrates the use of **Arrays, Methods, Classes & Objects, Encapsulation, and Constructors** in Object-Oriented Programming (OOP).

The program allows users to add customers, open accounts, deposit money, withdraw money, check account balances, and view the customer list.

## Project Structure

```text
Bank/
├── Images/
│   ├── image.png
│   ├── image copy.png - image copy 8.png
├── Account.java     → Represents a bank account
├── Customer.java    → Stores customer information and accounts
├── Bank.java        → Manages the list of customers
├── Main.java        → Main program and interactive menu
└── README.md
```

## Class Explanation

### Account

The `Account` class represents a bank account. Each account starts with a balance of `0`.

| Method | Description |
|---|---|
| `getBalance()` | Returns the current account balance |
| `deposit(amount)` | Adds money to the account |
| `withdraw(amount)` | Withdraws money if the balance is sufficient |

The balance is stored as a `private` attribute, so it can only be accessed or modified through the methods provided by the class.

### Customer

The `Customer` class stores information about a customer and the accounts owned by that customer.

Each customer can have a maximum of **5 accounts**.

| Method | Description |
|---|---|
| `getFirstName()` | Returns the customer's first name |
| `getLastName()` | Returns the customer's last name |
| `setAccount(account)` | Adds an account to the customer |
| `getAccount(index)` | Returns an account based on its index |
| `getNumOfAccounts()` | Returns the number of accounts owned by the customer |

### Bank

The `Bank` class manages all customers registered in the system.

The bank uses an array with a capacity of **10 customers**.

| Method | Description |
|---|---|
| `addCustomer(firstName, lastName)` | Creates and adds a new customer |
| `getCustomer(index)` | Returns a customer based on their index |
| `getNumOfCustomers()` | Returns the number of registered customers |

## OOP Concepts Used

### 1. Class & Object

The program uses several classes to represent objects in the banking system.

For example:

```java
public class Account {
    ...
}
```

An object can then be created from the class:

```java
Account account = new Account();
```

The main classes used in this project are:

- `Account`
- `Customer`
- `Bank`

`Main` is used to run the program and handle user interaction.

### 2. Encapsulation

The attributes inside the classes use the `private` access modifier.

For example:

```java
private double balance;
```

Because `balance` is private, other classes cannot directly modify it.

The balance can be accessed using:

```java
public double getBalance() {
    return balance;
}
```

Changes to the balance are performed through methods such as `deposit()` and `withdraw()`.

### 3. Constructor

Constructors are used to initialize objects when they are created.

For example, the `Account` constructor initializes the balance:

```java
public Account() {
    this.balance = 0;
}
```

When the following code is executed:

```java
Account account = new Account();
```

the account automatically starts with a balance of `0`.

Constructors are also used in the `Customer` and `Bank` classes to initialize their objects.

### 4. Methods

Methods are used to perform specific operations inside each class.

For example:

```java
account.deposit(amount);
```

The `deposit()` method is responsible for adding money to the account.

Another example is:

```java
bank.addCustomer(firstName, lastName);
```

This method adds a new customer to the bank.

## Array Concepts Used

### Standard Arrays

This project uses standard Java arrays (`[]`) instead of `ArrayList`.

In `Bank.java`:

```java
private Customer[] customers;
```

The array is initialized with a capacity of 10:

```java
customers = new Customer[10];
```

This allows the bank to store up to 10 customers based on the array capacity used by the program.

In `Customer.java`:

```java
private Account[] accounts = new Account[5];
```

This gives each customer space to store up to 5 accounts.

### Object Relationships Using Arrays

The data structure can be represented as:

```text
Bank
│
├── Customer 1
│   ├── Account 1
│   ├── Account 2
│   └── ...
│
├── Customer 2
│   ├── Account 1
│   └── ...
│
└── Customer ...
```

The `Bank` stores `Customer` objects, while each `Customer` stores `Account` objects.

### Counters

Because standard arrays have a fixed size, the program uses counter variables to keep track of how many elements are actually being used.

In `Bank`:

```java
private int numberOfCustomers;
```

In `Customer`:

```java
private int numberOfAccounts = 0;
```

When a new customer is added:

```java
customers[numberOfCustomers] = new Customer(firstName, lastName);
numberOfCustomers++;
```

The counters are used to:

- Keep track of the number of customers or accounts.
- Determine the next available position in the array.
- Loop only through elements that contain data.
- Check whether the maximum number of accounts has been reached.

### Accessing Array Elements Using Indexes

Java arrays use indexes starting from `0`.

For example:

```java
Customer customer = bank.getCustomer(customerIndex);
```

However, the program displays customer choices starting from `1` for the user.

Therefore, the program decreases the user's selection by one:

```java
customerIndex--;
```

For example:

```text
User selects: 1
       ↓
Array index: 0
```

## Program Features

### 1. Add A New Customer

The user can add a new customer by entering a first name and last name.

The program also asks for confirmation before adding the customer.

### 2. Open A New Account For A Customer

The user can select a customer and open a new account for them.

Each customer can have a maximum of 5 accounts.

### 3. Deposit

The user selects a customer, selects an account, and enters the amount to deposit.

The program then calls:

```java
account.deposit(amount);
```

### 4. Withdraw

The user selects a customer and account, then enters the amount to withdraw.

The program then calls:

```java
account.withdraw(amount);
```

The withdrawal is only completed when the account has sufficient balance.

### 5. Check Savings

The user can select a customer and account to view the current balance.

The program uses:

```java
account.getBalance();
```

### 6. Customer Lists

The program displays all customers currently registered in the bank.

### 0. Exit

The user can exit the program by selecting `0`.
