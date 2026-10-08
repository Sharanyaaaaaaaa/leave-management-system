import java.util.ArrayList;
import java.util.List;

/**
 * Demo of the Leave Management System.
 * Exceptions are caught here, so the user sees a clear message instead of a crash.
 */
public class LeaveApp {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new FullTimeEmployee(101, "Anita Sharma", "IT"));
        employees.add(new PartTimeEmployee(102, "Rahul Verma", "Marketing", 20));
        employees.add(new Intern(103, "Meera Nair", "HR", 3));
        employees.add(new Manager(104, "Karan Rao", "Operations", 8));

        Employee anita = employees.get(0);
        Employee rahul = employees.get(1);
        Employee meera = employees.get(2);
        Employee karan = employees.get(3);

        heading("1. Employee details (polymorphism)");
        for (Employee employee : employees) {
            employee.displayDetails();     // same call, different output for each type
            System.out.println();
        }

        heading("2. Applying for leave");
        apply(anita, 5, "Family function");
        apply(anita, 18, "Long vacation");     // above the full-time limit of 15
        apply(rahul, 5, "Exams");
        apply(rahul, 3, "Medical check-up");
        apply(rahul, 5, "Trip");               // within limit but balance is only 4
        apply(meera, 3, "Trip");               // above the intern limit of 2
        apply(meera, 0, "Test");               // invalid number of days
        apply(meera, 2, "College event");
        apply(karan, 18, "Annual vacation");   // allowed only because Karan is a Manager

        heading("3. Overloaded method (no reason given)");
        try {
            LeaveRequest request = anita.applyLeave(2);
            System.out.println("OK: " + anita.getEmployeeName() + " - " + request);
        } catch (LeaveException e) {
            System.out.println("Rejected: " + e.getMessage());
        }

        heading("4. Cancelling leave");
        cancel(anita, 1);     // valid
        cancel(anita, 1);     // already cancelled
        cancel(anita, 99);    // does not exist

        heading("5. Leave balances");
        for (Employee employee : employees) {
            System.out.println(employee.getEmployeeName() + " (" + employee.getEmployeeType() + "): "
                    + employee.checkLeaveBalance() + " day(s) left");
        }

        heading("6. Leave history");
        anita.displayLeaveHistory();
        karan.displayLeaveHistory();

        heading("7. Invalid employee data");
        try {
            new Intern(105, "", "HR", 3);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }

    private static void apply(Employee employee, int days, String reason) {
        try {
            LeaveRequest request = employee.applyLeave(days, reason);
            System.out.println("OK: " + employee.getEmployeeName() + " - " + request
                    + " (balance now " + employee.checkLeaveBalance() + ")");
        } catch (LeaveException e) {
            System.out.println("Rejected: " + employee.getEmployeeName() + " - " + e.getMessage());
        }
    }

    private static void cancel(Employee employee, int requestId) {
        try {
            employee.cancelLeave(requestId);
            System.out.println("OK: " + employee.getEmployeeName() + " cancelled request #" + requestId
                    + " (balance now " + employee.checkLeaveBalance() + ")");
        } catch (LeaveException e) {
            System.out.println("Rejected: " + employee.getEmployeeName() + " - " + e.getMessage());
        }
    }

    private static void heading(String text) {
        System.out.println("\n=== " + text + " ===");
    }
}
