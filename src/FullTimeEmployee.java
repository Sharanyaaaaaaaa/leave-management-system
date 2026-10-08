/** Full-time employee: 24 days a year, up to 15 days in one request. */
public class FullTimeEmployee extends Employee {
    private static final int ANNUAL_ENTITLEMENT = 24;
    private static final int MAX_DAYS_PER_REQUEST = 15;

    public FullTimeEmployee(int employeeId, String employeeName, String department) {
        this(employeeId, employeeName, department, ANNUAL_ENTITLEMENT);
    }

    // used by subclasses (such as Manager) that need a different entitlement
    protected FullTimeEmployee(int employeeId, String employeeName, String department, int entitlement) {
        super(employeeId, employeeName, department, entitlement);
    }

    @Override
    public String getEmployeeType() {
        return "Full-time";
    }

    @Override
    protected int getMaxDaysPerRequest() {
        return MAX_DAYS_PER_REQUEST;
    }
}
