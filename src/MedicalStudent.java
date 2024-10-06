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
                          String specialization, String studytype, String hasaccesstopractice, int hoursofpractice,
                          String hasemergencyexperience) {
        super(fullname, gender, age, countryofbirth, phonenumber, studentID,
                yearofstudy, absences, gpa, hasScholarship);
        validateSpecialization(specialization);
        validateAccesstopractice(hasaccesstopractice);
        validateEmergencyexperience(hasemergencyexperience);
        validateHoursofpractice(hoursofpractice);
        validateStudytype(studytype);
        this._specialization = specialization;
        this._studytype = studytype;
        this._hasaccesstopractice = hasaccesstopractice.equalsIgnoreCase("да");
        this._hoursofpractice = hoursofpractice;
        this._hasemergencyexperience = hasemergencyexperience.equalsIgnoreCase("да");
    }

    public void validateAccesstopractice(String hasaccesstopractice) {
        if (hasaccesstopractice.isEmpty() || !hasaccesstopractice.toLowerCase().matches("^(да|нет)$")) {
            throw new IllegalArgumentException("Вы некорректно указали информацию о наличии доступа" +
                    " студента к врачебной практике");
        }
    }

    public void validateEmergencyexperience(String hasemergencyexperience) {
        if (hasemergencyexperience.isEmpty() || !hasemergencyexperience.toLowerCase().matches("^(да|нет)$")) {
            throw new IllegalArgumentException("Вы некорректно указали информацию о наличии опыта" +
                    " студента при работе в экстренных ситуациях");
        }
    }

    public void validateSpecialization(String specialization) {
        if (specialization.isEmpty() || !specialization.matches("^[А-Яа-яЁё]+$")) {
            throw new IllegalArgumentException("Вы ввели некорректную специализацию");
        }
    }

    public void validateStudytype(String studytype) {
        if (studytype.isEmpty() || !studytype.matches("^(теоретик|практик)$")) {
            throw new IllegalArgumentException("Вы ввели некорректный тип обучения (теоретик или практик)");
        }
    }

    public void validateHoursofpractice(int hours) {
        if (hours < 0) {
            throw new IllegalArgumentException("Вы ввели некорректное количество часов практики");
        }
    }



    public String getSpecialization() {
        return _specialization;
    }

    public void setSpecialization(String specialization) {
        validateSpecialization(specialization);
        this._specialization = specialization;
    }


    public String getStudytype() {
        return _studytype;
    }

    public void setStudytype(String studytype) {
        validateStudytype(studytype);
        this._studytype = studytype;
    }


    public boolean isHasaccesstopractice() {
        return _hasaccesstopractice;
    }

    public void setHasaccesstopractice(String hasaccesstopractice) {
        validateAccesstopractice(hasaccesstopractice);
        this._hasaccesstopractice = hasaccesstopractice.equalsIgnoreCase("да");
    }


    public int getHoursofpractice() {
        return _hoursofpractice;
    }

    public void setHoursofpractice(int hoursofpractice) {
        validateHoursofpractice(hoursofpractice);
        this._hoursofpractice = hoursofpractice;
    }


    public boolean isHasemergencyexperience() {
        return _hasemergencyexperience;
    }

    public void setHasemergencyexperience(String hasemergencyexperience) {
        validateEmergencyexperience(hasemergencyexperience);
        this._hasemergencyexperience = hasemergencyexperience.equalsIgnoreCase("да");
    }
}