package pt.org.upskill.domain;

import pt.org.upskill.dto.DTOable;
import pt.org.upskill.dto.VaccinationCenterDTO;

public class VaccinationCenter implements DTOable<VaccinationCenterDTO> {
   private Integer id;
    private String name;
    private Address address;

    public Integer id() {
        if (this.id == null) {
              throw new IllegalArgumentException("Id not defined yet");
        }
        return this.id;
    }
    public String name() {
        return this.name;
    }
    public Address address() {
        return this.address;
    }

    private VaccinationCenter(final VaccinationCenter.Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.address = builder.address;
    }

  public static class Builder {
        private Integer id;
        private String name;
        private Address address;

        public VaccinationCenter.Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public VaccinationCenter.Builder withName(String name) {
            this.name = name;
            return this;
        }

        public VaccinationCenter.Builder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public VaccinationCenter build() {
            return new VaccinationCenter(this);
        }
    }

    @Override
    public VaccinationCenterDTO toDTO() {
        return new VaccinationCenterDTO.Builder()
                .withId(this.id)
                .withName(this.name)
                .withAddressDTO(this.address.toDTO())
                .build();
  }
}
