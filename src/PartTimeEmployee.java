public class PartTimeEmployee extends Employee {
    private int hoursPerWeek;

    public PartTimeEmployee(int empId, String empName, String dept, int hoursPerWeek) {
        super(empId, empName, dept, 12);
        this.hoursPerWeek = hoursPerWeek;
    }

    @Override
    public boolean applyLeave(int days) {
        if (days <= 0) {
            System.out.println("Invalid days");
            return false;
        }
        if (days > 5) {
            System.out.println("Part-time employees can take at most 5 days at once");
            return false;
        }
        return super.applyLeave(days);
    }

    @Override
    public String getEmployeeType() {
        return "Part-time";
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Hours per week: " + hoursPerWeek);
    }
}
