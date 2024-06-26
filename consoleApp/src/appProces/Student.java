package appProces;

import java.time.LocalDate;

public class Student {

    public static Student[] students = new Student[100];

    public String fullName;
    public String groupNo;
    private int point;
    private int id;
    private boolean isDelete;
    public LocalDate createDate;
    public LocalDate updateDate;
    public LocalDate deleteDate;

    public static int createObjectCount = -1;

    public Student() {
        createObjectCount++;
        id += createObjectCount;
    }

    public static void getAllStudents() {
        for (var studentObject : students) {
            if (studentObject != null) {
                System.out.println(studentObject);
            }
        }
    }

    public static void getAllStudents(String groupNo) {
        for (var studentObject : students) {
            if (studentObject != null && studentObject.groupNo.equals(groupNo)) {
                System.out.println(studentObject);
            }
        }
    }

    public boolean addStudent(Student student) {
        createDate = LocalDate.now();
        boolean check = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
                check = true;
                break;
            }
        }

        if (!check) {
            Student[] newStudent = new Student[students.length * 2];

            for (int i = 0; i < students.length; i++) {
                newStudent[i] = students[i];
            }


            newStudent[students.length] = student;
            students = newStudent;

        }

        return check;

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

        if (point < 0 || point > 100) {
            System.out.println(" enter point min 0  max  100  ");
        } else {
            this.point = point;
        }

    }

    public void search(int id) {

        boolean check = false;
        for (int i = 0; i < students.length; i++) {

            if (students[i] != null && students[i].id == id) {

                System.out.println("information about the exchanged object: ");
                System.out.println(students[i]);

                check = true;

            }


        }


        if (!check) {
            System.out.println("object not found ");
        }

    }


    public void search(String fullName) {

        boolean check = false;

        for (int i = 0; i < students.length; i++) {

            if (students[i] != null && students[i].fullName.startsWith(fullName)) {

                System.out.println(students[i]);
                check = true;

            }

        }


        if (!check) {

            System.out.println("object not found ! ");
        }


    }


    public void search(String groupNo, int point) {

        boolean check = false;

        for (int i = 0; i < students.length; i++) {

            if (students[i] != null && students[i].groupNo.startsWith(groupNo) && students[i].point == point) {

                System.out.println(students[i]);
                check = true;
            }

        }

        if (!check) {

            System.out.println("object not found ! ");
        }

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
