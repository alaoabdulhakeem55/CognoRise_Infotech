package com.alaoabdulhakeem;

import java.util.ArrayList;

class Course {
    private final String courseCode;
    private final String title;
    private final String description;
    private final int capacity;
    private int enrolledStudents;
    private final String schedule;
    private final ArrayList<Student> students;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.enrolledStudents = 0;
        this.students = new ArrayList<>();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public String getSchedule() {
        return schedule;
    }

    public boolean registerStudent(Student student) {
        if (enrolledStudents < capacity) {
            students.add(student);
            enrolledStudents++;
            return true;
        } else {
            return false;
        }
    }

    public boolean dropStudent(Student student) {
        if (students.remove(student)) {
            enrolledStudents--;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Course Code: " + courseCode + "\nTitle: " + title + "\nDescription: " + description +
                "\nCapacity: " + capacity + "\nEnrolled Students: " + enrolledStudents + "\nSchedule: " + schedule;
    }
}

