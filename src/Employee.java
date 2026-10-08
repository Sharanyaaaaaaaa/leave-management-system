public abstract class Employee {
    private int empId;
    private String empName;
    private String dept;
    private int bal;

    public Employee(int empId, String empName, String dept, int bal) {
        this.empId = empId;
        this.empName = empName;
        this.dept = dept;
        this.bal = bal;
    }

    public int getEmpId() { return empId; }
    public String getEmpName() { return empName; }
    public String getDept() { return dept; }
    public int getBal() { return bal; }

    public abstract String getEmployeeType();

    // overloaded version: same name, different parameters
    public boolean applyLeave(int days, String reason) {
        System.out.println("Reason: " + reason);
        return applyLeave(days);
    }

    public boolean applyLeave(int days) {
        if (days <= 0) {
            System.out.println("Invalid days");
            return false;
        }
        if (days > bal) {
            System.out.println("Not enough leave balance");
            return false;
        }
        bal = bal - days;
        System.out.println(empName + " applied for " + days + " days");
        return true;
    }

    public void cancelLeave(int days) {
        bal = bal + days;
        System.out.println(empName + " cancelled " + days + " days");
    }

    protected void addBonusLeave(int days) {
        bal = bal + days;
    }

    protected void deductLeave(int days) {
        bal = bal - days;
    }

    public int checkLeaveBalance() {
        return bal;
    }

    public void displayDetails() {
        System.out.println("ID: " + empId + ", Name: " + empName + ", Dept: " + dept + ", Type: " + getEmployeeType() + ", Leave balance: " + bal);
    }
}
