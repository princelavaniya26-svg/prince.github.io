import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);

        // Load previously saved students
        manager.loadFromFile();

        int choice;

        do {

            System.out.println("\n========== Student Management System ==========");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Sort Students");
            System.out.println("7. Save to File");
            System.out.println("8. Load from File");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    manager.addStudents();
                    break;

                case 2:
                    manager.displayStudents();
                    break;

                case 3:
                    manager.searchStudents();
                    break;

                case 4:
                    manager.updateStudents();
                    break;

                case 5:
                    manager.deleteStudents();
                    break;

                case 6:
                    manager.sortStudents();
                    break;

                case 7:
                    manager.saveToFile();
                    break;

                case 8:
                    manager.loadFromFile();
                    break;

                case 9:
                    manager.saveToFile();
                    System.out.println("Thank you for using Student Management System!");
                    break;

                default:
                    System.out.println("Invalid Choice! Please try again.");
            }

        } while (choice != 9);

        sc.close();
    }
}