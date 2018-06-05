package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Controller {
    static Comparator comparator;
    public static void sorting() throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("input/student_list.txt"));
        ArrayList<Student> students = new ArrayList<Student>();
           String line="";
                while((line=reader.readLine())!=null){
                    Student student = parseStudentFromLine(line);
                        if(student!=null)
                             students.add(student);
                }
           reader.close();
           students.sort(comparator);

        FileWriter writer = new FileWriter("output/res.txt");
        for(Student student : students){
            writer.write(student.toString());
            writer.write('\n');
        }
        writer.close();
    }

    private static Student parseStudentFromLine(String line) {
        return new Student(line);
    }

    public static void start(boolean sortBy) throws Exception {
        //if sortBy = true, sorting using Mark/Group/Name
        if (sortBy) {
            comparator = new CompareStudent();
        }else {
            comparator = new CompareStudent2();
        }
        sorting();
    }
}
