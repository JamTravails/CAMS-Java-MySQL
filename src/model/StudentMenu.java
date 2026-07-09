package model;


import java.util.Scanner;

public class StudentMenu {
    Scanner input = new Scanner(System.in);
    public void showMenu(Student student){

        while(true){
            System.out.println("========STUDENT MENU=========\n");
            System.out.println("""
                    1. View Profile
                    2. Register Courses
                    3. View Continuous Assessments
                    4. View Results
                    5. Change Password
                    6. Logout""");
            System.out.println("===========================");
            System.out.print("Option: ");
            int option = input.nextInt();
            input.nextLine();

            switch (option){
                case 1 :
                    System.out.println("STUDENT PROFILE");
                    System.out.println("ID: " + student.getUserId());
                    System.out.println("Name: " + student.getUsername());
                    System.out.println("Email: " + student.getEmail());
                    System.out.println("Role: " + Role.STUDENT);
                    break;

                case 2 :

            }
        }

    }

    private void manageStudent(){

    }
}
