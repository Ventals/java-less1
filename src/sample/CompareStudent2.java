package sample;

import java.util.Comparator;

public class CompareStudent2 implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        if(!student1.getGroup().equals(student2.getGroup())){
            return student1.getGroup().compareTo(student2.getGroup());
        }


        if(!student1.getName().equals(student2.getName())){
            return student1.getName().compareTo(student2.getName());
        }

        if (student1.getMark() != student2.getMark()) {
            return (int) (student1.getMark() * 10 - student2.getMark() * 10);
        }

        return 0;
    }
}
