package appProces;

public class University {

    public String name;
    private int workerLimit;
    private double salaryLimit;

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

    public void setWorkerLimit(int workerLimit) {
        this.workerLimit = workerLimit;
    }


    public double getSalaryLimit() {
        return salaryLimit;
    }

    public  static  boolean checkSalaryLimit(double salaryLimit) {
        if (salaryLimit >=250 && salaryLimit < 1500){
            return  true;
        }
        return  false;
    }
}
