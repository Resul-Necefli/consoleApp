package appProces;


import java.util.Objects;

public class Employee {
    public static Employee[] employees = new Employee[100];

    private String no;
    private String fulName;
    private String position;
    private double salary;
    private String departmentName;


    private EmployeeType employeeType;
    private int count;

    private boolean isDelete;
    private static int index = 1000;

    public Employee(String departmentName) {

        count++;
        index += count;
        this.no = departmentName.substring(0, 2).toUpperCase() + index;

    }

    public void addEmployee(Employee employee) {



        boolean check = true;
        for (int i = 0; i < employees.length; i++) {

            if (employees[i] == null) {
                employees[i] = employee;
                check = false;
                break;
            }


        }

        if (check) {
            Employee[] newEmpolyees = new Employee[employees.length * 2];

            for (int i = 0; i < employees.length; i++) {
                newEmpolyees[i] = employees[i];

            }

            newEmpolyees[employees.length] = employee;

            employees = newEmpolyees;

        }


    }

    public boolean updateEmloyee(Employee employee, String no) {
        boolean check = true;
        for (int i = 0; i < employees.length; i++) {

            if (employee != null && employees[i].no.equals(no)) {

                employees[i] = employee;
                check = false;
                break;

            }
        }

        return check;


    }


    public boolean deleteEmployee(String no) {

        boolean check = true;
        int index = 0;
        for (int i = 0; i < employees.length; i++) {

            if (employees[i].no.equals(no)) {
                check = false;
                index = i;
                break;
            }
        }


        if (!check) {
            Employee[] employeesDelete = new Employee[employees.length - 1];

            for (int i = 0, j = 0; i < employees.length; i++) {

                if (index != i) {
                    employeesDelete[j++] = employees[i];
                }

            }

            employees = employeesDelete;

        }

        return check;


    }


    public boolean isDeleteEmployee(String no) {
        boolean check = true;

        for (int i = 0; i < employees.length; i++) {

            if (employees[i] != null && employees[i].no.equals(no)) {
                check = false;
                employees[i].isDelete = false;
                break;
            }
        }

        return check;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public String getNo() {
        return no;
    }


    public String getFulName() {
        return fulName;
    }

    public void setFulName(String fulName) {
        this.fulName = fulName;
    }

    public String getPosition() {
        return position;
    }

    public boolean setPosition(String position) {
        if (position.length() >= 2) {
            this.position = position;
            return true;

        }
        System.out.println("position minimum two characters");
        return false;

    }

    public double getSalary() {
        return salary;
    }

    public boolean setSalary(double salary) {

        if (salary >= 250) {
            this.salary = salary;
            return true;
        }

        System.out.println("salary should be at least 250 Azn");
        return false;


    }

    public String getDepartmentName() {
        return departmentName;
    }

    public boolean setDepartmentName(String departmentName) {
        if (departmentName.length() >= 2) {
            this.departmentName = departmentName;
            return true;
        }
            System.out.println("department name minimum two characters");

            return  false;

    }


}