package Difficult;

import java.util.Random;
import java.util.Scanner;

public class EmployeeBook {

    private final static Random RANDOM = new Random();
    private final static String[] FIRST_NAME = {"Иванов", "Петров", "Сидоров", "Суворов", "Жуков", "Невский",
            "Рокосовский"};
    private final static String[] LAST_NAME = {"Александр", "Георгий", "Михаил", "Иван", "Константин", "Алексей", "Сергей"};
    private final static String[] SOUR_NAME = {"Васильевич", "Иванович", "Георгиевич", "Константинович", "Михайлович"
            , "Сергеевич", "Алексеевич"};

    private final Employee[] EMPLOYEES = new Employee[10];

    private void initFullName() {
        for (int i = 0; i < EMPLOYEES.length; i++) {
            String fullName = FIRST_NAME[RANDOM.nextInt(0, FIRST_NAME.length)] + " " + LAST_NAME[RANDOM.nextInt(0,
                    LAST_NAME.length)] + " " + SOUR_NAME[RANDOM.nextInt(0, SOUR_NAME.length)];
            EMPLOYEES[i] = new Employee(fullName, RANDOM.nextInt(1, 6), RANDOM.nextInt(50000, 120000));

        }
    }

    private void printAll() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee);
        }
    }

    private void index(int ind) {
        for (Employee emp : EMPLOYEES) {
            float sal = (emp.getSalary() * (1 + (float) ind / 100));
            emp.setSalary((int) sal);
            System.out.println(emp);

        }
    }

    private Employee findMinSalaryInDepart(int num) {
        Employee employeeWithMin = null;
        for (Employee emp : EMPLOYEES) {
            if ((employeeWithMin == null || emp.getSalary() < employeeWithMin.getSalary()) & (emp.getDepartment() == num)) {
                employeeWithMin = emp;
            }
        }
        return employeeWithMin;
    }

    private Employee findMaxSalaryInDepart(int num) {
        Employee employeeWithMax = null;
        for (Employee emp : EMPLOYEES) {
            if ((employeeWithMax == null || emp.getSalary() > employeeWithMax.getSalary()) & (emp.getDepartment() == num)) {
                employeeWithMax = emp;
            }
        }
        return employeeWithMax;
    }

    private int summSalaryInDepart(int num) {
        int summ = 0;
        for (Employee emp : EMPLOYEES) {
            if (emp.getDepartment() == num) {
                summ += emp.getSalary();
            }
        }
        return summ;
    }

    private float averageSalaryInDepart(int num, int summSalaryInDepart) {
        int i = 0;
        for (Employee emp : EMPLOYEES) {
            if (emp.getDepartment() == num) {
                i += 1;
            }
        }
        return (float) summSalaryInDepart / i;
    }

    private void printDepart(int depart) {
        for (Employee emp : EMPLOYEES) {
            if (emp.getDepartment() == depart) {
                System.out.println("ID - " + emp.getId() + ". Сотрудник: " + emp.getFullName() + ", Зарплата " + emp.getSalary() + " рублей.");
            }
        }
    }

    private void indexInDepart(int ind, int depart) {
        for (Employee emp : EMPLOYEES) {
            if (emp.getDepartment() == depart) {
                float sal = (emp.getSalary() * (1 + (float) ind / 100));
                emp.setSalary((int) sal);
                System.out.println(emp);
            }
        }
    }

    private void salaryLessNum(int num, int depart) {
        System.out.println("Все сотрудники с ЗП меньше - " + num);
        for (Employee emp : EMPLOYEES) {
            if (emp.getDepartment() == depart && emp.getSalary() < num) {
                System.out.println("ID - " + emp.getId() + " " + emp.getFullName() + ". ЗП - " + emp.getSalary() + " " +
                                           "рублей.");
            }
        }
    }


    /**
     * Метод поиска и печати сотрудников с зп больше или равного числу по отделу
     *
     * @param num    - ЗП больше которой надо найти сотрудников
     * @param depart - номер отдела в котором ищется сотрудник
     */

    private void salaryMoreNum(int num, int depart) {
        System.out.println("Все сотрудники с ЗП больше или равной - " + num);
        for (Employee emp : EMPLOYEES) {
            if (emp.getDepartment() == depart && emp.getSalary() >= num) {
                System.out.println("ID - " + emp.getId() + " " + emp.getFullName() + ". ЗП - " + emp.getSalary() + " " +
                                           "рублей.");
            }
        }
    }

    /**
     * ---- Метод добавления сотрудника, с поиском свободной ячейки
     *
     * @param newEmp - новый сотрудник передаваемый в метод
     * @return возвращает истину если место есть и ложь если места нет
     */
    private boolean addEmployee(Employee newEmp) {
        for (int i = 0; i < EMPLOYEES.length; i++) {
            if (EMPLOYEES[i] == null) {
                EMPLOYEES[i] = newEmp;
                return true;
            }
        }
        return false;
    }

    /**
     * ---- Метод удаления сотрудника, с поиском по ID
     *
     * @param id - параметр для поиска
     */

    private void delEmployee(int id) {
        for (int i = 0; i < EMPLOYEES.length; i++) {
            if (EMPLOYEES[i] != null && EMPLOYEES[i].getId() == id) {
                EMPLOYEES[i] = null;
                return;
            }
        }
    }

    /**
     * Получение сотрудника по ID
     *
     * @param id - параметр для поиска
     * @return возвращает найденый объект.
     */
    private Employee getEmployeeById(int id) {
        for (Employee emp : EMPLOYEES) {
            if (emp != null && emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    public void main() {

        initFullName();

        printAll();

        Scanner inNum = new Scanner(System.in);

        System.out.print("\nВведите % для индексации ЗП (от 1 до 100) : ");
        int ind = inNum.nextInt();

        System.out.println("\nЗарплата сотрудников после индексации :");
        index(ind);

        System.out.print("\nВведите № отдела (от 1 до 5) : ");
        int depart = inNum.nextInt();

        System.out.printf("Сотрудник отдела № %d с минимальной ЗП :%n %s", depart, findMinSalaryInDepart(depart));
        System.out.printf("%nСотрудник отдела № %d с максимальной ЗП :%n %s", depart, findMaxSalaryInDepart(depart));
        int summSalaryInDepart = summSalaryInDepart(depart);
        System.out.printf("%nСумма затрат на ЗП по отделу № %d : - %s", depart, summSalaryInDepart);
        System.out.printf("%nСредняя сумма затрат на ЗП по отделу № %d : - %s", depart, averageSalaryInDepart(depart,
                summSalaryInDepart));
        System.out.printf("%nЗП отдела № %d проиндексирована на %d %%%n", depart, ind);
        indexInDepart(ind, depart);
        System.out.printf("%nСотрудники отдела №%d %n", depart);
        printDepart(depart);

        Employee maxWorkerSalary = findMaxSalaryInDepart(depart);
        int maxSalary = maxWorkerSalary.getSalary();
        System.out.printf("\nВведите границу ЗП (от 0 до %d) : ", maxSalary);

        int num = inNum.nextInt();

        salaryLessNum(num, depart);

        salaryMoreNum(num, depart);

        for (int i = 0; i < 2; i++) {

            System.out.printf("\nВведите ID сотрудника для удаления (от 0 до %d) : ", EMPLOYEES.length);
            num = inNum.nextInt();
            delEmployee(num);

        }

        printAll();
        System.out.println();

        String fullName = FIRST_NAME[RANDOM.nextInt(0, FIRST_NAME.length)] + " " + LAST_NAME[RANDOM.nextInt(0,
                LAST_NAME.length)] + " " + SOUR_NAME[RANDOM.nextInt(0, SOUR_NAME.length)];
        Employee newEmp = new Employee(fullName, RANDOM.nextInt(1, 6), RANDOM.nextInt(50000, 120000));
        String free = addEmployee(newEmp) ? "Свободная ячейка найдена, сотрудник добавлен." : "Свободных ячеек нет, " +
                                                                                                      "сотрудник не добавлен.";
        System.out.println(free);
        System.out.println();
        printAll();
        System.out.println();
        System.out.printf("\nВведите ID сотрудника для получения информации (от 0 до %d) : ", EMPLOYEES.length);
        num = inNum.nextInt();
        Employee foundEmp = getEmployeeById(num);
        if (foundEmp != null) {
            System.out.println(foundEmp);
        } else {
            System.out.println("Сотрудник с таким ID не найден.");
        }
    }

}
