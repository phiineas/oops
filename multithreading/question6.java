package questions.multithreading;

import java.util.ArrayList;
import java.util.List;

public class question6 {
    public static void main(String[] args) throws InterruptedException {
        List<Student> students = new ArrayList<>();

        for (int i = 1; i <= 30; i++) {
            Student student = new Student(i);
            student.addCourse(new Course("MATH", (int) (Math.random() * 100)));
            student.addCourse(new Course("OOPS", (int) (Math.random() * 100)));
            student.addCourse(new Course("OS", (int) (Math.random() * 100)));
            students.add(student);
        }

        Thread t1 = new Thread(new AverageMarks(students.subList(0, 10)));
        Thread t2 = new Thread(new AverageMarks(students.subList(10, 20)));
        Thread t3 = new Thread(new AverageMarks(students.subList(20, 30)));

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class Course {
    String name;
    int marks;

    Course(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public int getMarks() {
        return marks;
    }
}

class Student {
    int id;
    List<Course> courses;

    public Student(int id) {
        this.id = id;
        this.courses = new ArrayList<>();
    }

    void addCourse(Course course) {
        this.courses.add(course);
    }

    double calculateAverage() {
        return courses.stream().mapToInt(Course::getMarks).average().orElse(0.0);
    }
}

class AverageMarks implements Runnable {
    private final List<Student> students;

    AverageMarks(List<Student> students) {
        this.students = students;
    }

    @Override
    public void run() {
        for (Student student : students) {
            double average = student.calculateAverage();
            System.out.println("studentId: " + student.id + "\nAverage Marks: " + average);
        }
    }
}
