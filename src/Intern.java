public class Intern extends Employee {
    private int durationMonths;

    public Intern(int empId, String empName, String dept, int durationMonths) {
        super(empId, empName, dept, 6);
        this.durationMonths = durationMonths;
    }

    @Override
    public boolean applyLeave(int days) {
        if (days <= 0) {
            System.out.println("Invalid days");
            return false;
        }
        if (days > 2) {
            System.out.println("Interns can take at most 2 days at once");
            return false;
        }
        return super.applyLeave(days);
    }
}
