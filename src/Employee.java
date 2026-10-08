import java.util.ArrayList;
import java.util.List;

/**
 * Abstract base class for every kind of employee.
 * It holds the data and the common leave logic. Subclasses only supply
 * their own rules (maximum days per request and employee type).
 */
public abstract class Employee {
    private final int employeeId;
    private final String employeeName;
    private final String department;
    private final int annualEntitlement;
    private int leaveBalance;
    private final List<LeaveRequest> leaveHistory = new ArrayList<>();
    private int nextRequestId = 1;

    protected Employee(int employeeId, String employeeName, String department, int annualEntitlement) {
        if (employeeName == null || employeeName.isBlank()) {
            throw new IllegalArgumentException("Employee name cannot be empty.");
        }
        if (department == null || department.isBlank()) {
            throw new IllegalArgumentException("Department cannot be empty.");
        }
        if (annualEntitlement < 0) {
            throw new IllegalArgumentException("Annual leave entitlement cannot be negative.");
        }
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.department = department;
        this.annualEntitlement = annualEntitlement;
        this.leaveBalance = annualEntitlement;
    }

    // ----- abstract methods: every subclass must define these -----
    public abstract String getEmployeeType();

    protected abstract int getMaxDaysPerRequest();

    // ----- getters (read-only access: encapsulation) -----
    public int getEmployeeId() { return employeeId; }
    public String getEmployeeName() { return employeeName; }
    public String getDepartment() { return department; }
    public int getAnnualEntitlement() { return annualEntitlement; }

    // ----- leave operations -----
    public LeaveRequest applyLeave(int days) {                 // overloaded: no reason given
        return applyLeave(days, "Not specified");
    }

    public LeaveRequest applyLeave(int days, String reason) {  // overloaded: with reason
        validateRequest(days);                                 // same rules for everyone, limits differ
        leaveBalance -= days;
        LeaveRequest request = new LeaveRequest(nextRequestId++, days, reason == null ? "Not specified" : reason);
        leaveHistory.add(request);
        return request;
    }

    public void cancelLeave(int requestId) {
        LeaveRequest request = findRequest(requestId);
        if (request.isCancelled()) {
            throw new InvalidLeaveRequestException("Leave request #" + requestId + " is already cancelled.");
        }
        request.cancel();
        leaveBalance += request.getDays();
    }

    public int checkLeaveBalance() {
        return leaveBalance;
    }

    // ----- display -----
    public void displayDetails() {
        System.out.println("ID: " + employeeId + " | Name: " + employeeName + " | Dept: " + department);
        System.out.println("Type: " + getEmployeeType() + " | Annual leave: " + annualEntitlement
                + " | Balance: " + leaveBalance + " | Max per request: " + getMaxDaysPerRequest());
    }

    public void displayLeaveHistory() {
        System.out.println("Leave history for " + employeeName + ":");
        if (leaveHistory.isEmpty()) {
            System.out.println("  (no requests)");
        }
        for (LeaveRequest request : leaveHistory) {
            System.out.println("  " + request);
        }
    }

    // ----- helpers -----
    private void validateRequest(int days) {
        if (days <= 0) {
            throw new InvalidLeaveRequestException("Number of days must be greater than zero.");
        }
        if (days > getMaxDaysPerRequest()) {
            throw new InvalidLeaveRequestException(getEmployeeType() + " employees can take at most "
                    + getMaxDaysPerRequest() + " days in one request.");
        }
        if (days > leaveBalance) {
            throw new InsufficientLeaveBalanceException(days, leaveBalance);
        }
    }

    private LeaveRequest findRequest(int requestId) {
        for (LeaveRequest request : leaveHistory) {
            if (request.getRequestId() == requestId) {
                return request;
            }
        }
        throw new LeaveNotFoundException(requestId);
    }
}
