package com.alaoabdulhakeem;

import java.util.ArrayList;

class CourseDatabase {
    private final ArrayList<Course> courses;

    public CourseDatabase() {
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void displayCourses() {
        for (Course course : courses) {
            System.out.println(course);
            System.out.println("Available Slots: " + (course.getCapacity() - course.getEnrolledStudents()));
            System.out.println();
        }
    }

    public Course getCourseByCode(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
                return course;
            }
        }
        return null;
    }
}
