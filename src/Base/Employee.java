package Base;

import java.util.Objects;

public class Employee {

    private static int idWorker = 1;
    private final String fullName;
    private int department;
    private int salary;
    private final int id;

    public Employee(String fullName, int department, int salary) {
        id = idWorker++;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("ID - %d. Сотрудник: %s, Отдел № %d, Зарплата %d рублей.", id, fullName, department,
                salary);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && salary == employee.salary && id == employee.id && Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, department, salary, id);
    }
}
