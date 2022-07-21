import filesManager.ReaderOperator;
import filesManager.WriterOperator;
import managers.OperationsManager;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        OperationsManager operationsManager = new ReaderOperator().createPatternFromFile("resources/pattern1.csv",
                "Изделие №3"); // считали паттерн из файла

        new WriterOperator().writeSkedByFirstDate(operationsManager, true, LocalDate.of(2022, 07, 15),
                LocalDate.of(2022, 07, 15)); // записали заполненную сетку в файл


        /*OperationsManager operationsManager = new InMemoryPattern("Изделие №3");

        Operation op1 = new Operation("Комлпектация", 4, false,
                false, false);
        operationsManager.addOperation(op1);

        Operation op2 = new Operation("Токарная", 36, false,
                false, false);
        operationsManager.addOperation(op2);

        Operation op3 = new Operation("Слесарная", 4, false,
                false, false);
        operationsManager.addOperation(op3);

        Operation op4 = new Operation("Слесарная", 4, false,
                false, false);
        operationsManager.addOperation(2, op4);

        Operation op5 = new Operation("Контроль", 8, false,
                false, false);
        operationsManager.addOperation(op5);

        //TimeManager.setDateByFirst(LocalDate.of(2022, 07, 15), operationsManager.getOperationsPattern());
        System.out.println(operationsManager.getPatternsName());
        System.out.println(operationsManager.getOperationsPattern().toString());
        System.out.println("");

        //TimeManager.setDateByLast(LocalDate.of(2022, 07, 25), operationsManager.getOperationsPattern());
        System.out.println(operationsManager.getPatternsName());
        System.out.println(operationsManager.getOperationsPattern().toString());*/
    }
}
