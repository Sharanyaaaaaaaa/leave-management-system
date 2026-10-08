# Refactoring Notes

The first working version (commits 3 to 6) worked, but adding the Manager type showed several
problems. These were fixed in the commit "Refactored code". The run output after refactoring
is in `sample_output.txt`.

## Improvement 1: Duplicate code removed (reusability and maintainability)
**Problem:** `FullTimeEmployee`, `PartTimeEmployee`, `Intern` and `Manager` each had their own
copy of `applyLeave()` with the same "invalid days" check and a different number for the limit.
The Manager copy even repeated the balance check and the deduction.
**Fix:** The checks now live in one place, `Employee.validateRequest()`. Each subclass only
provides its own limit through `getMaxDaysPerRequest()`. Four duplicated methods were removed.
A new employee type now needs only two small methods.

## Improvement 2: Exception handling instead of print and boolean (exception handling)
**Problem:** `applyLeave()` printed messages inside the class and returned `true` or `false`.
The caller could not tell why a request failed, and the class mixed logic with display.
**Fix:** Added `LeaveException` with three subclasses: `InvalidLeaveRequestException`,
`InsufficientLeaveBalanceException` and `LeaveNotFoundException`. The methods now throw the
right exception with a clear message, and `LeaveApp` catches them and decides what to show.

## Improvement 3: Bug fixed in cancelLeave() (debugging)
**Problem:** The old `cancelLeave(int days)` simply added the days back to the balance
without checking that such leave was ever applied. When tested on the version from the
"Implemented leave management" commit, an intern with 6 days of leave who cancelled
10 days ended up with a balance of **16**.
**Fix:** Added the `LeaveRequest` class and a leave history. Each request gets an ID, and
`cancelLeave(requestId)` now cancels only a real request, only once. Cancelling an unknown ID
or an already cancelled request throws an exception. The balance can no longer go above
what was actually taken.

## Improvement 4: Better naming and constants (naming)
**Problem:** Names such as `empId`, `empName`, `dept` and `bal` were short and unclear, and
numbers such as 24, 15, 12, 5 and 6 were written directly in the code.
**Fix:** Renamed to `employeeId`, `employeeName`, `department` and `leaveBalance`, and moved
the numbers into named constants such as `ANNUAL_ENTITLEMENT` and `MAX_DAYS_PER_REQUEST`.

## Improvement 5: Tighter encapsulation (class responsibilities)
**Problem:** To make Manager work, `Employee` had to expose the `protected` methods
`addBonusLeave()` and `deductLeave()`, which let subclasses change the balance freely.
**Fix:** These were removed. The balance is now changed only inside `Employee`, the
entitlement is passed through the constructor, and fields are `final` where possible.
Constructors also validate their input (for example a blank name is rejected).

## Summary of the design change
| Before | After |
|--------|-------|
| 4 copies of leave validation | 1 shared method in `Employee` |
| `boolean` return and printing inside the class | Custom exceptions, printing only in `LeaveApp` |
| Cancel by number of days (bug) | Cancel by request ID with leave history |
| `bal`, `dept`, magic numbers | Descriptive names and constants |
| Manager had to copy full-time logic | Manager reuses `FullTimeEmployee` and `Employee` |
