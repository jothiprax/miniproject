# Hospital Management System

The Hospital Management System is a Java-based application that provides a solution for managing hospitals and their related information. This system allows users to perform various operations such as adding new hospitals, updating existing hospitals, deleting hospitals, and viewing all hospitals in the database.

## Contributors

- Pavan Kumar S (717821L334)
- Nandakumar J (717821L332)

## Features

- Add new hospitals with details like name, location, capacity, contact information, and more.
- Update the details of existing hospitals, including their name, location, contact information, and other attributes.
- Delete hospitals from the system based on their unique ID.
- View all hospitals stored in the database, displaying their complete information.
- Interactive console menu for easy navigation and user-friendly experience.

## Technologies Used

- Java programming language
- JDBC (Java Database Connectivity) for database operations
- MySQL database for storing hospital information

## Code Structure

- `com.kce.bean`: Contains the `Hospital` class representing the entity for a hospital with its attributes and getter/setter methods.
- `com.kce.dao`: Provides the `HospitalDAO` class that handles the database operations for hospitals, including adding, updating, deleting, and retrieving hospital records.
- `com.kce.util`: Includes the `DBUtil` class responsible for establishing the database connection and closing it when necessary.
- `com.kce.service`: Contains the `HospitalManagementSystem` class, the main class that implements the hospital management system functionality, including the user interface and interaction with the `HospitalDAO`.

## Usage

1. Set up a MySQL database and update the connection details in the `DBUtil` class.
2. Run the `HospitalManagementSystem` class to start the application.
3. Follow the instructions in the console menu to perform various operations on hospitals.

## Outputs

![Screenshot (63)](https://github.com/Pavankumar332/miniproject/assets/127392714/46463c6a-63f9-42a4-a3e5-0e69648c4388)
![Screenshot (61)](https://github.com/Pavankumar332/miniproject/assets/127392714/6b14d94a-a2e4-4c19-a1a4-9521a8710cee)
![Screenshot (62)](https://github.com/Pavankumar332/miniproject/assets/127392714/c18d854f-1d83-440f-a59f-ffeb80e37608)

## Contributions

Contributions to the Hospital Management System project are welcome! If you find any issues or have suggestions for improvements, feel free to open an issue or submit a pull request.
