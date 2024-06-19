import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CourseDatabase courseDB = new CourseDatabase();
        StudentDatabase studentDB = new StudentDatabase();
        Scanner scanner = new Scanner(System.in);

        // Adding some courses for testing
        courseDB.addCourse(new Course("CS101", "Intro to Computer Science", "Basics of CS", 30, "MWF 9-10AM"));
        courseDB.addCourse(new Course("MA101", "Calculus I", "Intro to Calculus", 40, "TTh 11-12:30PM"));

        // Adding some students for testing
        studentDB.addStudent(new Student("S001", "Alice"));
        studentDB.addStudent(new Student("S002", "Bob"));

        boolean exit = false;
        while (!exit) {
            System.out.println("\n1. Course Listing");
            System.out.println("\n2. Student Registration");
            System.out.println("\n3. Course Removal");
            System.out.println("\n4. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (option) {
                case 1: // Course Listing
                    System.out.println("Available Courses:");
                    for (Course course : courseDB.getCourses()) {
                        System.out.println(course);
                    }
                    break;

                case 2: // Student Registration
                    System.out.print("Enter Student ID: ");
                    String studentID = scanner.nextLine();
                    Student student = studentDB.findStudentByID(studentID);
                    if (student != null) {
                        System.out.print("Enter Course Code: ");
                        String courseCode = scanner.nextLine();
                        Course course = courseDB.findCourseByCode(courseCode);
                        if (course != null) {
                            if (course.registerStudent(studentID)) {
                                student.registerCourse(course);
                                System.out.println("Successfully registered for the course.");
                            } else {
                                System.out.println("Course is full.");
                            }
                        } else {
                            System.out.println("Course not found.");
                        }
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3: // Course Removal
                    System.out.print("Enter Student ID: ");
                    studentID = scanner.nextLine();
                    student = studentDB.findStudentByID(studentID);
                    if (student != null) {
                        System.out.print("Enter Course Code to drop: ");
                       String  courseCode = scanner.nextLine();
                        Course course = courseDB.findCourseByCode(courseCode);
                        if (course != null) {
                            if (course.removeStudent(studentID)) {
                                student.dropCourse(course);
                                System.out.println("Successfully dropped the course.");
                            } else {
                                System.out.println("You are not registered in this course.");
                            }
                        } else {
                            System.out.println("Course not found.");
                        }
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4: // Exit
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}
