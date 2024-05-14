package questions.practical10;

import java.util.*;

class Course {
    String courseName;
    int credit;
    int maxMarks;

    Course(String courseName, int credit, int maxMarks) {
        this.courseName = courseName;
        this.credit = credit;
        this.maxMarks = maxMarks;
    }

    Course searchByName(List<Course> courses, String name) {
        for (Course course : courses) {
            if (course.courseName.equals(name)) {
                return course;
            }
        }
        return null;
    }

    Course searchByCredit(List<Course> courses, int credit) {
        for (Course course : courses) {
            if (course.credit == credit) {
                return course;
            }
        }
        return null;
    }
}

class Student {
    static List<Student> students = new ArrayList<>();
    int id;
    String name;
    List<Course> courses = new ArrayList<>();

    Student(int id, String name) {
        this.id = id;
        this.name = name;
        students.add(this);
    }

    void addCourse(Course course) {
        this.courses.add(course);
    }

    Student searchById(int id) {
        for (Student student : students) {
            if (student.id == id) {
                return student;
            }
        }
        return null;
    }

    Student searchByName(String name) {
        for (Student student : students) {
            if (student.name.equals(name)) {
                return student;
            }
        }
        return null;
    }
    
    void searchStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student name or ID: ");
        String input = scanner.nextLine();


        Student searchedStudent;
        if (input.matches("\\d+")) {
            int id = Integer.parseInt(input);
            searchedStudent = searchById(id);
        } else {
            searchedStudent = searchByName(input);
        }
        scanner.close();

        if (searchedStudent != null) {
            System.out.println("Found student: " + searchedStudent.name);
            System.out.println("Courses taken by the student:");
            for (Course course : searchedStudent.courses) {
                System.out.println("Course: " + course.courseName);
                System.out.println("Credit: " + course.credit);
                System.out.println("Max Marks: " + course.maxMarks);
            }
        } else {
            System.out.println("Student not found.");
        }
    }
}

public class practical10 {
    public static void main(String[] args) {
        Student s1 = new Student(1, "lorem");
        Student s2 = new Student(2, "ipsum");
        Student s3 = new Student(3, "gibsum");
        Student s4 = new Student(4, "tipsum");

        Course c1 = new Course("OOPS - JAVA", 4, 100);
        Course c2 = new Course("DBMS", 5, 99);
        Course c3 = new Course("Data Structures", 4, 95);
        Course c4 = new Course("Operating Systems", 5, 98);

        s1.addCourse(c1);
        s1.addCourse(c2);
        s1.addCourse(c4);

        s2.addCourse(c1);
        s2.addCourse(c3);

        s3.addCourse(c4);
        s3.addCourse(c2);

        s4.addCourse(c1);
        s4.addCourse(c2);
        s4.addCourse(c4);

        Student student = new Student(0, "");
        student.searchStudent();
    }
}