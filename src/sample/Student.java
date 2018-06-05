package sample;

import java.util.Comparator;

public class Student{
    private int id;
    private String name;
    private String group;
    private double mark;

    Student(String line){
        String[] studentArray = line.split(" ");
        this.id = Integer.parseInt(studentArray[0]);
        this.group =studentArray[1];
        this.name =studentArray[2];
        this.mark = Double.parseDouble(studentArray[3]);
    }

    public double getMark() {
        return mark;
    }

    public int getId() {
        return id;
    }

    public String getGroup() {
        return group;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + group + " " + mark;
    }
}
