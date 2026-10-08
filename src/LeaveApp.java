import java.util.ArrayList;
import java.util.List;

public class LeaveApp {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new FullTimeEmployee(101, "Anita Sharma", "IT"));
        list.add(new PartTimeEmployee(102, "Rahul Verma", "Marketing", 20));
        list.add(new Intern(103, "Meera Nair", "HR", 3));

        // polymorphism: same call, different behaviour for each type
        for (Employee e : list) {
            e.displayDetails();
            e.applyLeave(3);
        }
        list.get(0).applyLeave(2, "Family function");
    }
}
