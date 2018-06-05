package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Controller {
    private static String[] data;
    private static String[] line;
    private static String grour;
    private static String name;
    private static double mark;
    private static int id;

//    public static void main(String args[]) throws IOException {
//       readFile();
//       start(true);
//    }
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("input/student_list.txt"));
        ArrayList<Student> students = new ArrayList<Student>();
           String line="";
                while((line=reader.readLine())!=null){
                    Student student = parseStudentFromLine(line);
                        if(student!=null)
                             students.add(student);
                }
           reader.close();
                CompareStudent comparator = new CompareStudent();
          students.sort(comparator);

        FileWriter writer = new FileWriter("output/res1.txt");
        for(Student student : students){
            writer.write(student.toString());
            writer.write('\n');
        }
        writer.close();
    }

    private static Student parseStudentFromLine(String line) {
        return new Student(line);
    }

    private static String getField(String line) {
        return line.split(" ")[2];//extract value you want to sort on
    }
    public static void start(boolean sortBy){
        //if sortBy = true, sorting using Mark/Group/Name
        for(int index = 0; index < data.length; index++){
            line = data[index].split(" ");
            id = Integer.parseInt(line[0]);
            grour = line[1];
            name = line[2];
            mark = Double.parseDouble(line[3]);
        }

    }
    public static void readFile() throws IOException {
        BufferedReader abc = new BufferedReader(new FileReader("input/student_list.txt"));
        List<String> lines = new ArrayList<>();

        String line;
        while((line = abc.readLine()) != null) {
            lines.add(line);
        }
        abc.close();

        data = lines.toArray(new String[]{});
    }

    private static boolean more4_5(double mark){
        boolean res = false;
        if (mark >= 4.5){
            res = true;
        }
        return res;
    }
    private boolean centralMarks(double mark){
        boolean res = false;
        if (mark >= 4.0 && mark <= 4.4){
            res = true;
        }
        return res;
    }
    private boolean less4(double mark){
        boolean res = false;
        if (mark < 4.0){
            res = true;
        }
        return res;
    }

    public static void writeToFile(String fileName, String content) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("output/" + fileName, "UTF-8");
        writer.println(content);
        writer.close();
    }

    private void sortForMark(){}
    private void sortForGroup(){}


}
