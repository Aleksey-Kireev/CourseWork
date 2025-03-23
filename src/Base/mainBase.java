package Base;

import java.util.Random;

public class mainBase {

    private final static Random RANDOM = new Random();
    private final static String[] FIRST_NAME = {"Иванов", "Петров", "Сидоров", "Суворов", "Жуков", "Невский",
            "Рокосовский"};
    private final static String[] LAST_NAME = {"Александр", "Георгий", "Михаил", "Иван", "Константин", "Алексей", "Сергей"};
    private final static String[] SOUR_NAME = {"Васильевич", "Иванович", "Георгиевич", "Константинович", "Михайлович"
            , "Сергеевич", "Алексеевич"};

    private final static Employee[] EMPLOYEES = new Employee[10];


    public static void initFullName() {
        for (int i = 0; i < EMPLOYEES.length; i++) {
            String fullName = FIRST_NAME[RANDOM.nextInt(0, FIRST_NAME.length)] + " " + LAST_NAME[RANDOM.nextInt(0,
                    LAST_NAME.length)] + " " + SOUR_NAME[RANDOM.nextInt(0, SOUR_NAME.length)];
            EMPLOYEES[i] = new Employee(fullName, RANDOM.nextInt(1, 6), RANDOM.nextInt(50000, 120000));

        }
    }

    private static void printAll() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee);
        }
    }

    private static int summSalary() {
        int summ = 0;
        for (Employee employee : EMPLOYEES) {
            summ = summ + employee.getSalary();

        }
        return summ;
    }

    private static Employee findMinSalary() {
        Employee employeeWithMin = null;
        for (Employee employee : EMPLOYEES) {
            if (employeeWithMin == null || employee.getSalary() < employeeWithMin.getSalary()) {
                employeeWithMin = employee;
            }
        }
        return employeeWithMin;
    }

    private static Employee findMaxSalary() {
        Employee employeeWithMax = null;
        for (Employee employee : EMPLOYEES) {
            if (employeeWithMax == null || employee.getSalary() > employeeWithMax.getSalary()) {
                employeeWithMax = employee;
            }
        }
        return employeeWithMax;
    }

    private static float averageSalary() {
        return (float) summSalary() / EMPLOYEES.length;
    }

    private static void printFullName() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee.getFullName());
        }

    }

    public static void main(String[] args) {

        initFullName();
        printAll();

        System.out.printf("%nЗарплата всех сотрудников = %d рублей.", summSalary());
        System.out.printf("%nСотрудник с минимальной зарплатой - %s", findMinSalary());
        System.out.printf("%nСотрудник с максимальной зарплатой - %s", findMaxSalary());

        System.out.printf("%nСредняя зарплата - %.2f рублей.", averageSalary());
        System.out.println();

        printFullName();

    }

}
