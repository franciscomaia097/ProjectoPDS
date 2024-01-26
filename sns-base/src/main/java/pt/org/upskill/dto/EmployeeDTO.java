package pt.org.upskill.dto;

public class EmployeeDTO implements DTO {
    private Integer id;
    private String name;
    private EmailDTO emailDTO;
    private String position;
    private String phone;

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public EmailDTO getEmailDTO() {
        return this.emailDTO;
    }

    public String getPosition() {
        return this.position;
    }

    public String getPhone() {
        return this.phone;
    }

    private EmployeeDTO(final EmployeeDTO.Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.emailDTO = builder.emailDTO;
        this.position = builder.position;
        this.phone = builder.phone;
    }

    public static class Builder {
        private Integer id;
        private String name;
        private EmailDTO emailDTO;
        private String position;
        private String phone;

        public EmployeeDTO.Builder withId(final Integer id) {
            this.id = id;
            return this;
        }

        public EmployeeDTO.Builder withName(final String name) {
            this.name = name;
            return this;
        }

        public EmployeeDTO.Builder withEmailDTO(final EmailDTO emailDTO) {
            this.emailDTO = emailDTO;
            return this;
        }

        public EmployeeDTO.Builder withPosition(final String position) {
            this.position = position;
            return this;
        }

        public EmployeeDTO.Builder withPhone(final String phone) {
            this.phone = phone;
            return this;
        }

        public EmployeeDTO build() {
            return new EmployeeDTO(this);
        }
    }
}
