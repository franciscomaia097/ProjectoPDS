package pt.org.upskill.repository;
/**
 * @author Nuno Castro anc@isep.ipp.pt
 */

public class Repositories {

    private static final Repositories instance = new Repositories();
    private Repositories() {  }
    public static Repositories getInstance() {
        return instance;
    }

    RoleRepository roleRepository = new RoleRepository();
    UserRepository userRepository = new UserRepository();

    public RoleRepository roleRepository() {
        return roleRepository;
    }
    public UserRepository userRepository() {
        return userRepository;
    }

    //Your code here
    VaccineTechRepository vaccineTechRepository = new VaccineTechRepository();
    VaccineTypeRepository vaccineTypeRepository = new VaccineTypeRepository();
    VaccineRepository vaccineRepository = new VaccineRepository();
    BrandRepository brandRepository = new BrandRepository();
    FacilityRepository facilityRepository = new FacilityRepository();
    VaccinationCenterRepository vaccinationCenterRepository = new VaccinationCenterRepository();
    EmployeeRepository employeeRepository = new EmployeeRepository();



    public VaccineTechRepository vaccineTechRepository() {return vaccineTechRepository;}
    public EmployeeRepository employeeRepository(){return employeeRepository;}
    public VaccineTypeRepository vaccineTypeRepository() {return vaccineTypeRepository;}
    public VaccineRepository vaccineRepository() {return vaccineRepository;}
    public BrandRepository brandRepository() {return brandRepository;}
    public FacilityRepository facilityRepository() {return facilityRepository;}
    public VaccinationCenterRepository vaccinationCenterRepository() {return vaccinationCenterRepository;}
}