import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Класс StudentsList управляет списком студентов и предоставляет методы для работы с ними.
 */
public class StudentsList {

    private ArrayList<Student> listofstudents; // Список студентов

    /**
     * Конструктор по умолчанию, инициализирует список студентов.
     */
    public StudentsList() {
        listofstudents = new ArrayList<>();
    }

    /**
     * Добавляет студента в список.
     *
     * @param st Студент, которого нужно добавить в список
     */
    public void addStudent(Student st) {
        listofstudents.add(st); // Добавляет студента в список
    }

    /**
     * Находит студента с максимальным средним баллом (GPA).
     *
     * @return Студент с максимальным GPA или null, если список пуст
     */
    public Student findMaxGpa() {
        if (listofstudents.isEmpty()) {
            return null; // Возвращает null, если список пуст
        }
        Student maxStudent = listofstudents.get(0); // Инициализирует первого студента как максимального
        for (Student i : listofstudents) {
            if (i.getGpa().compareTo(maxStudent.getGpa()) > 0) {
                maxStudent = i; // Обновляет максимального студента, если найден студент с большим GPA
            }
        }
        return maxStudent; // Возвращает студента с максимальным GPA
    }

    /**
     * Получает количество студентов в списке.
     *
     * @return Количество студентов в списке
     */
    public int getSize() {
        return listofstudents.size(); // Возвращает размер списка студентов
    }

    /**
     * Вычисляет среднее количество пропусков среди студентов.
     *
     * @return Среднее количество пропусков
     */
    private BigDecimal countAverageAbsences() {
        BigDecimal count = BigDecimal.ZERO; // Инициализирует счетчик пропусков
        for (Student i : listofstudents) {
            count = count.add(BigDecimal.valueOf(i.getAbsences())); // Суммирует пропуски всех студентов
        }
        return count.divide(BigDecimal.valueOf(listofstudents.size())); // Делит на количество студентов для получения среднего
    }

    /**
     * Подсчитывает количество студентов с количеством пропусков меньше среднего.
     *
     * @return Количество студентов с меньшим количеством пропусков, чем среднее
     */
    public int countLessAvgAbsences() {
        if (listofstudents.isEmpty()) {
            return 0; // Возвращает 0, если список пуст
        }
        int count = 0; // Инициализирует счетчик
        BigDecimal avg = countAverageAbsences(); // Получает среднее количество пропусков
        for (Student i : listofstudents) {
            if (avg.compareTo(new BigDecimal(i.getAbsences())) > 0) {
                count++; // Увеличивает счетчик, если количество пропусков студента меньше среднего
            }
        }
        return count; // Возвращает количество студентов с меньшими пропусками
    }

    /**
     * Находит студента по полному имени.
     *
     * @param name Полное имя студента для поиска
     * @return Студент с указанным именем или null, если студент не найден
     */
    public Student findByName(String name) {
        for (Student i : listofstudents) {
            if (i.getFullname().equals(name)) {
                return i; // Возвращает студента с указанным именем
            }
        }
        return null; // Возвращает null, если студент не найден
    }

    /**
     * Сортирует студентов по полному имени в алфавитном порядке.
     */
    public void sortStudents() {
        if (listofstudents.isEmpty()) {
            return; // Выходит, если список пуст
        }
        boolean swapped;
        for (int i = 0; i < listofstudents.size() - 1; i++) {
            swapped = false;
            for (int j = 0; j < listofstudents.size() - 1 - i; j++) {
                if (listofstudents.get(j).getFullname()
                        .compareTo(listofstudents.get(j + 1).getFullname()) > 0) {
                    Student tmp = listofstudents.get(j);
                    listofstudents.set(j, listofstudents.get(j + 1)); // Меняет местами студентов, если они не в порядке
                    listofstudents.set(j + 1, tmp);
                    swapped = true; // Устанавливает флаг, что произошла замена
                }
            }
            if (!swapped) { // Если не было замен, выходим из цикла
                break;
            }
        }
    }

    /**
     * Получает информацию о всех студентах в виде списка строк.
     *
     * @return Список строк с информацией о каждом студенте
     */
    public ArrayList<String> printInfo() {
        ArrayList<String> fullinfo = new ArrayList<>(); // Инициализирует список для информации о студентах
        for (Student i : listofstudents) {
            fullinfo.add(i.getInfo()); // Добавляет информацию о каждом студенте в список
        }

        return fullinfo; // Возвращает список с информацией о студентах
    }
}
