public class Student {
    private int rollNo;
    private String name;
    private String branch;
    private int year;
    private double cgpa;
    //constructor
    public Student(int rollNo, String Name, String branch, int year, double cgpa){
        this.rollNo = rollNo;
        this.name = name;
        this.branch = branch;
        this.year = year;
        this.cgpa = cgpa;
    }
    //Getters
     public int getRollNo() {
        return rollNo;
    }
     public String getName() {
        return name;
    }
      public String getBranch() {
        return branch;
    }
      public int getYear() {
        return year;
    }
      public double getCGPA() {
        return cgpa;
    }
    //Setters
    public void setRollNo(int rollNo) {
    this.rollNo = rollNo;
}
    public void setName(String name) {
    this.name = name;
}
public void setBranch(String branch) {
    this.branch = branch;
}
  public void setYear(int year) {
    this.year = year;
}
  public void setCGPA(double cgpa) {
    this.cgpa = cgpa;
}
@Override
public String toString() {
    return "Roll No: " + rollNo +
           "\nName: " + name +
           "\nBranch: " + branch +
           "\nYear: " + year +
           "\nCGPA: " + cgpa;
}
}