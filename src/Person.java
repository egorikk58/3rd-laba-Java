public abstract class Person {

    protected String _fullname; // Полное имя
    protected String _gender; // Пол
    protected int _age; // Возраст
    protected String _countryofbirth; // Страна рождения
    protected String _phonenumber; // Номер телефона

    /**
     * Конструктор без параметров, инициализирует поля значениями по умолчанию.
     */
    public Person() {
        this._fullname = null;
        this._gender = null;
        this._age = 0;
        this._countryofbirth = null;
        this._phonenumber = null;
    }

    /**
     * Конструктор с параметрами для инициализации полей класса.
     *
     * @param fullname       Полное имя.
     * @param gender         Пол.
     * @param age            Возраст.
     * @param countryofbirth Страна рождения.
     * @param phonenumber    Номер телефона.
     * @throws IllegalArgumentException Если переданы некорректные значения.
     */
    public Person(String fullname, String gender, int age, String countryofbirth, String phonenumber) {
        validateName(fullname);
        validateGender(gender);
        validateAge(age);
        validateCountry(countryofbirth);
        validatePhone(phonenumber);
        this._fullname = fullname;
        this._gender = gender;
        this._age = age;
        this._countryofbirth = countryofbirth;
        this._phonenumber = phonenumber;
    }

    /**
     * Проверяет корректность полного имени.
     *
     * @param fullname Полное имя.
     * @throws IllegalArgumentException Если имя некорректно.
     */
    public static void validateName(String fullname) {
        if (!fullname.matches("^[А-Яа-яЁё]+(\\s[А-Яа-яЁё]+){2}$")) {
            throw new IllegalArgumentException("Вы ввели некорректное имя");
        }
    }

    /**
     * Проверяет корректность пола.
     *
     * @param gender Пол.
     * @throws IllegalArgumentException Если пол некорректен.
     */
    public static void validateGender(String gender) {
        if (!gender.toLowerCase().matches("^(мужской|женский)$")) {
            throw new IllegalArgumentException("Вы ввели неверный пол");
        }
    }

    /**
     * Проверяет корректность возраста.
     *
     * @param age Возраст.
     * @throws IllegalArgumentException Если возраст некорректен.
     */
    public static void validateAge(int age) {
        if (age <= 1 || age > 122) {
            throw new IllegalArgumentException("Вы ввели некорректный возраст");
        }
    }

    /**
     * Проверяет корректность страны рождения.
     *
     * @param country Страна рождения.
     * @throws IllegalArgumentException Если страна некорректна.
     */
    public static void validateCountry(String country) {
        if (!country.matches("^[А-Яа-яЁё-]+(\\s[А-Яа-яЁё-]+)*$")) {
            throw new IllegalArgumentException("Вы ввели некорректную страну");
        }
    }

    /**
     * Проверяет корректность номера телефона.
     *
     * @param number Номер телефона.
     * @throws IllegalArgumentException Если номер некорректен.
     */
    public static void validatePhone(String number) {
        if (!number.matches("(^\\+7\\d{10}$)|(^\\+7\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$)|" +
                "(^8\\d{10}$)|(^8\\(\\d{3}\\)\\d{7}$)")) {
            throw new IllegalArgumentException("Вы ввели некорректный номер");
        }
    }

    /**
     * Устанавливает новое полное имя после проверки корректности.
     *
     * @param newName Новое полное имя.
     * @throws IllegalArgumentException Если имя некорректно.
     */
    public void setName(String newName) {
        validateName(newName);
        this._fullname = newName;
    }

    /**
     * Устанавливает новый пол после проверки корректности.
     *
     * @param newGender Новый пол.
     * @throws IllegalArgumentException Если пол некорректен.
     */
    public void setGender(String newGender) {
        validateGender(newGender);
        this._gender = newGender;
    }

    /** Устанавливает новый возраст после проверки корректности.
     *
     * @param newAge Новый возраст.
     * @throws IllegalArgumentException Если возраст некорректен.
     **/
    public void setAge(int newAge) {
        validateAge(newAge);
        this._age = newAge;
    }

    /**
     * Устанавливает новую страну рождения после проверки корректности.
     *
     * @param newCountry Новая страна рождения.
     * @throws IllegalArgumentException Если страна некорректна.
     */
    public void setCountryofbirth(String newCountry) {
        validateCountry(newCountry);
        this._countryofbirth = newCountry;
    }

    /**
     * Устанавливает новый номер телефона после проверки корректности.
     *
     * @param newNumber Новый номер телефона.
     * @throws IllegalArgumentException Если номер некорректен.
     */
    public void setPhonenumber(String newNumber) {
        validatePhone(newNumber);
        this._phonenumber = newNumber;
    }

    /**
     * Получает полное имя человека.
     *
     * @return Полное имя.
     */
    public String getFullname() {
        return _fullname;
    }

    /**
     * Получает пол человека.
     *
     * @return Пол.
     */
    public String getGender() {
        return _gender;
    }

    /**
     * Получает возраст человека.
     *
     * @return Возраст.
     */
    public int getAge() {
        return _age;
    }

    /**
     * Получает страну рождения человека.
     *
     * @return Страна рождения.
     */
    public String getCountryofbirth() {
        return _countryofbirth;
    }

    /**
     * Получает номер телефона человека.
     *
     * @return Номер телефона.
     */
    public String getPhonenumber() {
        return _phonenumber;
    }

    /**
     * Получает информацию о человеке в виде строки.
     *
     * @return Строка с информацией о человеке.
     */
    public String getInfo() {
        return "ФИО: " + _fullname + "\n" +
                "Пол: " + _gender + "\n" +
                "Возраст: " + _age + "\n" +
                "Страна рождения: " + _countryofbirth + "\n" +
                "Номер телефона: " + _phonenumber + "\n";
    }
}

