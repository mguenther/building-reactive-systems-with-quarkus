package net.mguenther.reactive.employee;

import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeCreatedEvent extends EmployeeEvent {

    private final String employeeId;

    private final String givenName;

    private final String lastName;

    private final String email;

    private final String departmentName;

    private final String departmentDescription;

    private final String company;

    public EmployeeCreatedEvent(final String employeeId,
                            final String givenName,
                            final String lastName,
                            final String email,
                            final String departmentName,
                            final String departmentDescription,
                            final String company) {
        this.employeeId = employeeId;
        this.givenName = givenName;
        this.lastName = lastName;
        this.email = email;
        this.departmentName = departmentName;
        this.departmentDescription = departmentDescription;
        this.company = company;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDepartmentDescription() {
        return departmentDescription;
    }

    public String getCompany() {
        return company;
    }

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        EmployeeCreatedEvent event = new EmployeeCreatedEvent("1", "Max", "Mustermann", "max.mustermann@musterhaus.de", "Musterabteilung", "Mustererkennung", "Musterfirma");
        System.out.println(mapper.writeValueAsString(event));
    }
}
