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

    public String get_specialization() {
        return _specialization;
    }

    public void set_specialization(String _specialization) {
        this._specialization = _specialization;
    }


    public String get_studytype() {
        return _studytype;
    }

    public void set_studytype(String _studytype) {
        this._studytype = _studytype;
    }


    public boolean is_hasaccesstopractice() {
        return _hasaccesstopractice;
    }

    public void set_hasaccesstopractice(boolean _hasaccesstopractice) {
        this._hasaccesstopractice = _hasaccesstopractice;
    }


    public int get_hoursofpractice() {
        return _hoursofpractice;
    }

    public void set_hoursofpractice(int _hoursofpractice) {
        this._hoursofpractice = _hoursofpractice;
    }


    public boolean is_hasemergencyexperience() {
        return _hasemergencyexperience;
    }

    public void set_hasemergencyexperience(boolean _hasemergencyexperience) {
        this._hasemergencyexperience = _hasemergencyexperience;
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