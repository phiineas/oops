package questions.multithreading;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class question5 {
    public static void main(String[] args) {
        Course c1 = new Course("OOPS", 10, 100);
        Course c2 = new Course("MATH", 11, 100);

        Map<String, Student> students = new HashMap<>();
        
        students.put("1", new Student("lorem", 50));
        students.put("2", new Student("ipsum", 60));
        students.put("3", new Student("tipsum", 70));
        students.put("4", new Student("lorem", 90));
        students.put("5", new Student("ipsum", 80));
        
        c1.addStudent(students.get("1"));
        c1.addStudent(students.get("2"));
        c1.addStudent(students.get("3"));
        
        c2.addStudent(students.get("4"));
        c2.addStudent(students.get("5"));

        Runnable r1 = new Runnable() {
            public void run() {
                int sum = 0;
                for(Student s : c1.getStudents()) {
                    sum += s.getMarkAchived();
                }
                c1.setAverage(sum / (double) c1.getStudents().size());
            }
        };

        Runnable r2 = new Runnable() {
            public void run() {
                int sum = 0;
                for(Student s : c2.getStudents()) {
                    sum += s.getMarkAchived();
                }
                c2.setAverage(sum / (double) c2.getStudents().size());
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();

            System.out.println("Average of OOPS: " + c1.getAverage());
            System.out.println("Average of MATH: " + c2.getAverage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Student {
    private String studentName;
    private int markAchived;
    
    public Student(String studentName, int markAchived) {
        this.studentName = studentName;
        this.markAchived = markAchived;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getMarkAchived() {
        return markAchived;
    }

    public void setMarkAchived(int markAchived) {
        this.markAchived = markAchived;
    }

}

class Course {
    private String courseName;
    private int credit;
    private int maxMarks;
    private double average;
    private List<Student> students;

    public Course(String courseName, int credit, int maxMarks) {
        this.courseName = courseName;
        this.credit = credit;
        this.maxMarks = maxMarks;
        this.average = 0;
        this.students = new ArrayList<>();
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

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public double getAverage() {
        return average;
    }
    
    public void setAverage(double average) {
        this.average = average;
    }
}