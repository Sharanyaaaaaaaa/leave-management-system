public class LeaveApp {
    public static void main(String[] args) {
        FullTimeEmployee e1 = new FullTimeEmployee(101, "Anita Sharma", "IT");
        PartTimeEmployee e2 = new PartTimeEmployee(102, "Rahul Verma", "Marketing", 20);
        Intern e3 = new Intern(103, "Meera Nair", "HR", 3);
        e1.displayDetails();
        e2.displayDetails();
        e3.displayDetails();

        e1.applyLeave(5);
        e1.applyLeave(18);
        e2.applyLeave(6);
        e3.applyLeave(3);
        e3.applyLeave(2);
    }
}
