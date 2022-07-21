package operation;

public class Operation {
    private final String name; // наименование операции
    private final double productionTime; // количество часов
    private final boolean isSecondShiftAvailable; // доступность работы во вторую смену
    private final boolean isSaturdayAvailable; // доступность работы в субботу
    private final boolean isSundayAvailable; // доступность работы в воскресенье

    public Operation(String name, double productionTime, boolean isSecondShiftAvailable,
                     boolean isSaturdayAvailable, boolean isSundayAvailable) {
        this.name = name;
        this.productionTime = productionTime;
        this.isSecondShiftAvailable = isSecondShiftAvailable;
        this.isSaturdayAvailable = isSaturdayAvailable;
        this.isSundayAvailable = isSundayAvailable;
    }

    public String getName() {
        return name;
    }

    public double getProductionTime() {
        return productionTime;
    }

    public boolean isSecondShiftAvailable() {
        return isSecondShiftAvailable;
    }

    public boolean isSaturdayAvailable() {
        return isSaturdayAvailable;
    }

    public boolean isSundayAvailable() {
        return isSundayAvailable;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "name='" + name + '\'' +
                ", productionTime=" + productionTime +
                '}';
    }
}
