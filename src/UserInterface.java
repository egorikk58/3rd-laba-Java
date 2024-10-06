import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    private Scanner _in;

    public UserInterface(){
        _in = new Scanner(System.in);
    }

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

    public void showCommands(){
        System.out.println("Список команд:");
        System.out.println("'1' - добавить студента");
        System.out.println("'2' - определить студента с максимальным средним баллом");
        System.out.println("'3' - подсчитать количество студентов с посещаемостью меньше среднего");
        System.out.println("'4' - упорядочить список по именам");
        System.out.println("'5' - организовать поиск по ФИО студента для исправления одного из полей");
        System.out.println("'6' - вывести полный список студентов");
    }

    public void getCommand(){
        System.out.println("Выберите команду");
        int n = 0;
        while(true){
            try{
                n = _in.nextInt();
                processCommand(n);
            }catch (InputMismatchException ex){
                System.out.println("Вы ввели некорректную команду");
            }
        }
    }

    public void processCommand(int command){
        switch (command){
            case 1:
                System.out.println("Введите ФИО");
                String fullname;
                while (true){
                    try {
                        fullname = _in.nextLine();
                        Person.validateName(fullname);
                        break;
                    }
                    catch (IllegalArgumentException ex){
                        System.out.println(ex.getMessage());
                        System.out.println("Введите заново");
                    }
                }
                System.out.println("Введите пол (мужской/женский)");
                String gender = "";
                while (true){
                    try {
                        gender = _in.nextLine();
                        Person.validateGender(gender);
                        break;
                    }
                    catch (IllegalArgumentException ex){
                        System.out.println(ex.getMessage());
                        System.out.println("Введите заново");
                    }
                }

        }
    }

    public void run(){
        printInfo();
        showCommands();
        getCommand();
    }
}
