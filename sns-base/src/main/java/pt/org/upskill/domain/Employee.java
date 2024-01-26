package pt.org.upskill.domain;

import pt.org.upskill.auth.Email;
import pt.org.upskill.dto.DTOable;
import pt.org.upskill.dto.EmailDTO;
import pt.org.upskill.dto.EmployeeDTO;

public class Employee implements DTOable<EmployeeDTO> {
    private int id;
    private final Email email;
    private String name;
    private String position;
    private String phone;

    public Employee(int id, Email email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Email getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee employee = (Employee) o;
        return email.equals(employee.email);
    }

    public boolean hasEmail(String email) {
        return this.email.address().equals(email);
    }
    public EmployeeDTO toDTO() {
        EmployeeDTO.Builder builder = new EmployeeDTO.Builder();
        builder.withId(id)
                .withEmailDTO(new EmailDTO(email.address()))
                .withName(name)
                .withPosition(position)
                .withPhone(phone);
        return builder.build();
    }
    public static class Builder {
        private int id;
        private Email email;
        private String name;
        private String position;
        private String phone;

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withEmail(Email email) {
            this.email = email;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withPosition(String position) {
            this.position = position;
            return this;
        }

        public Builder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }

    private Employee(Builder builder) {
        this.id = builder.id;
        this.email = builder.email;
        this.name = builder.name;
        this.position = builder.position;
        this.phone = builder.phone;
    }
}
