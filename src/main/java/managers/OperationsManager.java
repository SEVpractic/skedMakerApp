package managers;

import operation.Operation;

import java.util.LinkedList;

public interface OperationsManager {

    public void addOperation(Operation operation); // Добавляет операцию в конец списка

    public void addOperation(int index, Operation operation); // добавляет операцию по индексу

    public void setOperation(int index, Operation operation); // заменяет операцию по индексу на новую

    public void deliteOperationByIndex(int index); // удаляет операцию по индексу

    public void clinePattern(); // удаляет все операции

    public LinkedList<Operation> getOperationsPattern(); // возвращает объект линк.лист с перечнем операций

    public String getPatternsName(); // возвращает наименование процесса
}
