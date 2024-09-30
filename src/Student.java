public class Student extends Person{

    private double _averageGrade;
    private double _attendance;

    public Student(String Name,String SurName, String Patronymic, double averageGrade, double attendance){
        super(Name,SurName,Patronymic);
        this._averageGrade = averageGrade;
        this._attendance = attendance;
    }

    public String getFullName(){
        return _Name + " " + _SurName + " " + _Patronymic;
    }
    public double get_averageGrade() {
        return _averageGrade;
    }

    public double get_attendance() {
        return _attendance;
    }
}
