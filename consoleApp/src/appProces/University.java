package appProces;

import java.util.Scanner;
import java.util.SplittableRandom;

public class University {

    public static Scanner scanner = new Scanner(System.in);
    public static Student student = new Student();
    public static Employee employee = new Employee();

    public static String name = "Azerbaycan Dovlen Neft ve Senaye Universiteti";
    private int workerLimit = 50;
    private double salaryLimit = 50000;
    private double commonSalary;

    public static double calcSalaryAvarege() {

        double calcSalaryAvarege = 0;
        for (int i = 0; i < Employee.employees.length; i++) {
            calcSalaryAvarege += Employee.employees[i].getSalary();
        }

        return calcSalaryAvarege / Employee.createObjectCount;

    }


    public static int calcStudentAvarge() {

        int calcPointAvarage = 0;
        for (int i = 0; i < Student.students.length; i++) {

            calcPointAvarage += Student.students[i].getPoint();

        }

        return calcPointAvarage / Student.createObjectCount;
    }

    public static int calcStudentAvarge(String groupNo) {

        int groupNoPiontAvarageCalc = 0;
        int groupNocount = 0;
        for (int i = 0; i < Student.students.length; i++) {

            if (Student.students[i] != null && Student.students[i].getGroupNo().equals(groupNo)) {
                groupNoPiontAvarageCalc += Student.students[i].getPoint();
                groupNocount++;
            }

        }
        return groupNoPiontAvarageCalc / groupNocount;


    }

    public int getWorkerLimit() {
        return workerLimit;
    }

    public boolean setWorkerLimit(int workerLimit) {

        if (workerLimit <= 50) {
            this.workerLimit = workerLimit;
            return true;
        }

        return false;

    }


    public double getSalaryLimit() {
        return salaryLimit;
    }


    public boolean setSalaryLimit(double salaryLimit) {

        if (this.salaryLimit >= commonSalary + salaryLimit) {
            this.salaryLimit -= salaryLimit;
            setCommonSalary(salaryLimit);
            return true;
        }

        return false;


    }

    public double getCommonSalary() {
        return commonSalary;
    }

    public void setCommonSalary(double commonSalary) {
        this.commonSalary += commonSalary;
    }


    public static void showMenu() {

        System.out.println("operations that can be used  ");
        System.out.print("1. Employee   2. Student : ");
        int a = scanner.nextInt();

        switch (a) {

            case 1:
                employeeProces();
                break;
            case 2:
                studentProces();
                break;

            default:
                System.out.println("wrong choice !");
        }

    }


    public static void studentMenu() {
        System.out.println("1 - List of students ");
        System.out.println("2 - List of groupNo students ");
        System.out.println("3 - Create student ");
        System.out.println("4 - update student ");
        System.out.println("5 - students average points");
        System.out.println("6 - students  goupNo average points");
        System.out.println("7 - delete Student");
        System.out.println("8 - logout");
        System.out.println("9 - search");

    }

    public static void studentProces() {
        studentMenu();
        int j = scanner.nextInt();
        switch (j) {

            case 1:
                Student.getAllStudents();
                break;

            case 2:
                System.out.print("Enter  your groupNo : ");
                String groupNo = scanner.nextLine();
                Student.getAllStudents(groupNo);
                break;
            case 3:
                createStudent();
                break;
            case 4:
                updateStudent();
                break;
            case 5:
                calcStudentAvarge();
                break;

            case 6:
                System.out.print("Enter your groupNo : ");
                String ch = scanner.nextLine();
                calcStudentAvarge(ch);
                break;

            case 7:
                deleteStudent();
            case 8:
                showMenu();
            case 9:
                search();

            default:
                System.out.println("wrong choice !");


        }
    }


    public static void deleteStudent() {

        System.out.println("In what format will the deletion be?");
        System.out.println("1 - isDelete");
        System.out.println("2 - Array elment delete ");

        System.out.print("Enter your choice : ");
        int a = scanner.nextInt();

        System.out.print("Enter your  id : ");
        int sc = scanner.nextInt();
        switch (a) {
            case 1:
                boolean cc = student.isDeleteStudent(sc);
                if (cc) {
                    System.out.println("object deleted ");
                } else {
                    System.out.println("object not foud ");
                }
                break;
            case 2:
                boolean ch = student.deleteStudnet(sc);
                if (ch) {
                    System.out.println("object deleted");
                } else {
                    System.out.println("object not found");
                }
                break;
            default:
                System.out.println("wrong choice !!");
        }

    }


    public static String updateStudent() {

        boolean check = false;
        System.out.print("Enter the groupno value of the object you want to update : ");

        String groupN = scanner.nextLine();

        for (var object : Student.students) {

            if (object != null && object.getGroupNo().equals(groupN)) {

                System.out.println("information about the object you are looking for");
                System.out.println();
                System.out.println(object);
                check = true;
                break;

            }
        }


        if (check) {
            System.out.print("Enter your groupNo  : ");
            String groupNo = scanner.nextLine();
            scanner.nextLine();

            System.out.print("Enter your point : ");
            int point = scanner.nextInt();

            for (var studentObject : Student.students) {
                if (studentObject != null && studentObject.getGroupNo().equals(groupNo)) {

                    studentObject.setGroupNo(groupNo);
                    studentObject.setPoint(point);
                    return studentObject.updateStudent(studentObject, groupNo) ? "object updated" : "object  not updated";
                }

            }


        }

        return "object not found ";

    }


