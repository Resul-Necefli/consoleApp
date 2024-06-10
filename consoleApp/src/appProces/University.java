package appProces;

public class University {


    public static String name = "Azerbaycan Dovlen Neft ve Senaye Universiteti";
    private int workerLimit =50;
    private double salaryLimit = 50000;
    private  double  commonSalary;

    public double calcSalaryAvarege() {

        double calcSalaryAvarege = 0;
        for (int i = 0; i < Employee.employees.length; i++) {
            calcSalaryAvarege += Employee.employees[i].getSalary();
        }

        return calcSalaryAvarege / Employee.createObjectCount;

    }


    public int calcStudentAvarge() {

        int calcPointAvarage = 0;
        for (int i = 0; i < Student.students.length; i++) {

            calcPointAvarage += Student.students[i].getPoint();

        }

        return calcPointAvarage / Student.createObjectCount;
    }

    public int calcStudentAvarge(String groupNo) {

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

        if ( workerLimit <= 50) {
            this.workerLimit = workerLimit;
            return  true;
        }

        return  false;

    }


    public double getSalaryLimit() {
        return salaryLimit;
    }


    public boolean setSalaryLimit(double salaryLimit) {

        if (this.salaryLimit >=  commonSalary + salaryLimit){
             this.salaryLimit -= salaryLimit;
             setCommonSalary(salaryLimit);
             return  true;
        }

        return  false;



    }

    public double getCommonSalary() {
        return commonSalary;
    }

    public void setCommonSalary(double commonSalary) {
        this.commonSalary += commonSalary;
    }
}
