import java.math.BigDecimal;
/**
 * Класс, представляющий студента инженерного факультета.
 * Наследует свойства от класса студента и добавляет специфические для инженерного направления поля.
 */
public class EngineeringStudent extends Student {

    private String _engineeringField; // инженерное направление (механика, электроника, строительная инженерия и т.д.)

    private String _projectSpecialization; // специализация на типах проектов (строительные, программные, промышленные и т.д.)

    private String _finalProjectTopic; // тема итогового проекта

    private int _hoursOfLabWork; // количество часов лабораторной работы

    private boolean _hasInternshipExperience; // наличие опыта стажировки
    /**
     * Конструктор по умолчанию для создания студента инженерного факультета.
     * Инициализирует поля значениями по умолчанию.
     */
    public EngineeringStudent() {
        super();
        _engineeringField = null;
        _projectSpecialization = null;
        _finalProjectTopic = null;
        _hoursOfLabWork = 0;
        _hasInternshipExperience = false;
    }
    /**
     * Конструктор для создания студента инженерного факультета с заданными параметрами.
     *
     * @param fullname Полное имя студента.
     * @param gender Пол студента.
     * @param age Возраст студента.
     * @param countryofbirth Страна рождения студента.
     * @param phonenumber Номер телефона студента.
     * @param studentID Идентификационный номер студента.
     * @param yearofstudy Год обучения студента.
     * @param absences Количество пропусков занятий.
     * @param gpa Средний балл студента.
     * @param hasScholarship Наличие стипендии (да/нет).
     * @param engineeringField Инженерное направление студента.
     * @param projectSpecialization Специализация проекта студента.
     * @param finalProjectTopic Тема финального проекта.
     * @param hoursOfLabWork Часы лабораторной работы.
     * @param hasInternshipExperience Наличие опыта стажировки (да/нет).
     */
    public EngineeringStudent(String fullname, String gender, int age, String countryofbirth, String phonenumber,
                              String studentID, int yearofstudy, int absences, BigDecimal gpa, String hasScholarship,
                              String engineeringField, String projectSpecialization, String finalProjectTopic,
                              int hoursOfLabWork, String hasInternshipExperience) {
        super(fullname, gender, age, countryofbirth, phonenumber, studentID,
                yearofstudy, absences, gpa, hasScholarship);
        validateEngineeringField(engineeringField);
        validateProjectSpecialization(projectSpecialization);
        validateFinalProjectTopic(finalProjectTopic);
        validateHoursOfLabWork(hoursOfLabWork);
        validateInternshipExperience(hasInternshipExperience);
        this._engineeringField = engineeringField;
        this._projectSpecialization = projectSpecialization;
        this._finalProjectTopic = finalProjectTopic;
        this._hoursOfLabWork = hoursOfLabWork;
        this._hasInternshipExperience = hasInternshipExperience.equalsIgnoreCase("да");
    }
    /**
     * Проверяет корректность введенного инженерного направления.
     *
     * @param engineeringField Инженерное направление для проверки.
     * @throws IllegalArgumentException Если направление содержит недопустимые символы.
     */
    public static void validateEngineeringField(String engineeringField) {
        if (!engineeringField.matches("^[А-Яа-яЁё\\s]+$")) {
            throw new IllegalArgumentException("Вы ввели некорректное инженерное направление");
        }
    }

    /**
     * Проверяет корректность специализации на типах проектов.
     *
     * @param projectSpecialization Специализация проекта для проверки.
     * @throws IllegalArgumentException Если специализация не соответствует допустимым значениям.
     */
    public static void validateProjectSpecialization(String projectSpecialization) {
        if (!projectSpecialization.matches("^(строительные|программные|промышленные|электротехнические)$")) {
            throw new IllegalArgumentException("Вы ввели некорректную специализацию на типах проектов");
        }
    }

    /**
     * Проверяет корректность темы выпускного проекта.
     *
     * @param finalProjectTopic Тема выпускного проекта для проверки.
     * @throws IllegalArgumentException Если тема содержит недопустимые символы.
     */
    public static void validateFinalProjectTopic(String finalProjectTopic) {
        if (!finalProjectTopic.matches("^[А-Яа-яЁё\\s]+$")) {
            throw new IllegalArgumentException("Вы ввели некорректную тему выпускного проекта");
        }
    }

