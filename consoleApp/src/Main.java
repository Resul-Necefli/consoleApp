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



        create();
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


