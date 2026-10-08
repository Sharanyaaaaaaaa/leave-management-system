/** Thrown when a leave request ID does not exist for the employee. */
public class LeaveNotFoundException extends LeaveException {
    public LeaveNotFoundException(int requestId) {
        super("Leave request #" + requestId + " not found.");
    }
}
