package Midle;

import java.util.Random;
import java.util.Scanner;

public class mainMidle {

//   ----------- Массив данных для создания ФИО сотрудников -----------

    private final static Random RANDOM = new Random();
    private final static String[] FIRST_NAME = {"Алексеев", "Сергеев", "Михайлов", "Романов", "Быков", "Дмитриев",
            "Борисов"};
    private final static String[] LAST_NAME = {"Александр", "Дмитрий", "Михаил", "Иван", "Сергей", "Роман",
            "Олег"};
    private final static String[] SOUR_NAME = {"Васильевич", "Иванович", "Романович", "Дмитриевич", "Михайлович"
            , "Сергеевич", "Олегович"};

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

//      -------- Метод индексации ЗП --------

    private static void index(int ind) {
        for (Employee emp : EMPLOYEES) {
            // System.out.println(emp);
            float sal = (emp.getSalary() * (1 + (float) ind / 100));
            //System.out.println(sal);
            emp.setSalary((int) sal);
            System.out.println(emp);

        }
    }

//      ------- Метод поиска сотрудника с мин ЗП --------

    private static Employee findMinSalaryInDepart(int num) {
        Employee employeeWithMin = null;
        for (Employee emp : EMPLOYEES) {
            if ((employeeWithMin == null || emp.getSalary() < employeeWithMin.getSalary()) & (emp.getDepartment() == num)) {
                employeeWithMin = emp;
            }
        }
        return employeeWithMin;
    }

//      ------- Метод поиска сотрудника с мин ЗП --------

    private static Employee findMaxSalaryInDepart(int num) {
        Employee employeeWithMax = null;
        for (Employee emp : EMPLOYEES) {
            if ((employeeWithMax == null || emp.getSalary() > employeeWithMax.getSalary()) & (emp.getDepartment() == num)) {
                employeeWithMax = emp;
            }
        }
        return employeeWithMax;
    }

//      ------- Метод поиска суммы затрат на ЗП по отделу --------

    private static int summSalaryInDepart(int num) {
        int summ = 0;
        for (Employee emp : EMPLOYEES) {
            if (emp.getDepartment() == num) {
                summ += emp.getSalary();
            }
        }
        return summ;
    }


//    ----------- Метод средней ЗП по отделу ------------

    private static float averageSalaryInDepart(int num, int summSalaryInDepart) {
        int i = 0;
        for (Employee emp : EMPLOYEES) {
            if (emp.getDepartment() == num) i += 1;
        }
        return (float) summSalaryInDepart / i;
    }

    //   ----------- Метод для печати данных по отделу -----------

    private static void printDepart(int depart) {
        for (Employee emp : EMPLOYEES) {
            if (emp.getDepartment() == depart) {
                System.out.println("ID - " + emp.getId() + ". Сотрудник: " + emp.getFullName() + ", Зарплата " + emp.getSalary() + " рублей.");
            }
        }
    }

//      -------- Метод индексации ЗП по отделу--------

    private static void indexInDepart(int ind, int depart) {
        for (Employee emp : EMPLOYEES) {
            if (emp.getDepartment() == depart) {
                float sal = (emp.getSalary() * (1 + (float) ind / 100));
                emp.setSalary((int) sal);
                System.out.println(emp);
            }
        }
    }


//      -------- Метод поиска и печати сотрудников с зп меньше числа по отделу--------

    private static void salaryLessNum(int num, int depart) {
        System.out.println("Все сотрудники с ЗП меньше - " + num);
        for (Employee emp : EMPLOYEES) {
            if (emp.getDepartment() == depart & emp.getSalary() < num) {
                System.out.println("ID - " + emp.getId() + " " + emp.getFullName() + ". ЗП - " + emp.getSalary() + " " +
                        "рублей.");
            }
        }
    }


//      -------- Метод поиска и печати сотрудников с зп больше или равного числу по отделу--------

    private static void salaryMoreNum(int num, int depart) {
        System.out.println("Все сотрудники с ЗП больше или равной - " + num);
        for (Employee emp : EMPLOYEES) {
            if (emp.getDepartment() == depart & emp.getSalary() >= num) {
                System.out.println("ID - " + emp.getId() + " " + emp.getFullName() + ". ЗП - " + emp.getSalary() + " " +
                        "рублей.");
            }
        }
    }

    public static void main(String[] args) {

        initFullName();

        printAll();

        Scanner inNum = new Scanner(System.in);         //  Инициализируем сканер

        System.out.print("\nВведите % для индексации ЗП (от 1 до 100) : ");
        int ind = inNum.nextInt();         //  Ввод числа для индексации
        System.out.println("\nЗарплата сотрудников после индексации :");
        index(ind);
        System.out.print("\nВведите № отдела (от 1 до 5) : ");
        int depart = inNum.nextInt();         //  Ввод № отдела
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

        int num = inNum.nextInt();         //  Ввод пограничной ЗП

        salaryLessNum(num, depart);

        salaryMoreNum(num, depart);


    }

}
