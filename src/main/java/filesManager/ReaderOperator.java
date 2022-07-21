package filesManager;

import managers.InMemoryPattern;
import managers.OperationsManager;
import operation.Operation;

import java.io.IOException;
import java.nio.file.Path;

import static java.nio.file.Files.readString;

public class ReaderOperator {

    public OperationsManager createPatternFromFile(String path, String patternsName) {
        OperationsManager operationsManager = new InMemoryPattern(patternsName);
        String fileContent = readeCSVContentOrNull(path);

        if (fileContent == null) return null;
        return createOperations(operationsManager, fileContent);
    }

    private String readeCSVContentOrNull(String path) {
        try {
            return readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с шаблоном. " +
                    "Возможно, файл не находится в нужной директории.\n");
            return null;
        }
    }

    private OperationsManager createOperations(OperationsManager operationsManager, String fileContent) {
        String[] lines = fileContent.split(System.lineSeparator());

        for (String line : lines) {
            String[] lineValues = line.split(",");

            String name = lineValues[0];
            double productionTime = Double.valueOf(lineValues[1].trim());
            boolean isSecondShiftAvailable = Boolean.valueOf(lineValues[2].trim());
            boolean isSaturdayAvailable = Boolean.valueOf(lineValues[3].trim());
            boolean isSundayAvailable = Boolean.valueOf(lineValues[4].trim());

            Operation operation = new Operation(name, productionTime, isSecondShiftAvailable,
                    isSaturdayAvailable, isSundayAvailable);
            operationsManager.addOperation(operation);
        }

        return operationsManager;
    }
}
