package appProces;

import java.time.LocalDate;

public class Student {

    public static Student[] students = new Student[100];
    private String fullName;
    private int groupNo;
    private int point;
    private int id;
    static int createObjectCount;

    public Student() {
        createObjectCount++;
        id += createObjectCount;
    }

    LocalDate createDate;
    LocalDate updateDate;
    LocalDate deleteDate;


    public void addStudent(Student student) {


    }

    public void updateStudent(Student student) {

    }

    public void deleteStudnet(Student student) {

    }


    public void isDeleteStudent(Student student) {

    }

    public void clacStudentAvarage() {


    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(int groupNo) {
        this.groupNo = groupNo;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", groupNo=" + groupNo +
                ", point=" + point +
                ", id=" + id +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", deleteDate=" + deleteDate +
                '}';
    }
}
