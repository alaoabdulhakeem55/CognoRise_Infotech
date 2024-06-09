package com.alaoabdulhakeem;

import java.util.Scanner;

public class StudentCourseRegistrationSystem {
    public static void main(String[] args) {
        CourseDatabase courseDatabase = new CourseDatabase();
        StudentDatabase studentDatabase = new StudentDatabase();
        Scanner scanner = new Scanner(System.in);

        // Add some sample courses
        courseDatabase.addCourse(new Course("CS101", "Introduction to Computer Science", "Basic concepts of computer science", 30, "MWF 10:00-11:00"));
        courseDatabase.addCourse(new Course("MATH101", "Calculus I", "Introduction to calculus", 25, "TTh 9:00-10:30"));
        courseDatabase.addCourse(new Course("ENG101", "English Literature", "Study of English literature", 20, "MWF 11:00-12:00"));

        // Add some sample students
        studentDatabase.addStudent(new Student("S001", "Alice Johnson"));
        studentDatabase.addStudent(new Student("S002", "Bob Smith"));

        // Text-based menu for user interaction
        while (true) {
            System.out.println("\nStudent Course Registration System:");
            System.out.println("1. Display Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. Display Registered Courses");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    courseDatabase.displayCourses();
                    break;
                case 2:
                    System.out.print("Enter student ID: ");
                    String studentID = scanner.nextLine();
                    Student student = studentDatabase.getStudentByID(studentID);
                    if (student != null) {
                        System.out.print("Enter course code to register: ");
                        String courseCode = scanner.nextLine();
                        Course course = courseDatabase.getCourseByCode(courseCode);
                        if (course != null) {
                            if (student.registerCourse(course)) {
                                System.out.println("Successfully registered for the course.");
                            } else {
                                System.out.println("Registration failed. Course may be full.");
                            }
                        } else {
                            System.out.println("Course not found.");
                        }
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter student ID: ");
                    studentID = scanner.nextLine();
                    student = studentDatabase.getStudentByID(studentID);
                    if (student != null) {
                        System.out.print("Enter course code to drop: ");
                        String courseCode = scanner.nextLine();
                        Course course = courseDatabase.getCourseByCode(courseCode);
                        if (course != null) {
                            if (student.dropCourse(course)) {
                                System.out.println("Successfully dropped the course.");
                            } else {
                                System.out.println("Dropping course failed.");
                            }
                        } else {
                            System.out.println("Course not found.");
                        }
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter student ID: ");
                    studentID = scanner.nextLine();
                    student = studentDatabase.getStudentByID(studentID);
                    if (student != null) {
                        System.out.println("Registered courses for " + student.getName() + ":");
                        for (Course registeredCourse : student.getRegisteredCourses()) {
                            System.out.println(registeredCourse);
                        }
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
