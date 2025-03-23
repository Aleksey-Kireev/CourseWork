package Base;

import java.util.Random;

public class mainBase {

//   ----------- Массив данных для создания ФИО сотрудников -----------

    private final static Random RANDOM = new Random();
    private final static String[] FIRST_NAME = {"Иванов", "Петров", "Сидоров", "Суворов", "Жуков", "Невский",
            "Рокосовский"};
    private final static String[] LAST_NAME = {"Александр", "Георгий", "Михаил", "Иван", "Константин", "Алексей", "Сергей"};
    private final static String[] SOUR_NAME = {"Васильевич", "Иванович", "Георгиевич", "Константинович", "Михайлович"
            , "Сергеевич", "Алексеевич"};

//     ----------- Создаем массив объектов  -----------

    private final static Employee[] EMPLOYEES = new Employee[10];

//    ----------- Метод генерации ФИО и создания объекта сотрудник -----------

    public static void initFullName() {
        for (int i = 0; i < EMPLOYEES.length; i++) {
            String fullName = FIRST_NAME[RANDOM.nextInt(0, FIRST_NAME.length)] + " " + LAST_NAME[RANDOM.nextInt(0,
                    LAST_NAME.length)] + " " + SOUR_NAME[RANDOM.nextInt(0, SOUR_NAME.length)];
            EMPLOYEES[i] = new Employee(fullName, RANDOM.nextInt(1, 6), RANDOM.nextInt(50000, 120000));

        }
    }

//   ----------- Метод для печати всех данных по сотруднику -----------

    private static void printAll() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee);
        }
    }

    //     ----------- Метод для подсчета суммы по всем сотрудникам -----------
    private static int summSalary() {
        int summ = 0;
        for (Employee employee : EMPLOYEES) {
            summ = summ + employee.getSalary();

        }
        return summ;
    }

    //   ----------- Поиск сотрудника с минимальной ЗП -----------
    private static Employee findMinSalary() {
        Employee employeeWithMin = null;
        for (Employee employee : EMPLOYEES) {
            if (employeeWithMin == null || employee.getSalary() < employeeWithMin.getSalary()) {
                employeeWithMin = employee;
            }
        }
        return employeeWithMin;
    }

    //   ----------- Поиск сотрудника с максимальной ЗП -----------
    private static Employee findMaxSalary() {
        Employee employeeWithMax = null;
        for (Employee employee : EMPLOYEES) {
            if (employeeWithMax == null || employee.getSalary() > employeeWithMax.getSalary()) {
                employeeWithMax = employee;
            }
        }
        return employeeWithMax;
    }

    //    ----------- Метод средней ЗП
    private static float averageSalary() {
        return (float) summSalary() / EMPLOYEES.length;
    }

    //    Метод печати только ФИО
    private static void printFullName() {
        for (Employee employee : EMPLOYEES) {
            System.out.println(employee.getFullName());
        }

    }


    public static void main(String[] args) {

        initFullName();         // Вызываем метод генерации ФИО
        printAll();             // Печатаем всё

        System.out.printf("%nЗарплата всех сотрудников = %d рублей.", summSalary());
        System.out.printf("%nСотрудник с минимальной зарплатой - %s", findMinSalary());
        System.out.printf("%nСотрудник с максимальной зарплатой - %s", findMaxSalary());

        System.out.printf("%nСредняя зарплата - %.2f рублей.", averageSalary());
        System.out.println();

//        ФИО всех сотрудников
        printFullName();


    }


}
