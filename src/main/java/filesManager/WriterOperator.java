package filesManager;

import managers.InMemoryDates;
import managers.OperationsManager;

import java.time.LocalDate;
import java.util.LinkedList;

public class WriterOperator {

    public void writeSkedByFirstDate(OperationsManager pattern, boolean isByFirst, LocalDate... dates) {
        LinkedList<LinkedList<LocalDate>> thisDates;
        String fileContent;

        if (isByFirst) {
            thisDates = calculateDatesByFirst(pattern, dates);
        } else thisDates = calculateDatesByLast(pattern, dates);

        fileContent = createFileContent(pattern, thisDates);
    }

    private String createFileContent(OperationsManager pattern, LinkedList<LinkedList<LocalDate>> thisDates) {
        String fileContent = pattern.getPatternsName() + "\n";

        for (int i = 0; i < pattern.getOperationsPattern().size(); i++) {
            fileContent += pattern.getOperationsPattern().get(i).getName() + ",";

            for (LinkedList<LocalDate> thisDate : thisDates) {
                fileContent += thisDate.get(i) + ",";
            }
            fileContent += "\n";
        }

        return fileContent;
    }

    private LinkedList<LinkedList<LocalDate>> calculateDatesByFirst(OperationsManager pattern, LocalDate... dates) {
        LinkedList<LinkedList<LocalDate>> thisDates = new LinkedList<>();

        for (LocalDate date : dates)
            thisDates.addLast(new InMemoryDates().addDatesByFirst(date, pattern.getOperationsPattern()));

        return thisDates;
    }

    private LinkedList<LinkedList<LocalDate>> calculateDatesByLast(OperationsManager pattern, LocalDate... dates) {
        LinkedList<LinkedList<LocalDate>> thisDates = new LinkedList<>();

        for (LocalDate date : dates)
            thisDates.addLast(new InMemoryDates().addDatesByLast(date, pattern.getOperationsPattern()));

        return thisDates;
    }
}
