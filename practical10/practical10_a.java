package questions.practical10;

import java.util.ArrayList;
import java.util.List;

public class practical10_a {
    public static void main(String[] args) {
        Course course = new Course("OOPS", 10, 50);
        Course course2 = new Course("OS", 10, 50);

        Student s1 = new Student("lorem", 10);
        Student s2 = new Student("ipsum", 11);

        s1.setCourse(course);
        s1.setCourse(course2);

        s2.setCourse(course);
        // s2.setCourse(course2);

        s1.searchByName("lorem");
        s1.searchById(11);
    }
}

class Student {
    private String studentName;
    private int studentId;
    private List<Course> courses;
    private static List<Student> students = new ArrayList<>();
    
    public Student(String studentName, int studentId) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.courses = new ArrayList<>();
        students.add(this);
    }

    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public List<Course> getCourses() {
        return courses;
    }
    public void setCourse(Course course) {
        courses.add(course);
    }

    public void searchByName(String name) {
        for(Student student : students) {
            if(student.getStudentName().equals(name)) {
                System.out.println("studentId : " + student.getStudentId() + " courses: ");
                for(Course course : student.getCourses()) {
                    System.out.println(course.getCourseName());
                }
            }
        }
    }

    public void searchById(int id) {
        for(Student student : students) {
            if(student.getStudentId() == id) {
                System.out.println("student name : " + student.getStudentName() + " courses : ");
                for(Course course : student.getCourses()) {
                    System.out.println(course.getCourseName());
                }
            }
        }
    }
    
}

class Course {
    private String courseName;
    private int credit;
    private int maxMarks;

    public Course(String courseName, int credit, int maxMarks) {
        this.courseName = courseName;
        this.credit = credit;
        this.maxMarks = maxMarks;
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public int getCredit() {
        return credit;
    }
    public void setCredit(int credit) {
        this.credit = credit;
    }
    public int getMaxMarks() {
        return maxMarks;
    }
    public void setMaxMarks(int maxMarks) {
        this.maxMarks = maxMarks;
    }   
}