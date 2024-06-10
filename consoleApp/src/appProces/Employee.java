package appProces;


import java.time.LocalDate;

public class Employee {
    public static Employee[] employees = new Employee[100];
    private static University university = new University();


    private String no;
    private String fulName;
    private String position;
    private double salary;
    private String departmentName;
    public EmployeeType employeeType;
    private boolean isDelete;

    public LocalDate createDate;
    public LocalDate updateDate;
    public LocalDate deleteDate;


    public static int createObjectCount;
    private int index = 1000;

    public Employee(String departmentName) {

        createObjectCount++;
        this.index += createObjectCount;
        this.no = departmentName.substring(0, 2).toUpperCase() + this.index;

    }


    public Employee() {

    }

    public boolean addEmployee(Employee employee) {


        if (!university.setWorkerLimit(createObjectCount)) {
            System.out.println("The staff limit of the university is full");
            return false;
        }

        employee.createDate = LocalDate.now();
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


        return true;
    }

    public boolean updateEmloyee(Employee employee, String no) {

        boolean check = true;
        for (int i = 0; i < employees.length; i++) {

            if (employee != null && employees[i].no.equals(no)) {

                employees[i] = employee;
                employee.updateDate = LocalDate.now();
                check = false;
                break;

            }
        }

        return check;


    }


    public boolean deleteEmployee(String no) {


        boolean check = false;
        int index = -1;
        for (int i = 0; i < employees.length; i++) {

            if ( employees[i] != null && employees[i].no.equals(no)) {
                check = true;
                index = i;
                break;
            }
        }


        if (check) {
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
        boolean check = false;

        for (int i = 0; i < employees.length; i++) {

            if (employees[i] != null && employees[i].no.equals(no)) {
                check = true;
                employees[i].isDelete = false;
                employees[i].deleteDate = LocalDate.now();
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

    public boolean isDelete(String groupNo) {
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

        if (salary < 250 || salary > 1500) {
            System.out.println("min 250  max 1500  azn enter your");
            return false;

        }


        boolean a = university.setSalaryLimit(salary);

        if (a) {
            this.salary = salary;
            return true;
        }

        System.out.println("We cannot pay this salary because the budget is insufficient\n");
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

        return false;

    }

    @Override
    public String toString() {
        return "Employee{" +
                "no='" + no + '\'' +
                ", fulName='" + fulName + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", departmentName='" + departmentName + '\'' +
                ", employeeType=" + employeeType +
                ", isDelete=" + isDelete +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", deleteDate=" + deleteDate +
                '}';
    }
}