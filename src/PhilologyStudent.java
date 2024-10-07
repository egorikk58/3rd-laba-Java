import java.math.BigDecimal;

/**
 * Класс, представляющий студента-филолога, наследуется от класса Student.
 */
public class PhilologyStudent extends Student {

    private String _studiedLanguage; // Изучаемый язык (латинский, древнегреческий и т.д.)
    private String _literarySpecialization; // Литературная специализация (эпоха, жанр и т.д.)
    private String _textSpecialization; // Специализация на типах текстов (художественные, технические и т.д.)
    private String _thesisTopic; // Тема итоговой работы
    private boolean _hasRareLanguageKnowledge; // Наличие знаний редких или мёртвых языков

    /**
     * Конструктор без параметров, инициализирует поля значениями по умолчанию.
     */
    public PhilologyStudent() {
        super();
        _studiedLanguage = null;
        _literarySpecialization = null;
        _textSpecialization = null;
        _thesisTopic = null;
        _hasRareLanguageKnowledge = false;
    }

    /**
     * Конструктор с параметрами для инициализации полей класса.
     *
     * @param fullname Полное имя студента.
     * @param gender Пол студента.
     * @param age Возраст студента.
     * @param countryofbirth Страна рождения студента.
     * @param phonenumber Номер телефона студента.
     * @param studentID Идентификационный номер студента.
     * @param yearofstudy Год обучения.
     * @param absences Количество пропусков.
     * @param gpa Средний балл.
     * @param hasScholarship Наличие стипендии.
     * @param studiedLanguage Изучаемый язык.
     * @param literarySpecialization Литературная специализация.
     * @param textSpecialization Специализация на типах текстов.
     * @param thesisTopic Тема итоговой работы.
     * @param hasRareLanguageKnowledge Наличие знаний редких языков (да/нет).
     * @throws IllegalArgumentException Если переданы некорректные значения.
     */
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

    /**
     * Проверяет корректность изучаемого языка.
     *
     * @param studiedLanguage Изучаемый язык.
     * @throws IllegalArgumentException Если язык некорректен.
     */
    public static void validateStudiedLanguage(String studiedLanguage) {
        if (!studiedLanguage.matches("^[А-Яа-яЁё]+$")) {
            throw new IllegalArgumentException("Вы ввели некорректный изучаемый язык");
        }
    }

    /**
     * Проверяет корректность литературной специализации.
     *
     * @param literarySpecialization Литературная специализация.
     * @throws IllegalArgumentException Если специализация некорректна.
     */
    public static void validateLiterarySpecialization(String literarySpecialization) {
        if (!literarySpecialization.matches("^[А-Яа-яЁё\\s]+$")) {
            throw new IllegalArgumentException("Вы ввели некорректную литературную специализацию");
        }
    }

    /**
    * Проверяет корректность специализации на типах текстов.
    *
     * @param textSpecialization Специализация на типах текстов.
     * @throws IllegalArgumentException Если специализация некорректна.
     */
    public static void validateTextSpecialization(String textSpecialization) {
        if (!textSpecialization.matches("^(художественные|технические|научные|публицистические)$")) {
            throw new IllegalArgumentException("Вы ввели некорректную специализацию на типах текстов");
        }
    }

    /**
     * Проверяет корректность темы итоговой работы.
     *
     * @param thesisTopic Тема итоговой работы.
     * @throws IllegalArgumentException Если тема некорректна.
     */
    public static void validateThesisTopic(String thesisTopic) {
        if (!thesisTopic.matches("^[А-Яа-яЁё\\s]+$")) {
            throw new IllegalArgumentException("Тема итоговой работы не может быть пустой");
        }
    }

    /**
     * Проверяет корректность наличия знаний редких языков.
     *
     * @param hasRareLanguageKnowledge Наличие знаний редких языков (да/нет).
     * @throws IllegalArgumentException Если значение некорректно.
     */
    public static void validateRareLanguageKnowledge(String hasRareLanguageKnowledge) {
        if (!hasRareLanguageKnowledge.toLowerCase().matches("^(да|нет)$")) {
            throw new IllegalArgumentException("Вы некорректно указали наличие знаний редких языков");
        }
    }

