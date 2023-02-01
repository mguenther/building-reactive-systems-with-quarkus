package net.mguenther.reactive.employee;

public class EmployeeDeletedEvent extends EmployeeEvent {

    private final String employeeId;

    public EmployeeDeletedEvent(final String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }
}
