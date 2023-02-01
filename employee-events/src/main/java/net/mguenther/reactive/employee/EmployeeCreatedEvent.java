package net.mguenther.reactive.employee;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;

public class EmployeeCreatedEvent extends EmployeeEvent {

    private final String employeeId;

    private final String givenName;

    private final String lastName;

    private final String email;

    private final String departmentName;

    private final String departmentDescription;

    private final String company;

    @JsonCreator
    public EmployeeCreatedEvent(@JsonProperty("employeeId") final String employeeId,
                                @JsonProperty("givenName") final String givenName,
                                @JsonProperty("lastName") final String lastName,
                                @JsonProperty("email") final String email,
                                @JsonProperty("departmentName") final String departmentName,
                                @JsonProperty("departmentDescription") final String departmentDescription,
                                @JsonProperty("company") final String company) {
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
        PolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator.builder().build();
        mapper.activateDefaultTyping(ptv); // default to using DefaultTyping.OBJECT_AND_NON_CONCRETE
        mapper.activateDefaultTyping(ptv, ObjectMapper.DefaultTyping.NON_FINAL);
        EmployeeCreatedEvent event = new EmployeeCreatedEvent("1", "Max", "Mustermann", "max.mustermann@musterhaus.de", "Musterabteilung", "Mustererkennung", "Musterfirma");
        String s = mapper.writeValueAsString(event);
        EmployeeEvent e = mapper.readValue(s, EmployeeEvent.class);
        System.out.println(e);
    }
}
