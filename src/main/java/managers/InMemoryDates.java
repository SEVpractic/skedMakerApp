package managers;

import operation.Operation;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.LinkedList;

import static java.lang.Math.ceil;

public class InMemoryDates implements DatesManager {
    private final LinkedList<LocalDate> dates;

    public InMemoryDates() {
        this.dates = new LinkedList<>();
    }

    @Override
    public LinkedList<LocalDate> addDatesByFirst(LocalDate date, LinkedList<Operation> operations) {
        double productionTime = 0;
        int daysCounter;

        for (Operation operation : operations) {
            productionTime += operation.getProductionTime();
            daysCounter = (int) ceil((productionTime / 8));

            if (!operation.isSaturdayAvailable()
                    && date.plusDays(daysCounter).getDayOfWeek() == DayOfWeek.SATURDAY) {
                productionTime += 1;
                daysCounter += 1;
            }
            if (!operation.isSundayAvailable()
                    && date.plusDays(daysCounter).getDayOfWeek() == DayOfWeek.SUNDAY) {
                productionTime +=1;
                daysCounter += 1;
            }

            dates.addLast(date.plusDays(daysCounter));
        }
        return dates;
    }

    @Override
    public LinkedList<LocalDate> addDatesByLast(LocalDate date, LinkedList<Operation> operations) {
        double productionTime = 0;
        int daysCounter = 0;

        for (int i = operations.size() - 1; i >= 0; i--) {
            dates.addFirst(date.minusDays(daysCounter));

            productionTime += operations.get(i).getProductionTime();
            daysCounter = (int) ceil((productionTime / 8));

            if (!operations.get(i).isSaturdayAvailable()
                    && date.minusDays(daysCounter).getDayOfWeek() == DayOfWeek.SUNDAY) {
                productionTime += 1;
                daysCounter += 1;
            }
            if (!operations.get(i).isSundayAvailable()
                    && date.minusDays(daysCounter).getDayOfWeek() == DayOfWeek.SATURDAY) {
                productionTime += 1;
                daysCounter += 1;
            }
        }
        return dates;
    }
}
