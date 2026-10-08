# Explanation of OOP Concepts Used

## 1. Encapsulation
Data is hidden inside the class and can only be changed through methods.
In `Employee`, the fields `employeeId`, `employeeName`, `department`, `annualEntitlement`
and `leaveBalance` are all `private`. The balance is never set directly from outside.
It changes only through `applyLeave()` and `cancelLeave()`, which check the rules first.
Most fields are also `final`, so they cannot change after the object is created.
Because of this, nobody can set an invalid balance such as -5 or 100.

## 2. Inheritance
`FullTimeEmployee`, `PartTimeEmployee` and `Intern` extend `Employee`, so they reuse its
data and leave logic and only add what is different (for example `hoursPerWeek` for part-time).
`Manager` extends `FullTimeEmployee`, which is a multi-level hierarchy:
`Employee -> FullTimeEmployee -> Manager`. A manager is a full-time employee with extra benefits.

## 3. Abstraction
`Employee` is an `abstract` class, so a plain "Employee" can never be created. It declares two
abstract methods, `getEmployeeType()` and `getMaxDaysPerRequest()`, which every subclass must
implement. The rest of the program only needs to know that an employee has a type and a limit,
not how each type decides it.

## 4. Method overriding (runtime)
Subclasses replace parent methods with their own version using `@Override`:
- `getEmployeeType()` returns "Full-time", "Part-time", "Intern" or "Manager"
- `getMaxDaysPerRequest()` returns 15, 5, 2 or 20
- `displayDetails()` in `PartTimeEmployee`, `Intern` and `Manager` calls `super.displayDetails()`
  and then prints the extra information for that type

## 5. Method overloading (compile time)
`applyLeave(int days)` and `applyLeave(int days, String reason)` share a name but have different
parameters. The first one simply calls the second with the reason "Not specified".

## 6. Polymorphism
In `LeaveApp`, all employees are stored in one `List<Employee>`. A loop calls
`employee.displayDetails()` on each one, and Java chooses the correct version at run time.
The leave validation shows it too. `Employee.applyLeave()` calls `getMaxDaysPerRequest()`,
and each object answers with its own limit. The same request of 18 days is rejected for a
full-time employee (limit 15) but accepted for a manager (limit 20), with no `if` on the type.

## 7. Access modifiers
| Modifier | Where it is used | Why |
|----------|------------------|-----|
| `private` | fields of every class, `validateRequest()`, `findRequest()` | Hidden from everything outside the class |
| `protected` | `getMaxDaysPerRequest()`, the second `FullTimeEmployee` constructor | Visible to subclasses only |
| package-private | `LeaveRequest.cancel()` | Only classes in the same package (Employee) can cancel a request |
| `public` | `applyLeave()`, `cancelLeave()`, `checkLeaveBalance()`, `displayDetails()`, getters | The public interface of the class |

## 8. Change request: adding Manager
The new requirement was a Manager type with extra leave. Because of the design, only one new
class was needed. `Manager` extends `FullTimeEmployee`, passes a bigger entitlement (24 + 6)
to the parent constructor, and overrides `getMaxDaysPerRequest()` to return 20. No existing
class had to be changed in the final design, and `LeaveApp` handles it through the same
`Employee` list.
