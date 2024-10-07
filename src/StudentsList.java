import java.math.BigDecimal;
import java.util.ArrayList;

public class StudentsList {

    private ArrayList<Student> listofstudents;

    public StudentsList(){
        listofstudents = new ArrayList<>();
    }

    public void addStudent(Student st){
        listofstudents.add(st);
    }

    public Student findMaxGpa() {
        if (listofstudents.isEmpty()) {
            return null;
        }
        Student maxStudent = listofstudents.get(0);
        for (Student i : listofstudents) {
            if (i.getGpa().compareTo(maxStudent.getGpa()) > 0) {
                maxStudent = i;
            }
        }
        return maxStudent;
    }

    public int getSize(){
        return listofstudents.size();
    }


    private BigDecimal countAverageAbsences(){
        BigDecimal count = BigDecimal.ZERO;
        for(Student i:listofstudents){
            count = count.add(BigDecimal.valueOf(i.getAbsences()));
        }
        return count.divide(BigDecimal.valueOf(listofstudents.size()));
    }

    public int countLessAvgAbsences(){
        if(listofstudents.isEmpty()){
            return 0;
        }
        int count = 0;
        BigDecimal avg = countAverageAbsences();
        for(Student i:listofstudents){
            if(avg.compareTo(new BigDecimal(i.getAbsences()))>0){
                count++;
            }
        }
        return count;
    }

    public Student findByName(String name){
        for (Student i : listofstudents) {
            if (i.getFullname().equals(name)) {
                return i;
            }
        }
        return null;
    }
    
    public void sortStudents() {
        if(listofstudents.isEmpty()){
            return;
        }
        boolean swapped;
        for (int i = 0; i < listofstudents.size() - 1; i++) {
            swapped = false;
            for (int j = 0; j < listofstudents.size() - 1 - i; j++) {
                if (listofstudents.get(j).getFullname()
                        .compareTo(listofstudents.get(j + 1).getFullname()) > 0) {
                    Student tmp = listofstudents.get(j);
                    listofstudents.set(j, listofstudents.get(j + 1));
                    listofstudents.set(j + 1, tmp);
                    swapped = true;
                }
            }
            if (!swapped){
                break;
            }
        }
    }

    public ArrayList<String> printInfo(){
        ArrayList<String> fullinfo = new ArrayList<>();
        for(Student i:listofstudents){
            fullinfo.add(i.getInfo());
        }

        return fullinfo;
    }
}
