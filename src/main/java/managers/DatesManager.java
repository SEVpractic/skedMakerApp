package managers;

import operation.Operation;

import java.time.LocalDate;
import java.util.LinkedList;

public interface DatesManager {

    public LinkedList<LocalDate> addDatesByFirst(LocalDate date, LinkedList<Operation> operations);

    public LinkedList<LocalDate> addDatesByLast(LocalDate date, LinkedList<Operation> operations);
}
