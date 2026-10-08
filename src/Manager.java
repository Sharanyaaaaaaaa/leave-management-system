public class Manager extends FullTimeEmployee {
    private int teamSize;

    public Manager(int empId, String empName, String dept, int teamSize) {
        super(empId, empName, dept);
        this.teamSize = teamSize;
        addBonusLeave(6);          // managers get 6 extra days
    }

    @Override
    public boolean applyLeave(int days) {
        if (days <= 0) {
            System.out.println("Invalid days");
            return false;
        }
        if (days > 20) {
            System.out.println("Managers can take at most 20 days at once");
            return false;
        }
        if (days > checkLeaveBalance()) {
            System.out.println("Not enough leave balance");
            return false;
        }
        deductLeave(days);
        System.out.println(getEmpName() + " applied for " + days + " days");
        return true;
    }

    @Override
    public String getEmployeeType() {
        return "Manager";
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Team size: " + teamSize);
    }
}
