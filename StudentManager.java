import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
public class StudentManager {
    private ArrayList<Student> students;
    private Scanner sc;
    public StudentManager(){
        students = new ArrayList<>();
   sc = new Scanner(System.in);
    }
    public void addStudents(){
        System.out.println("\n========== Add Student ==========");
        System.out.println("Enter Roll number : ");
        int rollNo = sc.nextInt();
        sc.nextLine();
         System.out.println("Enter student name : ");
        String name = sc.nextLine();
         System.out.println("Enter student Branch : ");
        String branch = sc.nextLine();
          System.out.println("Enter Year : ");
        int year = sc.nextInt();
        sc.nextLine();
          System.out.println("Enter CGPA : ");
        double cgpa = sc.nextDouble();
        sc.nextLine();


          Student student = new Student(rollNo, name, branch, year, cgpa);
   students.add(student);
   System.out.println("\n✅ Student added successfully!");
  
        }
        // Method to display all students
public void displayStudents() {

    System.out.println("\n========== Student List ==========");

    // Check if list is empty
    if (students.isEmpty()) {
        System.out.println("No students found.");
        return;
    }

    // Display every student
    for (Student student : students) {
        System.out.println(student);
        System.out.println("---------------------------");
    }
}
// Method to search a student by roll number
public void searchStudents() {

    System.out.println("\n========== Search Student ==========");

    System.out.print("Enter Roll Number: ");
    int rollNo = sc.nextInt();
    sc.nextLine();

    // Loop through all students
    for (Student student : students) {

        if (student.getRollNo() == rollNo) {

            System.out.println("\nStudent Found:");
            System.out.println(student);
            return;
        }
    }

    System.out.println("Student not found.");
}
public void updateStudents(){
    System.out.println("\n========== Update Student ==========");
    System.out.println("Enter roll number : ");
    int rollNo = sc.nextInt();
    sc.nextLine();

    for(Student student :students){
    if(student.getRollNo() == rollNo){
        System.out.println("Enter New Name : ");
        String name = sc.nextLine();

        System.out.println("Enter New Branch : ");
        String branch = sc.nextLine();

        System.out.println("Enter New Year : ");
        int year = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the new CGPA : ");
        double cgpa = sc.nextDouble();
        sc.nextLine();

           student.setName(name);
            student.setBranch(branch);
            student.setYear(year);
            student.setCGPA(cgpa);

            System.out.println("Student updated Successfully!");
            return;
    }
    }
    System.out.println("Student not found.");
}

public void deleteStudents(){

     System.out.println("\n========== Delete Student ==========");

     System.out.println("Enter Roll number : ");
     int rollNo = sc.nextInt();
     sc.nextLine();

     for (int i = 0; i < students.size(); i++) {

    if (students.get(i).getRollNo() == rollNo) {

        students.remove(i);

        System.out.println("Student deleted successfully!");
        return;
    }
}
     System.out.println("Student not found.");
}
public void sortStudents(){
    Collections.sort(students,  Comparator.comparingInt(Student::getRollNo));
    System.out.println("Students successfully Sorted!");
}

public void saveToFile() {

    try (PrintWriter writer = new PrintWriter(new FileWriter("students.txt"))) {

        for (Student student : students) {
            writer.println(
                    student.getRollNo() + "," +
                    student.getName() + "," +
                    student.getBranch() + "," +
                    student.getYear() + "," +
                    student.getCGPA()
            );
        }

        System.out.println("Students saved successfully!");

    } catch (IOException e) {
        System.out.println("Error while saving file.");
    }
}
public void loadFromFile() {

    students.clear();

    File file = new File("students.txt");

    try (Scanner fileScanner = new Scanner(file)) {

        while (fileScanner.hasNextLine()) {

            String line = fileScanner.nextLine();

            String[] data = line.split(",");

            int rollNo = Integer.parseInt(data[0]);
            String name = data[1];
            String branch = data[2];
            int year = Integer.parseInt(data[3]);
            double cgpa = Double.parseDouble(data[4]);

            students.add(new Student(rollNo, name, branch, year, cgpa));
        }

        System.out.println("Students loaded successfully!");

    } catch (FileNotFoundException e) {
        System.out.println("No saved file found.");
    }
}

}