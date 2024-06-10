import appProces.Employee;
import appProces.EmployeeType;
import appProces.Student;

import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static Employee employee = new Employee();

    public static void main(String[] args) {


        while (true) {
            showMenu();

        }
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


    public static void employeeMenu() {

        System.out.println("1 - The department mainly looks after workers"); // get all metods
        System.out.println("2 - see all workers  ");
        System.out.println("3 - create employee");
        System.out.println("4 - Employee delete");
        System.out.println("5 - Search");
        System.out.println("6 - logout");


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
                search();
                break;
            case 6:
                showMenu();
                break;

            default:
                System.out.println("wrong cohice !");
        }
    }


    public static void studentMenu() {
        System.out.println("1 - List of students "); // groupNo
        System.out.println("2 - Create student ");
        System.out.println("3 - update student ");  // groupNo
        System.out.println("4 - students average points"); // groupNo

    }

    public static void studentProces() {
        studentMenu();
        int j = scanner.nextInt();
        switch (j) {

            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;

            default:
                System.out.println("wrong choice !");


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


//    public static void employeeGetAllproces() {
//        System.out.println("1 - The department mainly looks after workers");
//        System.out.println("2 -  see all workers");
//
//        System.out.print("Enter your choice : ");
//        int a = scanner.nextInt();
//        switch (a) {
//            case 1:
//                System.out.print("Enter your groupNo :");
//                String groupNo = scanner.nextLine();
//                employeeGetAll(groupNo);
//                break;
//            case 2:
//                employeeGetAll();
//                break;
//            default:
//                System.out.println("wrong choice !");
//        }
//
//    }


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


