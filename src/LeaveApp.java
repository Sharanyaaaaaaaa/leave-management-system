public class LeaveApp {
    public static void main(String[] args) {
        Employee e1 = new Employee(101, "Anita Sharma", "IT", 24);
        Employee e2 = new Employee(102, "Rahul Verma", "Marketing", 12);
        Employee e3 = new Employee(103, "Meera Nair", "HR", 6);
        e1.displayDetails();
        e2.displayDetails();
        e3.displayDetails();
    }
}
