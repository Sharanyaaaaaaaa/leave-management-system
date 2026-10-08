/** Thrown when a leave request breaks a rule (zero days, over the limit, already cancelled). */
public class InvalidLeaveRequestException extends LeaveException {
    public InvalidLeaveRequestException(String message) {
        super(message);
    }
}
