import java.math.BigDecimal;

public class Student extends Person{

    protected String _studentID;

    protected int _yearofstudy;

    protected int _absences;

    protected BigDecimal _gpa;

    protected boolean _hasScholarship;

    public Student() {
        super();
        _studentID = null;
        _yearofstudy = 0;
        _absences = 0;
        _gpa = BigDecimal.ZERO;
        _hasScholarship = false;
    }

    public Student(String fullname, String gender, int age, String countryofbirth, String phonenumber,
                   String studentID, int yearofstudy, int absences, BigDecimal gpa, String hasScholarship) {
        super(fullname, gender, age, countryofbirth, phonenumber);
        validateStudentID(studentID);
        validateYearofstudy(yearofstudy);
        validateAbsences(absences);
        validateGpa(gpa);
        validateSchoolarship(hasScholarship);
        this._studentID = studentID;
        this._yearofstudy = yearofstudy;
        this._absences = absences;
        this._gpa = gpa;
        this._hasScholarship = hasScholarship.equalsIgnoreCase("да");
    }

    private void validateStudentID(String studentID){
        if(studentID.isEmpty() || !studentID.matches("^\\d{2}[А-Яа-яЁё]{2,3}\\d{3}$")){
            throw new IllegalArgumentException("Вы ввели некорректный номер зачетной книжки");
        }
    }

    private void validateYearofstudy(int year){
        if(year>6 || year<=0){
            throw new IllegalArgumentException("Вы ввели некорректный номер курса");
        }
    }

    private void validateAbsences(int absences){
        if(absences<0){
            throw new IllegalArgumentException("Вы ввели некорректное количество пропусков");
        }
    }

    private void validateGpa(BigDecimal gpa) {
        if (gpa.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Вы ввели некорректное значение среднего балла");
        }
    }

    private void validateSchoolarship(String hasschoolarship){
        if(hasschoolarship.isEmpty() || !hasschoolarship.toLowerCase().matches("^(да|нет)$")){
            throw new IllegalArgumentException("Вы ввели некорректно указали информацию о стипендии студента");
        }
    }

    public String getStudentID() {
        return _studentID;
    }

    public void setStudentID(String studentID) {
        validateStudentID(studentID);
        this._studentID = studentID;
    }

    public int getYearofstudy() {
        return _yearofstudy;
    }

    public void setYearofstudy(int yearofstudy) {
        validateYearofstudy(yearofstudy);
        this._yearofstudy = yearofstudy;
    }

    public int getAbsences() {
        return _absences;
    }

    public void set_absences(int absences) {
        validateAbsences(absences);
        this._absences = absences;
    }

    public BigDecimal getGpa() {
        return _gpa;
    }

    public void setGpa(BigDecimal gpa) {
        validateGpa(gpa);
        this._gpa = gpa;
    }

    public boolean is_hasScholarship() {
        return _hasScholarship;
    }

    public void setHasScholarship(String hasScholarship) {
        validateSchoolarship(hasScholarship);
        this._hasScholarship = hasScholarship.equalsIgnoreCase("да");
    }
}
