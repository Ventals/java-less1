package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private static String[] data;
    private static String grour;
    private static String name;
    private static String mark;

    public static void main(String args[]) throws IOException {
       readFile();
       System.out.print(data[0]);
    }
    public static void start(boolean sortBy){
        //if sortBy = true, sorting using Mark/Group/Name

    }
    //public static void main(String[] args) throws IOException {
      //  readFile();
        //writeToFile();
        //more4_5(4.5);
    //}
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
