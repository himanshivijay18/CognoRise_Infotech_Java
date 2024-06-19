//import java.util.*;
//
//public class Student {
// private String ID;
// private String name;
// private List<String> registeredCourses;
//
// public Student(String ID , String name){
//     this.ID = ID;
//     this.name = name;
//     this.registeredCourses = new ArrayList<>();
// }
// public String getID(){
//     return ID;
// }
//
// public String name (){
//     return name;
// }
//
// public List<String> getRegisteredCourses(){
//    return registeredCourses;
// }
//
//
//
//    public void registerCourse(Course course){
//        registeredCourses.add(String.valueOf(course));
//    }
//
//
//    public void removeCourse(Course course){
//     registeredCourses.remove(course);
// }
//
// public String tostring(){
//     return "Student ID : " + ID + " Name : " + name + " Registered Courses : " + registeredCourses;
// }

import java.util.*;

public class Student {
    private String studentID;
    private String name;
    private List<Course> registeredCourses;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        registeredCourses.add(course);
    }

    public void dropCourse(Course course) {
        registeredCourses.remove(course);
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID + ", Name: " + name + ", Registered Courses: " + registeredCourses;
    }
}
