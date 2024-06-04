package appProces;


public class Employee  implements Utilproces {
    private    static  Employee[]  employees = new Employee[100];

    private String no;

    private  int count ;


    private static   int index = 1000;
    public Employee( String  departmentName) {

        count++;
        index += count;
       this.no  = departmentName.substring(0,2).toUpperCase() + index;

    }


    public  static  Employee returnData(Employee employee){

        return  employee;
    }

    @Override
    public void createData() {


    }

    @Override
    public void updateData() {

    }

    @Override
    public void deleteData() {

    }

    @Override
    public void isDeleteData() {

    }

    public static Employee[] getEmployees() {
        return employees;
    }

    public static void setEmployees(Employee[] employees) {
        Employee.employees = employees;
    }

    public String getNo() {
        return no;
    }

    private String fulName;
    private String position;
    private double salary;
    private String departmentName;

    public String getFulName() {
        return fulName;
    }

    public void setFulName(String fulName) {
        this.fulName = fulName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        if (position.length() >= 2) {
            this.position = position;
        } else {
            System.out.println("position minimum two characters");
        }

    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 250) {
            this.salary = salary;
        } else {
            System.out.println("salary should be at least 250 Azn");

        }

    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        if (departmentName.length() >= 2) {
            this.departmentName = departmentName;
        } else {
            System.out.println("department name minimum two characters");

        }

    }
}