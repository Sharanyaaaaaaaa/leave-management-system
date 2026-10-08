/** Intern: 6 days a year, up to 2 days in one request. */
public class Intern extends Employee {
    private static final int ANNUAL_ENTITLEMENT = 6;
    private static final int MAX_DAYS_PER_REQUEST = 2;

    private final int durationMonths;

    public Intern(int employeeId, String employeeName, String department, int durationMonths) {
        super(employeeId, employeeName, department, ANNUAL_ENTITLEMENT);
        if (durationMonths <= 0) {
            throw new IllegalArgumentException("Internship duration must be greater than zero.");
        }
        this.durationMonths = durationMonths;
    }

    @Override
    public String getEmployeeType() {
        return "Intern";
    }

    @Override
    protected int getMaxDaysPerRequest() {
        return MAX_DAYS_PER_REQUEST;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Internship duration (months): " + durationMonths);
    }
}
