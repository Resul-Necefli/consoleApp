import appProces.Employee;
import appProces.EmployeeType;
import appProces.Student;

import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {


    }


    public static void showMenu() {

        System.out.println("operations that can be used : ");
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

        System.out.println("1 - show a list of all jobs"); // get all metods
        System.out.println("2 - Basically, employees are listed under department name\n ");
        System.out.println("3 - Employee  add ");
        System.out.println("4 - Employee  update");
        System.out.println("5 - Employee delete");
        System.out.println("6 - Employee isDelete");
        System.out.println("7 - Search");


    }


    public static void employeeProces() {
        employeeMenu();
        int b = scanner.nextInt();
        switch (b) {
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
            case 6:
                break;
            case 7:
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


    public static void create() {
        Employee employee = new Employee("IT");
        System.out.print("ad ve  soy adinizi daxil dein : ");
        employee.setFulName(scanner.nextLine());

        while (true) {
            System.out.print("vezifenizi daxil edin : ");
            boolean v = employee.setPosition(scanner.nextLine());
            if (v) {
                break;
            }
        }
        while (true) {
            System.out.print("masinizi daxil dein : ");
            boolean b = employee.setSalary(scanner.nextDouble());
            if (b) {
                break;
            }

        }
        scanner.nextLine();
        while (true) {
            System.out.print("departament name daxil edin : ");
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
        System.out.println(employee);
    }

    public static boolean enumTypeCheck(Employee employee) {
        EmployeeType[] employeeTypes = EmployeeType.values();

        System.out.print("is  rejiminizi daxil edin : ");
        String type = scanner.next().toUpperCase();

        for (var a : employeeTypes) {
            if (a.name().equals(type)) {
                employee.setEmployeeType(a);
                return false;
            }

        }
        return true;
    }


}


