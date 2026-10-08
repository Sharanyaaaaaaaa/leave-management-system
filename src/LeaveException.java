/**
 * Base class for all leave-related errors.
 * It is unchecked (RuntimeException) so normal code stays uncluttered.
 */
public class LeaveException extends RuntimeException {
    public LeaveException(String message) {
        super(message);
    }
}
