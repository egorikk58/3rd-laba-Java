import java.math.BigDecimal;

/**
 * Класс Student представляет студента, наследующего от класса Person.
 */
public class Student extends Person {

    protected String _studentID; // Номер зачетной книжки студента
    protected int _yearofstudy; // Курс обучения студента
    protected int _absences; // Количество пропусков студента
    protected BigDecimal _gpa; // Средний балл студента
    protected boolean _hasScholarship; // Наличие стипендии у студента

    /**
     * Конструктор по умолчанию.
     */
    public Student() {
        super();
        _studentID = null;
        _yearofstudy = 0;
        _absences = 0;
        _gpa = BigDecimal.ZERO;
        _hasScholarship = false;
    }

    /**
     * Конструктор с параметрами для создания объекта Student.
     *
     * @param fullname Полное имя студента
     * @param gender Пол студентa
     * @param age Возраст студента
     * @param countryofbirth Страна рождения студента
     * @param phonenumber Номер телефона студента
     * @param studentID Номер зачетной книжки студента
     * @param yearofstudy Курс обучения студента
     * @param absences Количество пропусков студента
     * @param gpa Средний балл студента
     * @param hasScholarship Информация о наличии стипендии ("да" или "нет")
     */
    public Student(String fullname, String gender, int age, String countryofbirth, String phonenumber,
                   String studentID, int yearofstudy, int absences, BigDecimal gpa, String hasScholarship) {
        super(fullname, gender, age, countryofbirth, phonenumber);
        validateStudentID(studentID);
        validateYearofstudy(yearofstudy);
        validateAbsences(absences);
        validateGpa(gpa);
        validateScholarship(hasScholarship);
        this._studentID = studentID;
        this._yearofstudy = yearofstudy;
        this._absences = absences;
        this._gpa = gpa;
        this._hasScholarship = hasScholarship.equalsIgnoreCase("да");
    }

    /**
     * Проверяет корректность номера зачетной книжки.
     *
     * @param studentID Номер зачетной книжки для проверки
     * @throws IllegalArgumentException Если номер зачетной книжки некорректен
     */
    public static void validateStudentID(String studentID) {
        if (studentID.isEmpty() || !studentID.matches("^\\d{2}[А-Яа-яЁё]{2,3}\\d{3}$")) {
            throw new IllegalArgumentException("Вы ввели некорректный номер зачетной книжки");
        }
    }

    /**
     * Проверяет корректность курса обучения.
     *
     * @param year Курс для проверки
     * @throws IllegalArgumentException Если курс некорректен
     */
    public static void validateYearofstudy(int year) {
        if (year > 6 || year <= 0) {
            throw new IllegalArgumentException("Вы ввели некорректный номер курса");
        }
    }

    /**
     * Проверяет корректность количества пропусков.
     *
     * @param absences Количество пропусков для проверки
     * @throws IllegalArgumentException Если количество пропусков отрицательно
     */
    public static void validateAbsences(int absences) {
        if (absences < 0) {
            throw new IllegalArgumentException("Вы ввели некорректное количество пропусков");
        }
    }

    /**
     * Проверяет корректность среднего балла.
     *
     * @param gpa Средний балл для проверки
     * @throws IllegalArgumentException Если средний балл отрицателен
     */
    public static void validateGpa(BigDecimal gpa) {
        if (gpa.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Вы ввели некорректное значение среднего балла");
        }
    }

    /**
     * Проверяет корректность информации о стипендии.
     *
     * @param hasScholarship Информация о стипендии для проверки
     * @throws IllegalArgumentException Если информация о стипендии некорректна
     */
    public static void validateScholarship(String hasScholarship) {
        if (hasScholarship.isEmpty() || !hasScholarship.toLowerCase().matches("^(да|нет)$")) {
            throw new IllegalArgumentException("Вы некорректно указали информацию о стипендии студента");
        }
    }

    // Геттеры и сеттеры

    public String getStudentID() {
        return _studentID; // Возвращает номер зачетной книжки
    }

    public void setStudentID(String studentID) {
        validateStudentID(studentID); // Проверяет корректность номера зачетной книжки перед установкой
        this._studentID = studentID; // Устанавливает номер зачетной книжки
    }

    public int getYearofstudy() {
        return _yearofstudy; // Возвращает курс обучения
    }

    public void setYearofstudy(int yearofstudy) {
        validateYearofstudy(yearofstudy); // Проверяет корректность курса перед установкой
        this._yearofstudy = yearofstudy; // Устанавливает курс обучения
    }

    public int getAbsences() {
        return _absences; // Возвращает количество пропусков
    }

    public void setAbsences(int absences) {
        validateAbsences(absences); // Проверяет корректность количества пропусков перед установкой
        this._absences = absences; // Устанавливает количество пропусков
    }

    public BigDecimal getGpa() {
        return _gpa; // Возвращает средний балл
    }

    public void setGpa(BigDecimal gpa) {
        validateGpa(gpa); // Проверяет корректность среднего балла перед установкой
        this._gpa = gpa; // Устанавливает средний балл
    }

    public boolean isHasScholarship() {
        return _hasScholarship; // Возвращает наличие стипендии
    }

    public void setHasScholarship(String hasScholarship) {
        validateScholarship(hasScholarship); // Проверяет корректность информации о стипендии перед установкой
        this._hasScholarship = hasScholarship.equalsIgnoreCase("да"); // Устанавливает наличие стипендии
    }

    /**
     * Получает информацию о студенте в виде строки.
     *
     * @return Строка с информацией о студенте
     */
    @Override
    public String getInfo() {
        return super.getInfo() + // Получает информацию из родительского класса Person
                "Номер зачетной книжки: " + _studentID + "\n" + // Добавляет номер зачетной книжки к информации
                "Курс: " + _yearofstudy + "\n" + // Добавляет курс обучения к информации
                "Количество пропусков: " + _absences + "\n" + // Добавляет количество пропусков к информации
                "Средний балл: " + _gpa + "\n" + // Добавляет средний балл к информации
                "Есть ли стипендия: " + (_hasScholarship ? "да" : "нет") + "\n"; // Добавляет информацию о наличии стипендии
    }
}
