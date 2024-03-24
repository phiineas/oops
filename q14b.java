package questions;

public class q14b {
    private String id;
    private String name;
    private double monthly_salary;

    public q14b() {
        this.id = "";
        this.name = "";
        this.monthly_salary = 0.0;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setMonthlySalary(double monthly_salary) {
        this.monthly_salary = monthly_salary;
    }

    public double getMonthlySalary() {
        return this.monthly_salary;
    }

    public void displayEmployee() {
        System.out.println("ID: " + this.id);
        System.out.println("Name: " + this.name);
        System.out.println("Monthly Salary: " + this.monthly_salary);
    }

    public static void main(String[] args) {
        q14b employee1 = new q14b();
        employee1.setId("E001");
        employee1.setName("lorem porem");
        employee1.setMonthlySalary(5000);

        q14b employee2 = new q14b();
        employee2.setId("E002");
        employee2.setName("ipsum porem");
        employee2.setMonthlySalary(6000);

        System.out.println("Yearly salary of " + employee1.getName() + ": " + (employee1.getMonthlySalary() * 12));
        System.out.println("Yearly salary of " + employee2.getName() + ": " + (employee2.getMonthlySalary() * 12));

        employee1.setMonthlySalary(employee1.getMonthlySalary() * 1.1);
        employee2.setMonthlySalary(employee2.getMonthlySalary() * 1.1);

        System.out.println("Yearly salary of " + employee1.getName() + " after 10% raise: " + (employee1.getMonthlySalary() * 12));
        System.out.println("Yearly salary of " + employee2.getName() + " after 10% raise: " + (employee2.getMonthlySalary() * 12));
    }
}