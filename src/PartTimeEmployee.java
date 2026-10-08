/** Part-time employee: 12 days a year, up to 5 days in one request. */
public class PartTimeEmployee extends Employee {
    private static final int ANNUAL_ENTITLEMENT = 12;
    private static final int MAX_DAYS_PER_REQUEST = 5;

    private final int hoursPerWeek;

    public PartTimeEmployee(int employeeId, String employeeName, String department, int hoursPerWeek) {
        super(employeeId, employeeName, department, ANNUAL_ENTITLEMENT);
        if (hoursPerWeek <= 0) {
            throw new IllegalArgumentException("Hours per week must be greater than zero.");
        }
        this.hoursPerWeek = hoursPerWeek;
    }

    @Override
    public String getEmployeeType() {
        return "Part-time";
    }

    @Override
    protected int getMaxDaysPerRequest() {
        return MAX_DAYS_PER_REQUEST;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Hours per week: " + hoursPerWeek);
    }
}
