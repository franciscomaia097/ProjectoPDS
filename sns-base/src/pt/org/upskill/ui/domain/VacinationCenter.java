package pt.org.upskill.ui.domain;

public class VacinationCenter {
    private String adress;
    private String pandemicName;

    public VacinationCenter(String adress, String pandemicName) {
        this.adress = adress;
        this.pandemicName = pandemicName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPandemicName() {
        return pandemicName;
    }

    public void setPandemicName(String pandemicName) {
        this.pandemicName = pandemicName;
    }
}