    /**
     * Получает изучаемый язык студента.
     *
     * @return Изучаемый язык.
     */
    public String getStudiedLanguage() {
        return _studiedLanguage;
    }

    /**
     * Устанавливает новый изучаемый язык после проверки корректности.
     *
     * @param studiedLanguage Новый изучаемый язык.
     * @throws IllegalArgumentException Если язык некорректен.
     */
    public void setStudiedLanguage(String studiedLanguage) {
        validateStudiedLanguage(studiedLanguage);
        this._studiedLanguage = studiedLanguage;
    }

    /**
     * Получает литературную специализацию студента.
     *
     * @return Литературная специализация.
     */
    public String getLiterarySpecialization() {
        return _literarySpecialization;
    }

    /**
     * Устанавливает новую литературную специализацию после проверки корректности.
     *
     * @param literarySpecialization Новая литературная специализация.
     * @throws IllegalArgumentException Если специализация некорректна.
     */
    public void setLiterarySpecialization(String literarySpecialization) {
        validateLiterarySpecialization(literarySpecialization);
        this._literarySpecialization = literarySpecialization;
    }

    /**
     * Получает специализацию на типах текстов студента.
     *
     * @return Специализация на типах текстов.
     */
    public String getTextSpecialization() {
        return _textSpecialization;
    }

    /**
     * Устанавливает новую специализацию на типах текстов после проверки корректности.
     *
     * @param textSpecialization Новая специализация на типах текстов.
     * @throws IllegalArgumentException Если специализация некорректна.
     */
    public void setTextSpecialization(String textSpecialization) {
        validateTextSpecialization(textSpecialization);
        this._textSpecialization = textSpecialization;
    }

    /**
     * Получает тему итоговой работы студента.
     *
     * @return Тема итоговой работы.
     */
    public String getThesisTopic() {
        return _thesisTopic;
    }

    /**
     * Устанавливает новую тему итоговой работы после проверки корректности.
     *
     * @param thesisTopic Новая тема итоговой работы.
     * @throws IllegalArgumentException Если тема некорректна.
     */
    public void setThesisTopic(String thesisTopic) {
        validateThesisTopic(thesisTopic);
        this._thesisTopic = thesisTopic;
    }

    /**
     * Проверяет, есть ли у студента знания редких или мёртвых языков.
     *
     * @return true, если есть знания редких языков, иначе false.
     */
    public boolean isHasRareLanguageKnowledge() {
        return _hasRareLanguageKnowledge;
    }

    /**
     * Устанавливает наличие знаний редких языков после проверки корректности.
     *
     * @param hasRareLanguageKnowledge Наличие знаний редких языков (да/нет).
     * @throws IllegalArgumentException Если значение некорректно.
     */
    public void setHasRareLanguageKnowledge(String hasRareLanguageKnowledge) {
        validateRareLanguageKnowledge(hasRareLanguageKnowledge);
        this._hasRareLanguageKnowledge = hasRareLanguageKnowledge.equalsIgnoreCase("да");
    }

    /**
     * Получает информацию о студенте в формате строки.
     *
     * @return Строка с информацией о студенте, включая изучаемый язык, литературную специализацию,
     *         специализацию на типах текстов, тему итоговой работы и наличие знаний редких языков.
     */
    @Override
    public String getInfo() {
        return super.getInfo() +
                "Изучаемый язык: " + _studiedLanguage + "\n" +
                "Литературная специализация: " + _literarySpecialization + "\n" +
                "Специализация на типах текстов: " + _textSpecialization + "\n" +
                "Тема итоговой работы: " + _thesisTopic + "\n" +
                "Знания редких или мёртвых языков: " + (_hasRareLanguageKnowledge ? "да" : "нет");
    }


}