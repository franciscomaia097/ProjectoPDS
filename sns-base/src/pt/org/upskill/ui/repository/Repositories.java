package pt.org.upskill.ui.repository;
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
    VaccinationCenterRepository vaccinationCenterRepository = new VaccinationCenterRepository();


    public VaccineTechRepository vaccineTechRepository() {return vaccineTechRepository;}
    public VaccineTypeRepository vaccineTypeRepository() {return vaccineTypeRepository;}
    public VaccineRepository vaccineRepository() {return vaccineRepository;}
    public BrandRepository brandRepository() {return brandRepository;}
    public VaccinationCenterRepository vaccinationCenterRepository() {return vaccinationCenterRepository;}

}