package appProces;

import java.time.LocalDate;

public class Student {

    public static Student[] students = new Student[100];

    private String fullName;
    private String groupNo;
    private int point;
    private int id;
    private boolean isDelete;
    public LocalDate createDate;
    public LocalDate updateDate;
    public LocalDate deleteDate;

    public static int createObjectCount;

    public Student() {
        createObjectCount++;
        id += createObjectCount;
    }

    public void addStudent(Student student) {
        createDate = LocalDate.now();
        boolean check = true;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                check = false;
                break;
            }
        }

        if (check) {
            Student[] newStudent = new Student[students.length * 2];

            for (int i = 0; i < students.length; i++) {
                newStudent[i] = students[i];
            }


            newStudent[students.length] = student;
            students = newStudent;

        }

    }

    public boolean updateStudent(Student student, String groupNo) {

        for (var object : students) {
            if (object != null && object.groupNo.equals(groupNo)) {
                object = student;
                deleteDate = LocalDate.now();
                return true;
            }
        }
        return false;

    }

    public boolean deleteStudnet(int id) {
        boolean deleteCheck = false;
        int deleteObjectIndex = -1;

        for (int i = 0; i < students.length; i++) {

            if (students[i] != null && students[i].id == id) {
                deleteObjectIndex = i;
                deleteCheck = true;
                break;
            }

        }

        if (deleteCheck) {
            Student[] newStudents = new Student[students.length - 1];

            for (int i = 0, j = 0; i < students.length; i++) {

                if (i != deleteObjectIndex) {
                    newStudents[j++] = students[i];
                }

            }
            students = newStudents;
            return true;
        } else {
            return false;
        }

    }


    public boolean isDeleteStudent(int id) {

        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].id == id) {
                students[i].isDelete = true;
                deleteDate = LocalDate.now();
                return true;
            }
        }

        return false;

    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(String groupNo) {
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
