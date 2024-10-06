import java.math.BigDecimal;
import java.util.ArrayList;

public class PhilologyStudent extends Student {

    private String _specialization; // специализация (лингвистика, литература и т.д.)
    private String _favoriteAuthor; // любимый автор
    private String _languageOfStudy; // изучаемый язык
    private String _thesisTopic; // тема диплома
    private String _researchInterests; // исследовательские интересы

    public PhilologyStudent() {
        super();
        _specialization = null;
        _favoriteAuthor = null;
        _languageOfStudy = null;
        _thesisTopic = null;
        _researchInterests = null;
    }

    public PhilologyStudent(String fullname, String gender, int age, String countryofbirth, String phonenumber,
                            String studentID, int yearofstudy, int absences, BigDecimal gpa, String hasScholarship,
                            String specialization, String favoriteAuthor, String languageOfStudy,
                            String thesisTopic, String researchInterests) {
        super(fullname, gender, age, countryofbirth, phonenumber, studentID, yearofstudy, absences, gpa, hasScholarship);
        this._specialization = specialization;
        this._favoriteAuthor = favoriteAuthor;
        this._languageOfStudy = languageOfStudy;
        this._thesisTopic = thesisTopic;
        this._researchInterests = researchInterests;
    }

    public String getSpecialization() {
        return _specialization;
    }

    public void setSpecialization(String specialization) {
        this._specialization = specialization;
    }

    public String getFavoriteAuthor() {
        return _favoriteAuthor;
    }

    public void setFavoriteAuthor(String favoriteAuthor) {
        this._favoriteAuthor = favoriteAuthor;
    }

    public String getLanguageOfStudy() {
        return _languageOfStudy;
    }

    public void setLanguageOfStudy(String languageOfStudy) {
        this._languageOfStudy = languageOfStudy;
    }

    public String getThesisTopic() {
        return _thesisTopic;
    }

    public void setThesisTopic(String thesisTopic) {
        this._thesisTopic = thesisTopic;
    }

    public String getResearchInterests() {
        return _researchInterests;
    }

    public void setResearchInterests(String researchInterests) {
        this._researchInterests = researchInterests;
    }

    @Override
    public ArrayList<String> getInfo() {
        ArrayList<String> info = super.getInfo();
        info.add("Philology Student");
        info.add("Specialization: " + _specialization);
        info.add("Favorite Author: " + _favoriteAuthor);
        info.add("Language of Study: " + _languageOfStudy);
        info.add("Thesis Topic: " + _thesisTopic);
        info.add("Research Interests: " + _researchInterests);
        return info;
    }
}
