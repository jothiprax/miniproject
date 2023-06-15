# Product Delivery Management System

The Product Delivery Management System is a Java-based application that provides a solution for managing Ordered product details and their related information. This system allows users to perform various operations such as adding new Orders, updating existing Orders, deleting Orders, and viewing all Orders in the database.

## Contributors

- MAHARAJAN M (717821L327)
- ARUN V (717821L304)

## Features

- Add new Order with details like Customer id,Customer name,Product id,Product name,Ordered date,Delivery date,status and more.
- Update the details of existing Orders, including their Ordered date,Delivery date,status and other attributes.
- Delete Orders from the system based on their unique ID and Status of the Ordered product.
- View all Orders stored in the database, displaying their complete information.
- Interactive console menu for easy navigation and user-friendly experience.

## Technologies Used

- Java programming language
- JDBC (Java Database Connectivity) for database operations
- MySQL database for storing Ordered product information

## Code Structure

- `com.kce.bean`: Contains the `Customer` class representing the entity for a Customer with its attributes and getter/setter methods.
                  Contains the `Product` class representing the entity for a Product with its attributes and getter/setter methods.
                  Contains the `Order` class representing the entity for a Orders with its attributes and getter/setter methods.
- `com.kce.dao`: Provides the `crud` class that handles the database operations for Orders, including adding, updating, deleting, and retrieving Ordered product details.
- `com.kce.util`: Includes the `DBUtil` class responsible for establishing the database connection and closing it when necessary.
                  Includes the `customerException` class responsible for handling the exception and it is an user defined exception.
- `com.kce.service`: Contains the `Main` class, the main class that implements the Product delivery management system functionality, including the user interface and interaction with the           `crud`.

## Usage

1. Set up a MySQL database and update the connection details in the `DBUtil` class.
2. Run the `Main` class to start the application.
3. Follow the instructions in the console menu to perform various operations on Ordered product.

## Outputs
Order table :
![1 table](https://github.com/Maharajan123/miniproject/assets/123573721/a8efe68a-4081-497d-9f2d-33a31711bea9)

Add Order : 
![2 1 add data(1)](https://github.com/Maharajan123/miniproject/assets/123573721/2200f38c-a262-477a-80dc-e9b9bf4df7e3)
![2 1 con add data(1)](https://github.com/Maharajan123/miniproject/assets/123573721/b65a3536-bc3e-4f37-929c-23b38bcf3d58)

Changed status : 
![2 2 1 changed status(2)](https://github.com/Maharajan123/miniproject/assets/123573721/d2c3f671-61f6-4128-927a-f4c7c3a1604f)
![2 2 1con changed status(2)](https://github.com/Maharajan123/miniproject/assets/123573721/9431832b-11f2-459c-ae02-cde47dc758a3)

Changed deliverydate : 
![2 2 2 changed deliverydate(2)](https://github.com/Maharajan123/miniproject/assets/123573721/8db94b50-d192-499d-ba33-0600b6e97f90)
![2 2 2 con changed deliverydate(2)](https://github.com/Maharajan123/miniproject/assets/123573721/0438c59c-aed4-49e9-b441-af665b13459a)

Cancel order : 
![2 3 cancel order(3)](https://github.com/Maharajan123/miniproject/assets/123573721/78282c84-aebf-42eb-871c-aefa66b0d895)
![2 3 con cancel order(3)](https://github.com/Maharajan123/miniproject/assets/123573721/d471f3a0-e58a-4f35-ad8e-8ae2fb150b48)

Display orders using customerid : 
![2 4 display customerid(4)](https://github.com/Maharajan123/miniproject/assets/123573721/9b46a8cc-2589-47f9-9c51-f9ef67ff204d)

Display orders using status of the order : 
![2 4 display status(4)](https://github.com/Maharajan123/miniproject/assets/123573721/95876eba-7765-4c27-afe6-df832fe3098f)

Display all orders : 
![2 5 display all details(5)](https://github.com/Maharajan123/miniproject/assets/123573721/bae16a6a-f88c-49c8-81b9-116cec7c1cca)

Wrong input : 
![wrong option](https://github.com/Maharajan123/miniproject/assets/123573721/e54cb885-5bcb-41e0-9374-5d89e99bd405)


## Contributions

Contributions to the Product Delivery Management System project are welcome! If you find any issues or have suggestions for improvements, feel free to open an issue or submit a pull request.
