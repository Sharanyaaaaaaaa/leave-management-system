# Design Notes (written before coding)

## Main objects
- **Employee**: a person working in the company.
- **Leave request**: a request for a number of days off.

## Data (attributes)
Employee ID, Employee name, Department, Leave balance.

## Behaviours (methods)
applyLeave(), cancelLeave(), checkLeaveBalance(), displayDetails().

## Classes and relationships
Employee is the parent class. FullTimeEmployee, PartTimeEmployee and Intern
inherit from Employee because each has the same data but different leave rules.

| Employee type | Annual leave | Max days in one request |
|---------------|--------------|-------------------------|
| Full-time     | 24           | 15                      |
| Part-time     | 12           | 5                       |
| Intern        | 6            | 2                       |

See `class-diagram-initial.png` for the first class diagram.
