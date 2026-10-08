/** Thrown when an employee asks for more days than their remaining balance. */
public class InsufficientLeaveBalanceException extends LeaveException {
    public InsufficientLeaveBalanceException(int requested, int available) {
        super("Not enough leave balance. Requested " + requested + " day(s), available " + available + ".");
    }
}