    /**
     * Проверяет корректность введенного числа часов лабораторной работы.
     *
     * @param hoursOfLabWork Часы лабораторной работы для проверки.
     * @throws IllegalArgumentException Если число часов отрицательное.
     */
    public static void validateHoursOfLabWork(int hoursOfLabWork) {
        if (hoursOfLabWork < 0) {
            throw new IllegalArgumentException("Вы ввели некорректное число часов лабораторной работы");
        }
    }

    /**
     * Проверяет корректность указания наличия опыта стажировки.
     *
     * @param hasInternshipExperience Статус наличия опыта стажировки для проверки.
     * @throws IllegalArgumentException Если статус не соответствует допустимым значениям ("да" или "нет").
     */
    public static void validateInternshipExperience(String hasInternshipExperience) {
        if (!hasInternshipExperience.toLowerCase().matches("^(да|нет)$")) {
            throw new IllegalArgumentException("Вы некорректно указали наличие опыта стажировки");
        }
    }

    /**
     * Возвращает инженерное направление студента.
     *
     * @return Инженерное направление студента.
     */
    public String getEngineeringField() {
        return _engineeringField;
    }
    /**
     * Устанавливает инженерное направление студента.
     *
     * @param engineeringField Инженерное направление, которое необходимо установить.
     * @throws IllegalArgumentException Если направление некорректно.
     */
    public void setEngineeringField(String engineeringField) {
        validateEngineeringField(engineeringField);
        this._engineeringField = engineeringField;
    }

    /**
     * Получает специализацию на типах проектов студента.
     *
     * @return Специализация на типах проектов.
     */
    public String getProjectSpecialization() {
        return _projectSpecialization;
    }

    /**
     * Устанавливает специализацию на типах проектов студента.
     *
     * @param projectSpecialization Специализация на типах проектов, которую необходимо установить.
     * @throws IllegalArgumentException Если специализация некорректна.
     */
    public void setProjectSpecialization(String projectSpecialization) {
        validateProjectSpecialization(projectSpecialization);
        this._projectSpecialization = projectSpecialization;
    }

    /**
     * Получает тему итогового проекта студента.
     *
     * @return Тема итогового проекта.
     */
    public String getFinalProjectTopic() {
        return _finalProjectTopic;
    }

    /**
     * Устанавливает тему итогового проекта студента.
     *
     * @param finalProjectTopic Тема итогового проекта, которую необходимо установить.
     * @throws IllegalArgumentException Если тема некорректна.
     */
    public void setFinalProjectTopic(String finalProjectTopic) {
        validateFinalProjectTopic(finalProjectTopic);
        this._finalProjectTopic = finalProjectTopic;
    }

    /**
     * Получает количество часов лабораторной работы студента.
     *
     * @return Количество часов лабораторной работы.
     */
    public int getHoursOfLabWork() {
        return _hoursOfLabWork;
    }

    /**
     * Устанавливает количество часов лабораторной работы студента.
     *
     * @param hoursOfLabWork Количество часов лабораторной работы, которое необходимо установить.
     * @throws IllegalArgumentException Если число часов отрицательное.
     */
    public void setHoursOfLabWork(int hoursOfLabWork) {
        validateHoursOfLabWork(hoursOfLabWork);
        this._hoursOfLabWork = hoursOfLabWork;
    }

    /**
     * Проверяет наличие опыта стажировки у студента.
     *
     * @return true, если есть опыт стажировки; false в противном случае.
     */
    public boolean isHasInternshipExperience() {
        return _hasInternshipExperience;
    }

    /**
     * Устанавливает наличие опыта стажировки у студента.
     *
     * @param hasInternshipExperience Статус наличия опыта стажировки ("да" или "нет").
     * @throws IllegalArgumentException Если статус некорректен.
     */
    public void setHasInternshipExperience(String hasInternshipExperience) {
        validateInternshipExperience(hasInternshipExperience);
        this._hasInternshipExperience = hasInternshipExperience.equalsIgnoreCase("да");
    }

    /**
     * Получает информацию о студенте, включая инженерное направление,
     * специализацию, тему итогового проекта, количество часов лабораторной работы
     * и опыт прохождения стажировки.
     *
     * @return Строка с информацией о студенте.
     */
    @Override
    public String getInfo() {
        return super.getInfo() +
                "Инженерное направление: " + _engineeringField + "\n" +
                "Специализация на типах проектов: " + _projectSpecialization + "\n" +
                "Тема итогового проекта: " + _finalProjectTopic + "\n" +
                "Количество часов лабораторной работы: " + _hoursOfLabWork + "\n" +
                "Опыт прохождения стажировки: " + (_hasInternshipExperience ? "да" : "нет");
    }

}