    public static void createStudent() {

        Student student = new Student();

        System.out.print(" Enter  your  fullName : ");
        String fullName = scanner.nextLine();
        System.out.print("Enter your   gourpNo : ");
        String groupNo = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Enter your point  : ");
        int point = scanner.nextInt();

        student.setFullName(fullName);
        student.setGroupNo(groupNo);
        student.setPoint(point);

        boolean a = student.addStudent(student);

        if (a) {

            System.out.println("the operation was successfully completed");
        } else {

            System.out.println("the operation could not be completed successfully !!!");
        }


        System.out.print("Do you want to continue the practice? (yes / no ): ");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("yes")) {
            createStudent();
        }


    }


    public static void employeeMenu() {

        System.out.println("1 - The department mainly looks after workers"); // get all metods
        System.out.println("2 - see all workers  ");
        System.out.println("3 - create employee");
        System.out.println("4 - Employee delete");
        System.out.println("5 - update employee");
        System.out.println("6 - Search");
        System.out.println("7 - logout");


    }


    public static void employeeProces() {
        employeeMenu();
        System.out.print("Enter your choice : ");
        int b = scanner.nextInt();
        switch (b) {
            case 1:
                System.out.print("Enter  your groupNo : ");
                String sc = scanner.nextLine();
                employeeGetAll(sc);
                break;
            case 2:
                employeeGetAll();
                break;
            case 3:
                createEmployee();
                break;
            case 4:
                empployeeDelete();
                break;
            case 5:
                employeeUpdate();
                break;
            case 6:
                search();
                break;
            case 7:
                showMenu();
                break;

            default:
                System.out.println("wrong cohice !");
        }
    }


    public static void search() {

    }

    public static void createEmployee() {
        Employee employee = new Employee("IT");
        System.out.print(" Enter  your name and surname  : ");
        employee.setFulName(scanner.nextLine());

        scanner.nextLine();
        while (true) {
            System.out.print("Enter yout position : ");
            boolean v = employee.setPosition(scanner.nextLine());
            if (v) {
                break;
            }
        }
        while (true) {
            System.out.print("Enter your salary : ");
            boolean b = employee.setSalary(scanner.nextDouble());
            if (b) {
                break;
            }

        }
        scanner.nextLine();
        while (true) {
            System.out.print("Enter  your department name : ");
            boolean c = employee.setDepartmentName(scanner.nextLine());
            if (c) {
                break;
            }
        }
        boolean check = enumTypeCheck(employee);
        while (check) {
            boolean v = enumTypeCheck(employee);
            if (!v) {
                break;
            }
        }
        employee.addEmployee(employee);

        System.out.println();
    }

    public static boolean enumTypeCheck(Employee employee) {
        EmployeeType[] employeeTypes = EmployeeType.values();

        System.out.print(" Enter your mode of operation : ");
        String type = scanner.next().toUpperCase();

        for (var a : employeeTypes) {
            if (a.name().equals(type)) {
                employee.setEmployeeType(a);
                return false;
            }

        }
        return true;
    }


    public static void empployeeDelete() {

        System.out.println("In what format will the deletion be?");
        System.out.println("1 - isDelete");
        System.out.println("2 - Array elment delete ");
        System.out.print("Enter your choice : ");
        int a = scanner.nextInt();

        switch (a) {

            case 1:
                isDelete();
                break;

            case 2:
                arrayElmentDelete();
                break;


            default:
                System.out.println("wrong choice !");
        }

    }

    public static void arrayElmentDelete() {
        System.out.print("Enter the object  groupNo to be object : ");
        String ch = scanner.nextLine();
        boolean a = employee.deleteEmployee(ch);

        if (a) {
            System.out.println("object deleted");
        } else {

            System.out.println("object not found");

        }


    }

    public static void isDelete() {


        System.out.print("Enter the object  groupNo to be object : ");
        String groupNo = scanner.next();

        boolean a = employee.isDeleteEmployee(groupNo);

        if (a) {
            System.out.println("object deleted");
        } else {

            System.out.println("object not found");

        }

    }


    public static void employeeGetAll() {
        for (var employeeObject : Employee.employees) {

            if (employeeObject != null) {
                System.out.println(employeeObject);
            }
        }

    }


    public static void employeeGetAll(String departmentName) {

        for (var employeeObject : Employee.employees) {
            if (employeeObject != null && employeeObject.getDepartmentName().equals(departmentName)) {
                System.out.println(employeeObject);
            }
        }
    }


    public static String employeeUpdate() {

        boolean check = false;
        System.out.print("Enter the groupno value of the object you want to update : ");

        String groupNo = scanner.nextLine();

        for (var object : Employee.employees) {

            if (object != null && object.getNo().equals(groupNo)) {

                System.out.println("information about the object you are looking for");
                System.out.println();
                System.out.println(object);
                check = true;
                break;

            }
        }


        if (check) {
            System.out.print("Enter your positin : ");
            String position = scanner.nextLine();
            scanner.next();

            System.out.print("Enter your salary : ");
            double salary = scanner.nextDouble();

            for (var employeeObject : Employee.employees) {
                if (employeeObject != null && employeeObject.getNo().equals(groupNo)) {

                    employeeObject.setSalary(salary);
                    employeeObject.setPosition(position);
                    return employeeObject.updateEmloyee(employeeObject, groupNo) ? "object updated" : "object  not updated";
                }

            }


        }

        return "object not found ";

    }


}
