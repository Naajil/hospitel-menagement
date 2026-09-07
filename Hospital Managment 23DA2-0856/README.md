# Hospital Management System

A simple Java-based hospital management desktop application that helps manage patient records, waiting lines, treatment history, and queue operations using common data structures.

## Project Overview

This project simulates a basic hospital workflow where a receptionist or staff member can:

- Add new patients
- Search for a patient by ID
- Delete patient records
- View the current waiting line
- Serve the next patient
- Undo the last treatment action
- Display patient treatment history
- List all registered patients

## Data Structures Used

The application combines the following concepts:

- Binary Search Tree for patient records
- Queue for patient waiting line management
- Stack for treatment logs
- Linked List / chained history for patient treatment history

## Main Features

1. Patient registration
2. Patient search by ID
3. Patient deletion
4. Waiting queue operations
5. Patient treatment tracking
6. History viewing for each patient
7. Patient list display in sorted order

## Project Structure

```text
Hospital Managment 23DA2-0856/
├── src/
│   ├── main.java
│   ├── PatientBST.java
│   ├── PatientHistoryChain.java
│   ├── PatientProfile.java
│   ├── TreatmentLog.java
│   └── WaitingLineManager.java
├── README.md
└── project files and media assets
```

## How to Run

1. Open the project folder in a Java IDE such as VS Code, IntelliJ IDEA, or Eclipse.
2. Make sure Java is installed on your system.
3. Compile the project:

```bash
javac src/*.java
```

4. Run the application:

```bash
java -cp src main
```

If your IDE supports running Java files directly, you can also run `main.java` from there.

## Example Menu

```text
--- Hospital Management System ---
1. Add patient
2. Search patient
3. Delete patient
4. Show waiting line
5. Serve next patient
6. Undo last treatment
7. Show patient history
8. List all patients
0. Exit
```

## Notes

This project is a learning/demo hospital management system and demonstrates the use of core data structures in a real-world scenario.

## License

This project is provided for educational purposes.
