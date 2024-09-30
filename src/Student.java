public class Student {
    private String _Name;
    private String _SurName;
    private String _Patronymic;
    private double _averageGrade;
    private double _attendance;

    public Student(String Name,String SurName, String Patronymic, double averageGrade, double attendance){
        this._Name = Name;
        this._SurName = SurName;
        this._Patronymic = Patronymic;
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
