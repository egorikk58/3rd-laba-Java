import java.util.ArrayList;
import java.math.BigDecimal;
public class MedicalStudent extends Student {

    private String _specialization; // специализация (хирург, терапевт и т.д.)
    private String _studytype; // теоретик или практик
    private boolean _hasaccesstopractice; // имеет ли доступ к практике (находиться на операциях и т.д.)
    private int _hoursofpractice; // общее время в часах работы в больнице
    private boolean _hasemergencyexperience; // имеет ли опыт работы в экстренных ситуациях

    public MedicalStudent() {
        super();
        _specialization = null;
        _studytype = null;
        _hasaccesstopractice = false;
        _hoursofpractice = 0;
        _hasemergencyexperience = false;
    }

    public MedicalStudent(String fullname, String gender, int age, String countryofbirth, String phonenumber,
                          String studentID, int yearofstudy, int absences, BigDecimal gpa, String hasScholarship,
                          String specialization, String studytype, boolean hasaccesstopractice, int hoursofpractice,
                          boolean hasemergencyexperience) {
        super(fullname, gender, age, countryofbirth, phonenumber, studentID, yearofstudy, absences, gpa, hasScholarship);
        this._specialization = specialization;
        this._studytype = studytype;
        this._hasaccesstopractice = hasaccesstopractice;
        this._hoursofpractice = hoursofpractice;
        this._hasemergencyexperience = hasemergencyexperience;
    }

    public String getSpecialization() {
        return _specialization;
    }

    public void setSpecialization(String specialization) {
        this._specialization = specialization;
    }

    public String getStudytype() {
        return _studytype;
    }

    public void setStudytype(String studytype) {
        this._studytype = studytype;
    }

    public boolean hasAccessToPractice() {
        return _hasaccesstopractice;
    }

    public void setAccessToPractice(boolean hasaccesstopractice) {
        this._hasaccesstopractice = hasaccesstopractice;
    }

    public int getHoursOfPractice() {
        return _hoursofpractice;
    }

    public void setHoursOfPractice(int hoursofpractice) {
        if (hoursofpractice < 0) {
            throw new IllegalArgumentException("Часы практики не могут быть отрицательными");
        }
        this._hoursofpractice = hoursofpractice;
    }

    public boolean hasEmergencyExperience() {
        return _hasemergencyexperience;
    }

    public void setEmergencyExperience(boolean hasemergencyexperience) {
        this._hasemergencyexperience = hasemergencyexperience;
    }

    public void conductResearch() {
        System.out.println("Conducting medical research.");
    }

    public void attendResidency() {
        if (_hasaccesstopractice) {
            System.out.println("Attending residency.");
        } else {
            System.out.println("Not allowed to practice.");
        }
    }

    public void treatPatients() {
        System.out.println("Treating patients.");
    }

    public void performSurgery() {
        if (_specialization.equalsIgnoreCase("хирург")) {
            System.out.println("Performing surgery.");
        } else {
            System.out.println("Not specialized in surgery.");
        }
    }

    public void handleEmergency() {
        if (_hasemergencyexperience) {
            System.out.println("Handling emergency situation.");
        } else {
            System.out.println("No experience in emergency situations.");
        }
    }

    @Override
    public ArrayList<String> getInfo() {
        ArrayList<String> info = super.getInfo();
        info.add("Medical Student");
        info.add("Specialization: " + _specialization);
        info.add("Study Type: " + _studytype);
        info.add("Access to Practice: " + (_hasaccesstopractice ? "Yes" : "No"));
        info.add("Hours of Practice: " + _hoursofpractice);
        info.add("Emergency Experience: " + (_hasemergencyexperience ? "Yes" : "No"));
        return info;
    }
}