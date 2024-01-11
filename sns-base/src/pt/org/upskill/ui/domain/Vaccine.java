package pt.org.upskill.ui.domain;

public class Vaccine {
    private int id;
    private String name;
    private VaccineType vaccineType;
    private Brand brand;

    public Vaccine(String name, VaccineType vaccineType, Brand brand) {
        //this.id = ;
        this.name = name;
        this.vaccineType = vaccineType;
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VaccineType getVaccineType() {
        return vaccineType;
    }

    public void setVaccineType(VaccineType vaccineType) {
        this.vaccineType = vaccineType;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
