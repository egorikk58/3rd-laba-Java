import java.math.BigDecimal;
import java.util.ArrayList;

public class PhilologyStudent extends Student {

    private String _specialization; // специализация (лингвистика, литература и т.д.)
    private String _favoriteAuthor; // любимый автор
    private String _languageOfStudy; // изучаемый язык

    public PhilologyStudent() {
        super();
        _specialization = null;
        _favoriteAuthor = null;
        _languageOfStudy = null;
    }

    public PhilologyStudent(String fullname, String gender, int age, String countryofbirth, String phonenumber,
                            String studentID, int yearofstudy, int absences, BigDecimal gpa, String hasScholarship,
                            String specialization, String favoriteAuthor, String languageOfStudy) {
        super(fullname, gender, age, countryofbirth, phonenumber, studentID, yearofstudy, absences, gpa, hasScholarship);
        this._specialization = specialization;
        this._favoriteAuthor = favoriteAuthor;
        this._languageOfStudy = languageOfStudy;
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

    public void analyzeText() {
        System.out.println("Analyzing a literary text.");
    }

    public void translateText() {
        System.out.println("Translating text from " + _languageOfStudy);
    }

    public void writeEssay() {
        System.out.println("Writing an essay on " + _favoriteAuthor);
    }

    public void participateInConference() {
        System.out.println("Participating in a philological conference.");
    }

    public void studyLiterature() {
        System.out.println("Studying literature in the field of " + _specialization);
    }

    @Override
    public ArrayList<String> getInfo() {
        ArrayList<String> info = super.getInfo();
        info.add("Philology Student");
        info.add("Specialization: " + _specialization);
        info.add("Favorite Author: " + _favoriteAuthor);
        info.add("Language of Study: " + _languageOfStudy);
        return info;
    }
}