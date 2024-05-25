package questions.practical10;

import java.util.ArrayList;
import java.util.List;

public class practical10_b {
    public static void main(String[] args) {
        
        Student s1 = new Student("lorem", 10);
        new Student("ipsum", 11);
        
        s1.searchByName("lorem");
        s1.searchById(11);
    }    
}

class Student {
    private static List<Student> students = new ArrayList<>();
    private String studentName;
    private int studentId;
    private List<Course> courses;

    Course course = new Course("OOPS", 10, 50);
    Course course2 = new Course("OS", 10, 50);

    public Student(String studentName, int studentId) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.courses = new ArrayList<>();
        students.add(this);
        courses.add(course);
        courses.add(course2);
    }

    public String getStudentName() {
        return studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourse(Course course) {
        this.courses.add(course);
    }

    public static void addStudent(Student student) {
        students.add(student);
    }

    public void searchByName(String name) {
        for(Student s : students) {
            if(s.getStudentName().equals(name)) {
                System.out.println("id: " + s.getStudentId() + " Courses: ");
                for(Course c : s.getCourses()) {
                    System.out.println(c.getCourseName());
                }
            }
        }
    }

    public void searchById(int id) {
        for(Student s : students) {
            if(s.getStudentId() == id) {
                System.out.println("name: " + s.getStudentName() + " Courses: ");
                for(Course c : s.getCourses()) {
                    System.out.println(c.getCourseName());
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

    public int getCredit() {
        return credit;
    }

    public int getMaxMarks() {
        return maxMarks;
    }   
}