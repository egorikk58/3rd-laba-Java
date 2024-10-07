import java.math.BigDecimal;
public class MedicalStudent extends Student {

    private String _specialization; // специализация (хирург, терапевт и т.д.)

    private String _studytype; // теоретик или практик

    private boolean _hasaccesstopractice; // имеет ли доступ к практике (находиться на операциях и т.д.)

    private int _hoursofpractice; // общее время в часах работы в больнице

    private boolean _hasemergencyexperience; // имеет ли опыт работы в экстренных ситуациях
    /**
     * Конструктор по умолчанию для создания экземпляра MedicalStudent.
     */
    public MedicalStudent() {
        super();
        _specialization = null;
        _studytype = null;
        _hasaccesstopractice = false;
        _hoursofpractice = 0;
        _hasemergencyexperience = false;
    }
    /**
     * Конструктор для создания экземпляра MedicalStudent с заданными параметрами.
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
     * @param hasScholarship Статус наличия стипендии.
     * @param specialization Специализация студента.
     * @param studytype Тип обучения (теоретик/практик).
     * @param hasaccesstopractice Наличие доступа к врачебной практике ("да" или "нет").
     * @param hoursofpractice Количество часов практики.
     * @param hasemergencyexperience Наличие опыта работы в экстренных ситуациях ("да" или "нет").
     */
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
    /**
     * Проверяет корректность информации о наличии доступа к врачебной практике.
     *
     * @param hasaccesstopractice Строка с информацией о наличии доступа ("да" или "нет").
     * @throws IllegalArgumentException Если информация некорректна.
     */
    public static void validateAccesstopractice(String hasaccesstopractice) {
        if (!hasaccesstopractice.toLowerCase().matches("^(да|нет)$")) {
            throw new IllegalArgumentException("Вы некорректно указали информацию о наличии доступа" +
                    " студента к врачебной практике");
        }
    }
    /**
     * Проверяет корректность информации о наличии опыта работы в экстренных ситуациях.
     *
     * @param hasemergencyexperience Строка с информацией о наличии опыта ("да" или "нет").
     * @throws IllegalArgumentException Если информация некорректна.
     */
    public static void validateEmergencyexperience(String hasemergencyexperience) {
        if (!hasemergencyexperience.toLowerCase().matches("^(да|нет)$")) {
            throw new IllegalArgumentException("Вы некорректно указали информацию о наличии опыта" +
                    " студента при работе в экстренных ситуациях");
        }
    }
    /**
     *  Проверяет корректность специализации студента.
     *
     * @param specialization Специализация студента.
     * @throws IllegalArgumentException Если специализация некорректна.
     */
    public static void validateSpecialization(String specialization) {
        if (!specialization.matches("^[А-Яа-яЁё]+$")) {
            throw new IllegalArgumentException("Вы ввели некорректную специализацию");
        }
    }
    /**
     * Проверяет корректность типа обучения студента.
     *
     * @param studytype Тип обучения (теоретик/практик).
     * @throws IllegalArgumentException Если тип обучения некорректен.
     */
    public static void validateStudytype(String studytype) {
        if (!studytype.matches("^(теоретик|практик)$")) {
            throw new IllegalArgumentException("Вы ввели некорректный тип обучения (теоретик или практик)");
        }
    }
    /**
     * Проверяет корректность количества часов практики.
     *
     * @param hours Количество часов практики.
     * @throws IllegalArgumentException Если количество часов меньше 0.
     */
    public static void validateHoursofpractice(int hours) {
        if (hours < 0) {
            throw new IllegalArgumentException("Вы ввели некорректное количество часов практики");
        }
    }
    /**
     * Получает специализацию студента.
     *
     * @return Специализация студента.
     */
    public String getSpecialization() {
        return _specialization;
    }
    /**
     * Устанавливает специализацию студента и проверяет её корректность.
     *
     * @param specialization Специализация студента.
     * @throws IllegalArgumentException Если специализация некорректна.
     */
    public void setSpecialization(String specialization) {
        validateSpecialization(specialization);
        this._specialization = specialization;
    }

    /**
     * Получает тип обучения студента.
     *
     * @return Тип обучения студента.
     */
    public String getStudytype() {
        return _studytype;
    }
    /**
     * Устанавливает тип обучения студента и проверяет его корректность.
     *
     * @param studytype Тип обучения студента.
     * @throws IllegalArgumentException Если тип обучения некорректен.
     */
    public void setStudytype(String studytype) {
        validateStudytype(studytype);
        this._studytype = studytype;
    }
    /**
     * Проверяет наличие доступа к врачебной практике.
     *
     * @return true, если доступ есть; false в противном случае.
     */
    public boolean isHasaccesstopractice() {
        return _hasaccesstopractice;
    }
    /**
     * Устанавливает наличие доступа к врачебной практике и проверяет корректность введенной информации.
     *
     * @param hasaccesstopractice Строка с информацией о наличии доступа ("да" или "нет").
     * @throws IllegalArgumentException Если информация некорректна.
     */
    public void setHasaccesstopractice(String hasaccesstopractice) {
        validateAccesstopractice(hasaccesstopractice);
        this._hasaccesstopractice = hasaccesstopractice.equalsIgnoreCase("да");
    }
    /**
     * Получает количество часов практики.
     *
     * @return Количество часов практики.
     */
    public int getHoursofpractice() {
        return _hoursofpractice;
    }
    /**
     * Устанавливает количество часов практики и проверяет его корректность.
     *
     * @param hoursofpractice Количество часов практики.
     * @throws IllegalArgumentException Если количество часов некорректно.
     */
    public void setHoursofpractice(int hoursofpractice) {
        validateHoursofpractice(hoursofpractice);
        this._hoursofpractice = hoursofpractice;
    }
    /**
     * Проверяет наличие опыта работы в экстренных ситуациях.
     *
     * @return true, если опыт есть; false в противном случае.
     */
    public boolean isHasemergencyexperience() {
        return _hasemergencyexperience;
    }
    /**
     * Устанавливает наличие опыта работы в экстренных ситуациях и проверяет корректность введенной информации.
     *
     * @param hasemergencyexperience Строка с информацией о наличии опыта ("да" или "нет").
     * @throws IllegalArgumentException Если информация некорректна.
     */
    public void setHasemergencyexperience(String hasemergencyexperience) {
        validateEmergencyexperience(hasemergencyexperience);
        this._hasemergencyexperience = hasemergencyexperience.equalsIgnoreCase("да");
    }
    /**
     * Получает информацию о студенте, включая специализацию, тип обучения, доступ к практике,
     * количество часов практики и опыт работы в экстренных ситуациях.
     *
     * @return Строка с информацией о студенте.
     */
    @Override
    public String getInfo() {
        return super.getInfo() +
                "Специализация: " + _specialization + "\n" +
                "Тип обучения: " + _studytype + "\n" +
                "Доступ к практике: " + (_hasaccesstopractice ? "да" : "нет") + "\n" +
                "Количество часов практики: " + _hoursofpractice + "\n" +
                "Опыт работы в экстренных ситуациях: " + (_hasemergencyexperience ? "да" : "нет");
    }

}