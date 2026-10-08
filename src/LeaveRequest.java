/**
 * One leave request made by an employee.
 * Keeping this as its own class lets us cancel exactly what was applied.
 */
public class LeaveRequest {
    private final int requestId;
    private final int days;
    private final String reason;
    private LeaveStatus status;

    public LeaveRequest(int requestId, int days, String reason) {
        this.requestId = requestId;
        this.days = days;
        this.reason = reason;
        this.status = LeaveStatus.APPLIED;
    }

    public int getRequestId() { return requestId; }
    public int getDays() { return days; }
    public String getReason() { return reason; }
    public LeaveStatus getStatus() { return status; }
    public boolean isCancelled() { return status == LeaveStatus.CANCELLED; }

    void cancel() {                    // package-private: only Employee should cancel
        status = LeaveStatus.CANCELLED;
    }

    @Override
    public String toString() {
        return "Request #" + requestId + " | " + days + " day(s) | " + reason + " | " + status;
    }
}
