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

    public BigDecimal findMaxGpa(){
        if(listofstudents.isEmpty()){
            return null;
        }
        BigDecimal max = listofstudents.getFirst().getGpa();
        for(int i=1;i< listofstudents.size();i++){
            if(listofstudents.get(i).getGpa().compareTo(max) > 0){
                max = listofstudents.get(i).getGpa();
            }
        }
        return max;
    }

    private BigDecimal countAverageAbsences(){
        double count = 0;
        for(Student i:listofstudents){
            count += i.getAbsences();
        }
        return new BigDecimal(count/listofstudents.size());
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
}
