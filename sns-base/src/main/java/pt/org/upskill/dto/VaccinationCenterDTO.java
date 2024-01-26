package pt.org.upskill.dto;

import pt.org.upskill.domain.VaccinationCenter;

public class VaccinationCenterDTO implements DTO {

    private Integer id;
    private String name;
    private AddressDTO addressDTO;

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public AddressDTO addressDTO() {
        return this.addressDTO;
    }

    private VaccinationCenterDTO(final VaccinationCenterDTO.Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.addressDTO = builder.addressDTO;
    }

    public static class Builder {
        private Integer id;
        private String name;
        private AddressDTO addressDTO;

        public VaccinationCenterDTO.Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public VaccinationCenterDTO.Builder withName(String name) {
            this.name = name;
            return this;
        }

        public VaccinationCenterDTO.Builder withAddressDTO(AddressDTO addressDTO) {
            this.addressDTO = addressDTO;
            return this;
        }

        public VaccinationCenterDTO build() {
            return new VaccinationCenterDTO(this);
        }
    }
}