package managers;

import operation.Operation;

import java.util.LinkedList;

public class InMemoryPattern implements OperationsManager {
    private final String processName;
    private final LinkedList<Operation> operations;

    public InMemoryPattern(String processName) {
        this.processName = processName;
        operations = new LinkedList<>();

        Operation opNull = new Operation("Поступление заготовок / входящих", 0,
                false, true, true);
        operations.addFirst(opNull);
    }

    @Override
    public void addOperation(Operation operation) {
        operations.addLast(operation);
    }

    @Override
    public void addOperation(int index, Operation operation) {
        operations.add(index, operation);
    }

    @Override
    public void setOperation(int index, Operation operation) {
        operations.set(index, operation);
    }

    @Override
    public void deliteOperationByIndex(int index) {
        if (index < operations.size()) operations.remove(index);
    }

    @Override
    public void clinePattern() {
        operations.clear();
    }

    @Override
    public LinkedList<Operation> getOperationsPattern() {
        return operations;
    }

    @Override
    public String getPatternsName() {
        return processName;
    }
}
