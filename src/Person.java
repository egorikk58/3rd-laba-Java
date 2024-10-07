import java.util.ArrayList;
import java.util.Arrays;

public abstract class Person {

    protected String _fullname;

    protected String _gender;

    protected int _age;

    protected String _countryofbirth;

    protected String _phonenumber;

    public Person(){
        this._fullname = null;
        this._gender = null;
        this._age = 0;
        this._countryofbirth = null;
        this._phonenumber = null;
    }

    public Person(String fullname, String gender, int age, String countryofbirth, String phonenumber){
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

    public static void validateName(String fullname) {
        if (!fullname.matches("^[А-Яа-яЁё]+(\\s[А-Яа-яЁё]+){2}$")) {
            throw new IllegalArgumentException("Вы ввели некорректное имя");
        }
    }

    public static void validateGender(String gender) {
        if (!gender.toLowerCase().matches("^(мужской|женский)$")) {
            throw new IllegalArgumentException("Вы ввели неверный пол");
        }
    }

    public static void validateAge(int age) {
        if (age <= 0 || age > 122) {
            throw new IllegalArgumentException("Вы ввели некорректный возраст");
        }
    }

    public static void validateCountry(String country) {
        if (!country.matches("^[А-Яа-яЁё-]+(\\s[А-Яа-яЁё-]+)*$")) {
            throw new IllegalArgumentException("Вы ввели некорректную страну");
        }
    }

    public static void validatePhone(String number) {
        if (!number.matches("(^\\+7\\d{10}$)|(^\\+7\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$)|" +
                "(^8\\d{10}$)|(^8\\(\\d{3}\\)\\d{7}$)")) {
            throw new IllegalArgumentException("Вы ввели некорректный номер");
        }
    }

    public void setName(String newName){
        validateName(newName);
        this._fullname = newName;
    }

    public void setGender(String newGender){
        validateGender(newGender);
        this._gender = newGender;
    }

    public void setAge(int newAge){
        validateAge(newAge);
        this._age = newAge;
    }

    public void setCountryofbirth(String newCountry){
        validateCountry(newCountry);
        this._countryofbirth = newCountry;
    }

    public void setPhonenumber(String newNumber){
        validatePhone(newNumber);
        this._phonenumber = newNumber;
    }

    public String getFullname() {
        return _fullname;
    }

    public String getGender() {
        return _gender;
    }

    public int getAge() {
        return _age;
    }

    public String getCountryofbirth() {
        return _countryofbirth;
    }

    public String getPhonenumber() {
        return _phonenumber;
    }
}
