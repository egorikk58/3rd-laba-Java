import java.math.BigDecimal;

public class PhilologyStudent extends Student {
    private String _studiedLanguage; // изучаемый язык (латинский, древнегреческий и т.д.)
    private String _literarySpecialization; // литературная специализация (эпоха, жанр и т.д.)
    private String _textSpecialization; // специализация на типах текстов (художественные, технические и т.д.)
    private String _thesisTopic; // тема итоговой работы
    private boolean _hasRareLanguageKnowledge; // наличие знаний редких или мёртвых языков

    public PhilologyStudent() {
        super();
        _studiedLanguage = null;
        _literarySpecialization = null;
        _textSpecialization = null;
        _thesisTopic = null;
        _hasRareLanguageKnowledge = false;
    }

    public PhilologyStudent(String fullname, String gender, int age, String countryofbirth, String phonenumber,
                            String studentID, int yearofstudy, int absences, BigDecimal gpa, String hasScholarship,
                            String studiedLanguage, String literarySpecialization, String textSpecialization,
                            String thesisTopic, String hasRareLanguageKnowledge) {
        super(fullname, gender, age, countryofbirth, phonenumber, studentID,
                yearofstudy, absences, gpa, hasScholarship);
        validateStudiedLanguage(studiedLanguage);
        validateLiterarySpecialization(literarySpecialization);
        validateTextSpecialization(textSpecialization);
        validateThesisTopic(thesisTopic);
        validateRareLanguageKnowledge(hasRareLanguageKnowledge);
        this._studiedLanguage = studiedLanguage;
        this._literarySpecialization = literarySpecialization;
        this._textSpecialization = textSpecialization;
        this._thesisTopic = thesisTopic;
        this._hasRareLanguageKnowledge = hasRareLanguageKnowledge.equalsIgnoreCase("да");
    }

    public void validateStudiedLanguage(String studiedLanguage) {
        if (studiedLanguage.isEmpty() || !studiedLanguage.matches("^[А-Яа-яЁё]+$")) {
            throw new IllegalArgumentException("Вы ввели некорректный изучаемый язык");
        }
    }

    public void validateLiterarySpecialization(String literarySpecialization) {
        if (literarySpecialization.isEmpty() || !literarySpecialization.matches("^[А-Яа-яЁё\\s]+$")) {
            throw new IllegalArgumentException("Вы ввели некорректную литературную специализацию");
        }
    }

    public void validateTextSpecialization(String textSpecialization) {
        if (textSpecialization.isEmpty() ||
                !textSpecialization.matches("^(художественные|технические|научные|публицистические)$")) {
            throw new IllegalArgumentException("Вы ввели некорректную специализацию на типах текстов");
        }
    }

    public void validateThesisTopic(String thesisTopic) {
        if (thesisTopic.isEmpty() || !thesisTopic.matches("^[А-Яа-яЁё\\s]+$")) {
            throw new IllegalArgumentException("Тема итоговой работы не может быть пустой");
        }
    }

    public void validateRareLanguageKnowledge(String hasRareLanguageKnowledge) {
        if (hasRareLanguageKnowledge.isEmpty() || !hasRareLanguageKnowledge.toLowerCase().matches("^(да|нет)$")) {
            throw new IllegalArgumentException("Вы некорректно указали наличие знаний редких языков");
        }
    }


    public String getStudiedLanguage() {
        return _studiedLanguage;
    }

    public void setStudiedLanguage(String studiedLanguage) {
        validateStudiedLanguage(studiedLanguage);
        this._studiedLanguage = studiedLanguage;
    }

    public String getLiterarySpecialization() {
        return _literarySpecialization;
    }

    public void setLiterarySpecialization(String literarySpecialization) {
        validateLiterarySpecialization(literarySpecialization);
        this._literarySpecialization = literarySpecialization;
    }

    public String getTextSpecialization() {
        return _textSpecialization;
    }

    public void setTextSpecialization(String textSpecialization) {
        validateTextSpecialization(textSpecialization);
        this._textSpecialization = textSpecialization;
    }

    public String getThesisTopic() {
        return _thesisTopic;
    }

    public void setThesisTopic(String thesisTopic) {
        validateThesisTopic(thesisTopic);
        this._thesisTopic = thesisTopic;
    }

    public boolean isHasRareLanguageKnowledge() {
        return _hasRareLanguageKnowledge;
    }

    public void setHasRareLanguageKnowledge(String hasRareLanguageKnowledge) {
        validateRareLanguageKnowledge(hasRareLanguageKnowledge);
        this._hasRareLanguageKnowledge = hasRareLanguageKnowledge.equalsIgnoreCase("да");
    }
}
