package com.bhavaniproject.SchoolManagmentSystem;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter 

class Student {
    private String name;
    private int rollNumber;
    private double fee;

    public Student(String name, int rollNumber, int fee) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.fee = fee;
    }

    public void updateName(String newName) {
        this.name = newName;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public double getFee() {
        return fee;
    }

    public void displayDetails() {
        System.out.println("Student Name: " + this.name);
        System.out.println("Roll Number: " + this.rollNumber);
        System.out.println("Fee Details: $" + this.fee);
        System.out.println("---------------");
    }

    public int getRollNumber() {
        return rollNumber;
    }
}

class Teacher {
    private String name;
    private int employeeId;
    private double salary;

    public Teacher(String name, int employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    public void updateName(String newName) {
        this.name = newName;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void displayDetails() {
        System.out.println("Teacher Name: " + this.name);
        System.out.println("Employee ID: " + this.employeeId);
        System.out.println("Salary: $" + this.salary);
        System.out.println("----------------");
    }

    public int getEmployeeId() {
        return employeeId;
    }
}

public class School {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Teacher> teachers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            
            System.out.println("1. Add New Student");
            System.out.println("2. Update Student Details");
            System.out.println("3. Display all Students");
            System.out.println("4. Display Fee Details for Students");
            System.out.println("5. Accept Fee Details for Students"); // Renamed Case 5
            System.out.println("6. Print Fee Details for Students ");
            System.out.println("7. Add New Teacher");
            System.out.println("8. Update Teacher Details");
            System.out.println("9. Delete Teacher Details");
            System.out.println("0. Exit");
            System.out.println("Select an option:");

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. please enter a valid integer.");
                scanner.nextLine();
                continue;
            }
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Add New Student
                    System.out.println("Enter Student name:");
                    String studentName = scanner.nextLine();
                    System.out.println("Enter Student roll number:");
                    int studentRollNumber = scanner.nextInt();
                    System.out.println("Enter Student fee:");
                    int StudentFee = scanner.nextInt();
                    scanner.nextLine();
                    students.add(new Student(studentName, studentRollNumber, StudentFee));
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    // Update Student Details
                    System.out.println("Enter the roll number of the student to update:");
                    //scanner.nextInt();
                   
                    int rollToUpdate=0;
                 try {
                        rollToUpdate = scanner.nextInt();
                   }catch (InputMismatchException e) {
                        System.out.println("Invalid input. please enter a valid integer.");
                        scanner.nextLine();
                        break;
                    }
                    scanner.nextLine();
                 //  System.out.println("Student Details Updated Successfully");

                    for (Student student : students) {
                        if (student.getRollNumber() == rollToUpdate) {
                            System.out.println("Enter the new name for the student:");
                            String newName = scanner.nextLine();
                            student.updateName(newName);
                            System.out.println("Student details updated successfully.");
                            break;
                        }else {
                        	System.out.println("Invalid Rollnumber");
                        }
                        
                    }
                    break;

                case 3:
                    // Display all Students
                    System.out.println("List of all students:");
                    for (Student student : students) {
                        student.displayDetails();
                    }
                    break;

                case 4:
                    // Display Fee Details for Students
                    System.out.println("Displaying Fee Details for Students:");
                    for (Student student : students) {
                        student.displayDetails();
                    }
                    break;
                case 5:
                    // Accept Fee Details for Students
                    System.out.println("Enter the roll number of the student to update fee details:");
                    int rollToUpdateFee;
                    try {
                        rollToUpdateFee = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. please enter a valid integer.");
                        scanner.nextLine();
                        break;
                    }
                    scanner.nextLine();

                    for (Student student : students) {
                        if (student.getRollNumber() == rollToUpdateFee) {
                            System.out.println("Enter the new fee for the student:");
                            double newFee = scanner.nextDouble();
                            student.setFee(newFee);
                            System.out.println("Fee details updated successfully.");
                            break;
                        }
                    }
                    break;
                case 6:
                    // Print Fee Details for Students
                    System.out.println("Printing Fee Reciepts for Students:");
                    for (Student student : students) {
                        student.displayDetails();
                    }
                    break;

                

                case 7:
                    // Add New Teacher
                    System.out.println("Enter teacher name:");
                    String teacherName = scanner.nextLine();
                    System.out.println("Enter teacher employee ID:");
                    int teacherEmployeeId = scanner.nextInt();
                    scanner.nextLine();
                    teachers.add(new Teacher(teacherName, teacherEmployeeId));
                    System.out.println("Teacher added successfully.");
                    break;

                case 8:
                    // Update Teacher Details
                    System.out.println("Enter the employee ID of the teacher to update:");
                    int employeeIdToUpdate;
                    try {
                        employeeIdToUpdate = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. please enter a valid integer.");
                        scanner.nextLine();
                        break;
                    }
                    scanner.nextLine();

                    for (Teacher teacher : teachers) {
                        if (teacher.getEmployeeId() == employeeIdToUpdate) {
                            System.out.println("Enter the new name for the teacher:");
                            String newName = scanner.nextLine();
                            teacher.updateName(newName);
                            System.out.println("Teacher details updated successfully.");
                            
                            break;
                        }
                        
                    }
                    break;

                case 9:
                    // Delete Teacher Details
                    System.out.println("Enter the employee ID of the teacher to delete:");
                    int employeeIdToDelete;
                    try {
                        employeeIdToDelete = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid integer.");
                        scanner.nextLine();
                        break;
                    }
                    scanner.nextLine();

                    boolean teacherFound = false;
                    for (Teacher teacher : teachers) {
                        if (teacher.getEmployeeId() == employeeIdToDelete) {
                            teachers.remove(teacher);
                            teacherFound = true;
                            System.out.println("Teacher with Employee ID " + employeeIdToDelete + " deleted.");
                            break;
                        }
                    }

                    

                    if (!teacherFound) {
                        System.out.println("Teacher with Employee ID " + employeeIdToDelete + " not found.");
                    }
                    break;

                

                case 0:
                    System.out.println("ThankYou");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

}