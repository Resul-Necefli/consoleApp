package appProces;

import java.time.LocalDate;

public class Student {
    private String fullName;
    private int groupNo;
    private int point;

    LocalDate createDate;
    LocalDate updateDate;
    LocalDate deleteDate;



    
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(int groupNo) {
        this.groupNo = groupNo;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
