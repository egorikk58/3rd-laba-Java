import java.math.BigDecimal;
import java.util.ArrayList;

public class EngineeringStudent extends Student {

    private String _programmingLanguage; // язык программирования
    private boolean _wearsGlasses; // носит ли очки
    private String _laptopModel; // модель ноутбука
    private boolean _isNerd; // ботан или нет
    private String _preferredTechnology; // предпочтительная технология

    public EngineeringStudent() {
        super();
        _programmingLanguage = null;
        _wearsGlasses = false;
        _laptopModel = null;
        _isNerd = false;
        _preferredTechnology = null;
    }

    public EngineeringStudent(String fullname, String gender, int age, String countryofbirth, String phonenumber,
                              String studentID, int yearofstudy, int absences, BigDecimal gpa, String hasScholarship,
                              String programmingLanguage, boolean wearsGlasses, String laptopModel,
                              boolean isNerd, String preferredTechnology) {
        super(fullname, gender, age, countryofbirth, phonenumber, studentID, yearofstudy, absences, gpa, hasScholarship);
        this._programmingLanguage = programmingLanguage;
        this._wearsGlasses = wearsGlasses;
        this._laptopModel = laptopModel;
        this._isNerd = isNerd;
        this._preferredTechnology = preferredTechnology;
    }

    public String getProgrammingLanguage() {
        return _programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this._programmingLanguage = programmingLanguage;
    }

    public boolean isWearsGlasses() {
        return _wearsGlasses;
    }

    public void setWearsGlasses(boolean wearsGlasses) {
        this._wearsGlasses = wearsGlasses;
    }

    public String getLaptopModel() {
        return _laptopModel;
    }

    public void setLaptopModel(String laptopModel) {
        this._laptopModel = laptopModel;
    }

    public boolean isNerd() {
        return _isNerd;
    }

    public void setNerd(boolean isNerd) {
        this._isNerd = isNerd;
    }

    public String getPreferredTechnology() {
        return _preferredTechnology;
    }

    public void setPreferredTechnology(String preferredTechnology) {
        this._preferredTechnology = preferredTechnology;
    }

    @Override
    public ArrayList<String> getInfo() {
        ArrayList<String> info = super.getInfo();
        info.add("Engineering Student");
        info.add("Programming Language: " + _programmingLanguage);
        info.add("Wears Glasses: " + (_wearsGlasses ? "Yes" : "No"));
        info.add("Laptop Model: " + _laptopModel);
        info.add("Is Nerd: " + (_isNerd ? "Yes" : "No"));
        info.add("Preferred Technology: " + _preferredTechnology);
        return info;
    }
}
