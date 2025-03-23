import Difficult.EmployeeBook;

public class Main {

    public static void main(String[] args) {

        System.out.println("------- Курсовая 1 курс --------- \n -=-=-=-= Базовая сложность =-=-=-=-");
        Base.mainBase.main(args);

        System.out.println("\n------- Курсовая 1 курс --------- \n -=-=-=-= Повышенная сложность =-=-=-=-\n");
        Midle.mainMidle.main(args);

        System.out.println("\n------- Курсовая 1 курс --------- \n -=-=-=-= Максимальная сложность =-=-=-=-\n");

        EmployeeBook book = new EmployeeBook();
        book.main();

    }
}