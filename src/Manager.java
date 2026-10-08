/**
 * Manager: a full-time employee with extra leave benefits.
 * 6 bonus days (30 in total) and up to 20 days in one request.
 * Everything else is reused from FullTimeEmployee and Employee.
 */
public class Manager extends FullTimeEmployee {
    private static final int BONUS_LEAVE = 6;
    private static final int MAX_DAYS_PER_REQUEST = 20;
    private static final int FULL_TIME_ENTITLEMENT = 24;

    private final int teamSize;

    public Manager(int employeeId, String employeeName, String department, int teamSize) {
        super(employeeId, employeeName, department, FULL_TIME_ENTITLEMENT + BONUS_LEAVE);
        if (teamSize < 0) {
            throw new IllegalArgumentException("Team size cannot be negative.");
        }
        this.teamSize = teamSize;
    }

    @Override
    public String getEmployeeType() {
        return "Manager";
    }

    @Override
    protected int getMaxDaysPerRequest() {
        return MAX_DAYS_PER_REQUEST;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Team size: " + teamSize + " | Extra leave benefit: +" + BONUS_LEAVE + " days");
    }
}
