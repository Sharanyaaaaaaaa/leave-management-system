# Leave Management System (Java, OOP)

A simple console application that manages employee leave. It starts as a basic
`Employee` class and is built up step by step using Object-Oriented Programming:
inheritance, polymorphism, abstraction, a change request (Manager) and a refactoring pass.

**Author:** Sharanya S Devadiga

## Features
- Store employee details (ID, name, department, leave balance)
- Apply for leave (with or without a reason) and cancel a leave request
- Check leave balance, view details and leave history
- Different leave rules for each employee type
- Clear error messages through custom exceptions

## Leave rules

| Employee type | Annual leave | Max days in one request |
|---------------|--------------|-------------------------|
| Full-time     | 24           | 15                      |
| Part-time     | 12           | 5                       |
| Intern        | 6            | 2                       |
| Manager       | 30 (24 + 6 bonus) | 20                 |

## How to run
Requires Java 17 or later.

```bash
javac -d out src/*.java
java -cp out LeaveApp
```

## Project structure
```
leave-management-system/
├── src/
│   ├── Employee.java                      (abstract base class)
│   ├── FullTimeEmployee.java
│   ├── PartTimeEmployee.java
│   ├── Intern.java
│   ├── Manager.java                       (extends FullTimeEmployee)
│   ├── LeaveRequest.java
│   ├── LeaveStatus.java                   (enum)
│   ├── LeaveException.java                (base exception)
│   ├── InvalidLeaveRequestException.java
│   ├── InsufficientLeaveBalanceException.java
│   ├── LeaveNotFoundException.java
│   └── LeaveApp.java                      (demo / main)
├── docs/
│   ├── class-diagram-initial.png          (design before coding)
│   ├── class-diagram-final.png
│   ├── design-notes.md
│   ├── OOP_Concepts.md
│   ├── Refactoring_Notes.md
│   ├── sample_output.txt
│   └── screenshots/
└── README.md
```

## OOP concepts at a glance
Encapsulation, Inheritance, Polymorphism, Abstraction, Method overriding,
Method overloading and Access modifiers are all used. See
[docs/OOP_Concepts.md](docs/OOP_Concepts.md) for where and why.

## Documents
- Class diagrams: `docs/class-diagram-initial.png`, `docs/class-diagram-final.png`
- Explanation of OOP concepts: `docs/OOP_Concepts.md`
- Refactoring notes: `docs/Refactoring_Notes.md`
- Sample output: `docs/sample_output.txt`

## Git history
1. Initial employee design
2. Added Employee class
3. Implemented leave management
4. Added inheritance
5. Implemented polymorphism
6. Added Manager
7. Refactored code
8. Final version

## GitHub Repository

[Leave Management System - GitHub Repository](https://github.com/Sharanyaaaaaaaa/leave-management-system.git)