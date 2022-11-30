# batterycup 🪫🔋
This is a GUI made using Java Swing for computing bills for Electric Cars.
It lets User perform multiple operations like:-


1- User can Create his Personal login for security purposes.

2- User can Add customers and Calculate their Electricity Bill.

3- User can Pay Electricity Bills.

4- User can Generate Bill.

## About Project:
This Java application was created using Intelli J .
Additional library was added for the support of JDBC (Required to setup the connection between the Database and Java Application).
It contains 9 different classes which works together to create a better user experience .

->Splash Screen class

->Login Screen class

->Main System class

->Add Customer class

->Pay Bill class

->Generate Bill class

->Show Details class

->Last Bill class

->Connection Setup class(JDBC - MySQL)

## Database (MySQL)
Database for this Electric Car Billing System contains 4 Tables


->Login Table (UserName,Password)

<img src="https://github.com/jasleen101010/batterycup/blob/main/ScreenShots/login%20table-java.png">

->Bill Table(MeterNumber,Units,Month,Amount)

<img src="https://github.com/jasleen101010/batterycup/blob/main/ScreenShots/bill%20.png">

->Emp Table(Name, MeterNumber, Address, State, City, Email, Phone)
<img src="https://github.com/jasleen101010/batterycup/blob/main/ScreenShots/emp%20table.png">



Java communicates with MySQL tables using JDBC which stands for Java Database Connectivity.
<img src="https://github.com/jasleen101010/batterycup/blob/main/ScreenShots/queries-java.png">

## Screenshots:

## Login

<img src="https://github.com/jasleen101010/batterycup/blob/main/ScreenShots/login%20page.png" width="800" height="400">

## Main Page

<img src="https://github.com/jasleen101010/batterycup/blob/main/ScreenShots/batterycup%20menu.png" width="600" height="500">

## Add Customer

<img src="https://github.com/jasleen101010/batterycup/blob/main/ScreenShots/new%20user%20.png" width="500" height="500">

## Calculate Bill

<img src="https://github.com/jasleen101010/batterycup/blob/main/ScreenShots/new%20entry.png" width="500" height="500">

## Details

<img src="https://github.com/jasleen101010/batterycup/blob/main/ScreenShots/customer%20details.png" width="800" height="300">

## Generate Bill

<img src="https://github.com/jasleen101010/batterycup/blob/main/ScreenShots/generate%20bill.png" width="400" height="700">
