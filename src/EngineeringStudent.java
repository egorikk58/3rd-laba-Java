import java.math.BigDecimal;

public class EngineeringStudent extends Student {

    private String _engineeringField; // инженерное направление (механика, электроника, строительная инженерия и т.д.)

    private String _projectSpecialization; // специализация на типах проектов (строительные, программные, промышленные и т.д.)

    private String _finalProjectTopic; // тема итогового проекта

    private int _hoursOfLabWork; // количество часов лабораторной работы

    private boolean _hasInternshipExperience; // наличие опыта стажировки

    public EngineeringStudent() {
        super();
        _engineeringField = null;
        _projectSpecialization = null;
        _finalProjectTopic = null;
        _hoursOfLabWork = 0;
        _hasInternshipExperience = false;
    }

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

    public static void validateEngineeringField(String engineeringField) {
        if (!engineeringField.matches("^[А-Яа-яЁё\\s]+$")) {
            throw new IllegalArgumentException("Вы ввели некорректное инженерное направление");
        }
    }

    public static void validateProjectSpecialization(String projectSpecialization) {
        if (!projectSpecialization.matches("^(строительные|программные|промышленные|электротехнические)$")) {
            throw new IllegalArgumentException("Вы ввели некорректную специализацию на типах проектов");
        }
    }

    public static void validateFinalProjectTopic(String finalProjectTopic) {
        if (!finalProjectTopic.matches("^[А-Яа-яЁё\\s]+$")) {
            throw new IllegalArgumentException("Вы ввели некорректную тему выпускного проекта");
        }
    }

    public static void validateHoursOfLabWork(int hoursOfLabWork) {
        if (hoursOfLabWork < 0) {
            throw new IllegalArgumentException("Вы ввели некорректное число часов лабораторной работы");
        }
    }

    public static void validateInternshipExperience(String hasInternshipExperience) {
        if (!hasInternshipExperience.toLowerCase().matches("^(да|нет)$")) {
            throw new IllegalArgumentException("Вы некорректно указали наличие опыта стажировки");
        }
    }


    public String getEngineeringField() {
        return _engineeringField;
    }

    public void setEngineeringField(String engineeringField) {
        validateEngineeringField(engineeringField);
        this._engineeringField = engineeringField;
    }

    public String getProjectSpecialization() {
        return _projectSpecialization;
    }

    public void setProjectSpecialization(String projectSpecialization) {
        validateProjectSpecialization(projectSpecialization);
        this._projectSpecialization = projectSpecialization;
    }

    public String getFinalProjectTopic() {
        return _finalProjectTopic;
    }

    public void setFinalProjectTopic(String finalProjectTopic) {
        validateFinalProjectTopic(finalProjectTopic);
        this._finalProjectTopic = finalProjectTopic;
    }

    public int getHoursOfLabWork() {
        return _hoursOfLabWork;
    }

    public void setHoursOfLabWork(int hoursOfLabWork) {
        validateHoursOfLabWork(hoursOfLabWork);
        this._hoursOfLabWork = hoursOfLabWork;
    }

    public boolean isHasInternshipExperience() {
        return _hasInternshipExperience;
    }

    public void setHasInternshipExperience(String hasInternshipExperience) {
        validateInternshipExperience(hasInternshipExperience);
        this._hasInternshipExperience = hasInternshipExperience.equalsIgnoreCase("да");
    }

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
