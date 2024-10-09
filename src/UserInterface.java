import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Consumer;

public class UserInterface {

    private static Scanner _in;

    private StudentsList _sl;
    /**
     * Конструктор по умолчанию, инициализирует сканер и список студентов.
     */
    public UserInterface(){
        _in = new Scanner(System.in);
        _sl = new StudentsList();
    }
    /**
     * Выводит информацию о лабораторной работе, исполнителях и задании.
     */
    public void printInfo(){
        System.out.println("Лабораторная работа 3");
        System.out.println("Выполнили: ст. группы 23ВП2 Андреев Е.Е. Костиневич А.В.");
        System.out.println("Задание:");
        System.out.println("Студенты");
        System.out.println("-определить студента с максимальным средним баллом;");
        System.out.println("-подсчитать количество студентов с посещаемостью меньше среднего;");
        System.out.println("-упорядочить список по именам;");
        System.out.println("-организовать поиск по ФИО студента, исправление одного из полей и" +
                " полной информации о студенте после редактирования.");
    }
    /**
     * Выводит список доступных команд для пользователя.
     */
    public void showCommands(){
        System.out.println("Список команд:");
        System.out.println("'1' - добавить студента");
        System.out.println("'2' - определить студента с максимальным средним баллом");
        System.out.println("'3' - подсчитать количество студентов с посещаемостью меньше среднего");
        System.out.println("'4' - упорядочить список по именам");
        System.out.println("'5' - организовать поиск по ФИО студента для исправления одного из полей");
        System.out.println("'6' - вывести полный список студентов");
        System.out.println("Для выхода из программы введите любой символ," +
                "не являющийся командой");
    }
    /**
     * Запрашивает у пользователя ввод значения типа BigDecimal с валидацией.
     *
     * @param prompt      Сообщение для запроса ввода
     * @param validateFunc Функция для валидации введённого значения
     * @param first       Указывает, является ли это первым вводом
     * @return Введённое значение типа BigDecimal
     */
    private static BigDecimal
    validateInputBigDecimal(String prompt, Consumer<BigDecimal> validateFunc,
                            boolean first){
        String input = "";
        BigDecimal n = BigDecimal.ZERO;
        System.out.println(prompt);
        while(true){
            input = _in.nextLine();
            try {
                if(first){
                    first = false;
                    continue;
                }
                n = new BigDecimal(input);
                validateFunc.accept(n);
                break;
            }catch (NumberFormatException ex){
                System.out.println
                        ("Значение должно быть целым или вещественным числом");
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
        }
        return n;
    }
    /**
     * Запрашивает у пользователя ввод строки с валидацией.
     *
     * @param prompt      Сообщение для запроса ввода
     * @param validateFunc Функция для валидации введённого значения
     * @param first       Указывает, является ли это первым вводом
     * @return Введённое значение типа String
     */
    private static String
    validateInputString(String prompt, Consumer<String> validateFunc,
                        boolean first){
        String input ="";
        System.out.println(prompt);
        while(true){
            input = _in.nextLine();
            try {
                if(first){
                    first = false;
                    continue;
                }
                validateFunc.accept(input);
                break;
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
        }
        return input;
    }
    /**
     * Запрашивает у пользователя ввод целого числа с валидацией.
     *
     * @param prompt      Сообщение для запроса ввода
     * @param validateFunc Функция для валидации введённого значения
     * @param first       Указывает, является ли это первым вводом
     * @return Введённое значение типа int
     */
    private static int
    validateInputInt(String prompt, Consumer<Integer> validateFunc, boolean first){
        String input = "";
        int n = 0;
        System.out.println(prompt);
        while(true){
            input = _in.nextLine();
            try {
                if(first){
                    first = false;
                    continue;
                }
                n = Integer.parseInt(input);
                validateFunc.accept(n);
                break;
            }catch (NumberFormatException ex){
                System.out.println("Значение должно быть целым числом");
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
        }
        return n;
    }
    /**
     * Запрашивает у пользователя ввод команды и обрабатывает её.
     */
    public void getCommand(){
        System.out.println("Выберите команду");
        int n = 0;
        while(true){
            try{
                n = _in.nextInt();
                processCommand(n);
            }catch (InputMismatchException ex){
                System.out.println("Работа завершена");
                break;
            }
        }
    }

    /**
     * Обрабатывает введённую команду.
     *
     * @param command номер команды
     */
    public void processCommand(int command) {
        switch (command) {
            case 1:
                String fullname = validateInputString(
                        "Введите имя",
                        Person::validateName,
                        true
                );
                String gender = validateInputString(
                        "Введите пол (мужской/женский)",
                        Person::validateGender,
                        false
                );
                int age = validateInputInt(
                        "Введите возраст",
                        Person::validateAge,
                        false
                );
                String country = validateInputString(
                        "Введите страну рождения",
                        Person::validateCountry,
                        false
                );
                String phonenumber = validateInputString(
                        "Введите номер телефона",
                        Person::validatePhone,
                        false
                );
                String studentid = validateInputString(
                        "Введите номер зачетной книжки",
                        Student::validateStudentID,
                        false
                );
                int yearsofstudy = validateInputInt(
                        "Введите курс",
                        Student::validateYearofstudy,
                        false
                );
                int absences = validateInputInt(
                        "Введите количество пропусков",
                        Student::validateAbsences,
                        false
                );
                BigDecimal gpa = validateInputBigDecimal(
                        "Введите средний балл",
                        Student::validateGpa,
                        false
                );
                String scholarship = validateInputString(
                        "Имеет ли студент стипендию (да/нет)",
                        Student::validateScholarship,
                        false
                );
                System.out.println("Введите специальность (медик/инженер/филолог)");
                String spec = "";
                while (true){
                    spec = _in.nextLine().toLowerCase();
                    if(spec.matches("^(медик|инженер|филолог)$")){
                        break;
                    }else{
                        System.out.println("Введите одну из предложенных специальностей");
                    }
                }
                switch (spec){
                    case "медик":
                        String specialization = validateInputString(
                                "Введите врачебную специализацию",
                                MedicalStudent::validateSpecialization,
                                false
                        );
                        String studytype = validateInputString(
                                "Введите направление (теоретик/практик)",
                                MedicalStudent::validateStudytype,
                                false
                        );
                        String hasaccesstopractice = validateInputString(
                                "Введите, имеет ли студент доступ к врачебной практике (да/нет)",
                                MedicalStudent::validateAccesstopractice,
                                false
                        );
                        int hoursofpractice = validateInputInt(
                                "Введите количество часов, которое студент отработал в больнице",
                                MedicalStudent::validateHoursofpractice,
                                false
                        );
                        String emergencyexp = validateInputString(
                                "Укажите, имеет ли студент опыт работы в экстренных ситуациях (да/нет)",
                                MedicalStudent::validateEmergencyexperience,
                                false
                        );
                        MedicalStudent md = new MedicalStudent(
                                fullname,gender,age,country,phonenumber,studentid,
                                yearsofstudy,absences,gpa,scholarship,specialization,
                                studytype,hasaccesstopractice,hoursofpractice,emergencyexp);
                        _sl.addStudent(md);
                        break;
                    case "филолог":
                        String studiedLanguage = validateInputString(
                                "Введите изучаемый язык (латинский, древнегреческий и т.д.)",
                                PhilologyStudent::validateStudiedLanguage,
                                false
                        );
                        String literarySpecialization = validateInputString(
                                "Введите литературную специализацию (эпоха, жанр и т.д.)",
                                PhilologyStudent::validateLiterarySpecialization,
                                false
                        );
                        String textSpecialization = validateInputString(
                                "Введите специализацию на типах текстов" +
                                        " (художественные/технические/научные/публицистические)",
                                PhilologyStudent::validateTextSpecialization,
                                false
                        );
                        String thesisTopic = validateInputString(
                                "Введите тему итоговой работы",
                                PhilologyStudent::validateThesisTopic,
                                false
                        );
                        String hasRareLanguageKnowledge = validateInputString(
                                "Укажите, есть ли у студента знания редких языков (да/нет)",
                                PhilologyStudent::validateRareLanguageKnowledge,
                                false
                        );
                        PhilologyStudent ps = new PhilologyStudent(
                                fullname,gender,age,country,phonenumber,studentid,
                                yearsofstudy,absences,gpa,scholarship,studiedLanguage,
                                literarySpecialization, textSpecialization,
                                thesisTopic, hasRareLanguageKnowledge
                        );
                        _sl.addStudent(ps);
                        break;
                    case "инженер":
                        String engineeringField = validateInputString(
                                "Введите инженерное направление" +
                                        " (механика, электроника, строительная инженерия и т.д.)",
                                EngineeringStudent::validateEngineeringField,
                                false
                        );
                        String projectSpecialization = validateInputString(
                                "Введите специализацию на типах проектов" +
                                        " (строительные/программные/промышленные/электротехнические)",
                                EngineeringStudent::validateProjectSpecialization,
                                false
                        );
                        String finalProjectTopic = validateInputString(
                                "Введите тему итогового проекта",
                                EngineeringStudent::validateFinalProjectTopic,
                                false
                        );
                        int hoursOfLabWork = validateInputInt(
                                "Введите количество часов лабораторной работы",
                                EngineeringStudent::validateHoursOfLabWork,
                                false
                        );
                        String hasInternshipExperience = validateInputString(
                                "Укажите, есть ли у студента опыт прохождения стажировки (да/нет)",
                                EngineeringStudent::validateInternshipExperience,
                                false
                        );
                        EngineeringStudent es = new EngineeringStudent(
                                fullname,gender,age,country,phonenumber,studentid,
                                yearsofstudy,absences,gpa,scholarship, engineeringField,
                                projectSpecialization, finalProjectTopic, hoursOfLabWork,
                                hasInternshipExperience
                        );
                        _sl.addStudent(es);
                        break;
                    default:
                        System.out.println("Произошла ошибка");
                        break;
                }
                System.out.println("Новый студент добавлен");
                showCommands();
                break;
            case 2:
                if(_sl.findMaxGpa() == null){
                    System.out.println("Список студентов пуст");
                    return;
                }
                System.out.println("Студет с наибольшим средним баллом");
                System.out.println(_sl.findMaxGpa().getFullname());
                System.out.println("Его средний балл");
                System.out.println(_sl.findMaxGpa().getGpa());
                showCommands();
                break;
            case 3:
                System.out.println("Количество студентов с посещаемостью ниже среднего");
                System.out.println(_sl.countLessAvgAbsences());
                break;
            case 4:
                if(_sl.getSize() == 0){
                    System.out.println("Список студентов пуст");
                    return;
                }
                _sl.sortStudents();
                System.out.println("Список студентов упорядочен");
                System.out.println("Введите '6', чтобы его просмотреть");
                break;
            case 5:
                String name = validateInputString(
                        "Введите ФИО для поиска",
                        Person::validateName,
                        true
                );
                Student foundst = _sl.findByName(name);
                if (foundst == null){
                    System.out.println("Студент не найден");
                    return;
                }else{
                    System.out.println("Выберите, какое поле хотите изменить");
                    System.out.println("'1' - ФИО");
                    System.out.println("'2' - пол");
                    System.out.println("'3' - возраст");
                    System.out.println("'4' - страна рождения");
                    System.out.println("'5' - номер телефона");
                    System.out.println("'6' - номер зачетной книжки");
                    System.out.println("'7' - курс");
                    System.out.println("'8' - количество пропусков");
                    System.out.println("'9' - средний балл");
                    System.out.println("'10' - наличие стипендии");
                    if(foundst instanceof MedicalStudent){
                        System.out.println("'11' - специализация");
                        System.out.println("'12' - тип обучения");
                        System.out.println("'13' - доступ к практике");
                        System.out.println("'14' - количество часов практики");
                        System.out.println("'15' - опыт работы в экстренных ситуациях");
                    } else if (foundst instanceof PhilologyStudent) {
                        System.out.println("'11' - изучаемый язык");
                        System.out.println("'12' - литературная специализация");
                        System.out.println("'13' - специализация на типах текстов");
                        System.out.println("'14' - тема итоговой работы");
                        System.out.println("'15' - знания редких или мёртвых языков");
                    } else if (foundst instanceof EngineeringStudent) {
                        System.out.println("'11' - инженерное направление");
                        System.out.println("'12' - специализация на типах проектов");
                        System.out.println("'13' - тема итогового проекта");
                        System.out.println("'14' - количество часов лабораторной работы");
                        System.out.println("'15' - опыт прохождения стажировки");
                    }
                    System.out.println("Для выхода введите любую другую последовательность");
                    int changecommand = 0;
                    try {
                        String inp = _in.nextLine();
                        changecommand = Integer.parseInt(inp);
                    }catch (NumberFormatException ex){
                        return;
                    }
                    switch (changecommand){
                        case 1:
                            String newname = validateInputString(
                                "Введите ФИО",
                                Person::validateName,
                                true
                            );
                            foundst.setName(newname);
                            break;
                        case 2:
                            String newgender = validateInputString(
                                    "Введите пол",
                                    Person::validateGender,
                                    false
                            );
                            break;
                        case 3:
                            int newage = validateInputInt(
                                    "Введите возраст",
                                    Person::validateAge,
                                    false
                            );
                            foundst.setAge(newage);
                            break;
                        case 4:
                            String newcountry = validateInputString(
                                    "Введите страну рождения",
                                    Person::validateCountry,
                                    false
                            );
                            foundst.setCountryofbirth(newcountry);
                            break;
                        case 5:
                            String newphone = validateInputString(
                                    "Введите номер телефона",
                                    Person::validatePhone,
                                    false
                            );
                            foundst.setPhonenumber(newphone);
                            break;
                        case 6:
                            String newStudentID = validateInputString(
                                    "Введите номер зачетной книжки",
                                    Student::validateStudentID,
                                    false
                            );
                            foundst.setStudentID(newStudentID);
                            break;
                        case 7:
                            int newYearOfStudy = validateInputInt(
                                    "Введите курс",
                                    Student::validateYearofstudy,
                                    false
                            );
                            foundst.setYearofstudy(newYearOfStudy);
                            break;
                        case 8:
                            int newAbsences = validateInputInt(
                                    "Введите количество пропусков",
                                    Student::validateAbsences,
                                    false
                            );
                            foundst.setAbsences(newAbsences);
                            break;
                        case 9:
                            BigDecimal newGpa = validateInputBigDecimal(
                                    "Введите средний балл",
                                    Student::validateGpa,
                                    false
                            );
                            foundst.setGpa(newGpa);
                            break;
                        case 10:
                            String newHasScholarship = validateInputString(
                                    "Есть ли стипендия? (да/нет)",
                                    Student::validateScholarship,
                                    false
                            );
                            foundst.setHasScholarship(newHasScholarship);
                            break;
                        case 11:
                            if(foundst instanceof MedicalStudent){
                                String newspec = validateInputString(
                                        "Введите специализацию",
                                        MedicalStudent::validateSpecialization,
                                        false
                                );
                                ((MedicalStudent) foundst).setSpecialization(newspec);
                            } else if (foundst instanceof PhilologyStudent) {
                                String newlang = validateInputString(
                                        "Введите изучаемый язык",
                                        PhilologyStudent::validateStudiedLanguage,
                                        false
                                );
                                ((PhilologyStudent) foundst).setStudiedLanguage(newlang);
                            } else if (foundst instanceof EngineeringStudent) {
                                String newfield = validateInputString(
                                        "Введите инженерное направление",
                                        EngineeringStudent::validateEngineeringField,
                                        false
                                );
                                ((EngineeringStudent) foundst).setEngineeringField(newfield);
                            }
                            break;
                        case 12:
                            if (foundst instanceof MedicalStudent) {
                                String newStudyType = validateInputString(
                                        "Введите тип обучения (теоретик/практик)",
                                        MedicalStudent::validateStudytype,
                                        false
                                );
                                ((MedicalStudent) foundst).setStudytype(newStudyType);
                            } else if (foundst instanceof PhilologyStudent) {
                                String newLiterarySpecialization = validateInputString(
                                        "Введите литературную специализацию",
                                        PhilologyStudent::validateLiterarySpecialization,
                                        false
                                );
                                ((PhilologyStudent) foundst).setLiterarySpecialization(newLiterarySpecialization);
                            } else if (foundst instanceof EngineeringStudent) {
                                String newProjectSpecialization = validateInputString(
                                        "Введите специализацию на типах проектов",
                                        EngineeringStudent::validateProjectSpecialization,
                                        false
                                );
                                ((EngineeringStudent) foundst).setProjectSpecialization(newProjectSpecialization);
                            }
                            break;
                        case 13:
                            if (foundst instanceof MedicalStudent) {
                                String newHasAccessToPractice = validateInputString(
                                        "Есть ли доступ к практике? (да/нет)",
                                        MedicalStudent::validateAccesstopractice,
                                        false
                                );
                                ((MedicalStudent) foundst).setHasaccesstopractice(newHasAccessToPractice);
                            } else if (foundst instanceof PhilologyStudent) {
                                String newSpecializationOnText = validateInputString(
                                        "Введите тему итогового проекта",
                                        PhilologyStudent::validateTextSpecialization,
                                        false
                                );
                                ((PhilologyStudent) foundst).setTextSpecialization(newSpecializationOnText);
                            } else if (foundst instanceof EngineeringStudent) {
                                String newProjectSpecialization = validateInputString(
                                        "Введите специализацию на типах проектов",
                                        EngineeringStudent::validateFinalProjectTopic,
                                        false
                                );
                                ((EngineeringStudent) foundst).setFinalProjectTopic(newProjectSpecialization);
                            }
                            break;
                        case 14:
                            if (foundst instanceof MedicalStudent) {
                                int newPracticeHours = validateInputInt(
                                        "Введите количество часов, отработанных в больнице",
                                        MedicalStudent::validateHoursofpractice,
                                        false
                                );
                                ((MedicalStudent) foundst).setHoursofpractice(newPracticeHours);
                            } else if (foundst instanceof PhilologyStudent) {
                                String newThesisTopic = validateInputString(
                                        "Введите тему итоговой работы",
                                        PhilologyStudent::validateThesisTopic,
                                        false
                                );
                                ((PhilologyStudent) foundst).setThesisTopic(newThesisTopic);
                            } else if (foundst instanceof EngineeringStudent) {
                                int newHoursOfLabWork = validateInputInt(
                                        "Введите количество часов лабораторной работы",
                                        EngineeringStudent::validateHoursOfLabWork,
                                        false
                                );
                                ((EngineeringStudent) foundst).setHoursOfLabWork(newHoursOfLabWork);
                            }
                            break;
                        case 15:
                            if (foundst instanceof MedicalStudent) {
                                String newEmergencyExp = validateInputString(
                                        "Укажите, имеет ли студент опыт работы в экстренных ситуациях",
                                        MedicalStudent::validateEmergencyexperience,
                                        false
                                );
                                ((MedicalStudent) foundst).setHasemergencyexperience(newEmergencyExp);
                            } else if (foundst instanceof PhilologyStudent) {
                                String newRareLang = validateInputString(
                                        "Укажите, знает ли студент редкие/мертвые языки (да/нет)",
                                        PhilologyStudent::validateRareLanguageKnowledge,
                                        false
                                );
                                ((PhilologyStudent) foundst).setHasRareLanguageKnowledge(newRareLang);
                            } else if (foundst instanceof EngineeringStudent) {
                                String newIntershipExp = validateInputString(
                                        "Укажите, проходил ли студент стажировки",
                                        EngineeringStudent::validateInternshipExperience,
                                        false
                                );
                                ((EngineeringStudent) foundst).setHasInternshipExperience(newIntershipExp);
                            }
                            break;
                        default:
                            System.out.println("Выход");
                            return;
                    }
                    System.out.println("Информация о студенте");
                    System.out.println(foundst.getInfo());
                }
                break;
            case 6:
                if(_sl.printInfo().isEmpty()){
                    System.out.println("Список пуст");
                    return;
                }
                for(String i: _sl.printInfo()){
                    System.out.println("====================");
                    System.out.println(i);
                    System.out.println("====================");
                }
                break;
        }
    }

    /**
     * Запускает интерфейс пользователя.
     * Вызывает методы для отображения информации, команд и обработки ввода пользователя.
     */
    public void run() {
        printInfo();    // Выводит информацию о программе или пользователе
        showCommands(); // Отображает доступные команды для пользователя
        getCommand();   // Запрашивает и обрабатывает ввод команды от пользователя
    }
}
