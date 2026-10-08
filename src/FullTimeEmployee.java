public class FullTimeEmployee extends Employee {
    public FullTimeEmployee(int empId, String empName, String dept) {
        super(empId, empName, dept, 24);
    }

    @Override
    public boolean applyLeave(int days) {
        if (days <= 0) {
            System.out.println("Invalid days");
            return false;
        }
        if (days > 15) {
            System.out.println("Full-time employees can take at most 15 days at once");
            return false;
        }
        return super.applyLeave(days);
    }

    @Override
    public String getEmployeeType() {
        return "Full-time";
    }
}
