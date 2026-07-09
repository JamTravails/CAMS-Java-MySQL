import dao.LectureDAO;
import dao.LoginDAO;
import dao.StudentDAO;
import model.Lecture;
import model.LectureMenu;
import model.Student;
import model.StudentMenu;

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static LectureDAO lectureDAO = new LectureDAO();
    static LoginDAO loginDAO = new LoginDAO();
    static LectureMenu lectureMenu = new LectureMenu();
    static StudentDAO studentDAO = new StudentDAO();
    public static void main(String[] args) {
        boolean check = true;
        while(check){
            System.out.println("CAMS PROJECT");
            System.out.println("""
                    1. CREATE ACCOUNT
                    2. LOGIN
                    3. EXIT""");

            int option = input.nextInt();
            input.nextLine();

            switch (option){
                case 1 :
                    System.out.println("CHOOSE WHICH ACCOUNT YOU WANT TO CREATE");
                    System.out.println("""
                            1. LECTURER ACCOUNT
                            2. ADMIN ACCOUNT
                            3. STUDENT ACCOUNT""");
                    System.out.print("option: ");
                    int accOption = input.nextInt();
                    input.nextLine();
                    if (accOption == 1 ){
                        createLecturer();
                    } else if (accOption == 3) {
                        createStudent();
                    }
                    break;

                case 2 :
                    System.out.println("CHOOSE WHICH TYPE OF ACCOUNT YOU WANT TO LOGIN IN TO");
                    System.out.println("""
                            1. LECTURER ACCOUNT
                            2. ADMIN ACCOUNT
                            3. STUDENT ACCOUNT""");
                    System.out.print("option: ");
                    int logOption = input.nextInt();
                    input.nextLine();
                    if (logOption == 1){
                        lecturerLogin();
                        check = false;

                        break;
                    }else if (logOption == 3){
                        studentLogin();
                        check = false;
                    }
                    break;
            }
        }

    }
    static void createLecturer(){
        System.out.println("CREATE LECTURER ACCOUNT");
        System.out.print("Lecturer ID: ");
        String lecID = input.nextLine();
        System.out.print("Lecturer FullName: ");
        String name = input.nextLine();
        System.out.print("Set password: ");
        String pass = input.nextLine();
        System.out.print("Enter your email: ");
        String email = input.nextLine();

        Lecture lecture = new Lecture(lecID, name, pass, email);
        lectureDAO.addLecturer(lecture);
        System.out.println("Account created successfully!");

    }
    static void lecturerLogin(){
        System.out.println("ENTER YOUR DETAILS BELOW");
        System.out.print("Enter ID: ");
        String id = input.nextLine();
        System.out.print("Enter password: ");
        String pass = input.nextLine();

        Lecture lecture = loginDAO.loginLecturer(id, pass);
        if (lecture != null){
            System.out.println("Login successfully!\n");
            lectureMenu.showMenu(lecture);
        }else{
            System.out.println("Invalid Lecturer ID or Password");
        }

    }
    static void createStudent(){
        System.out.print("Enter student ID: ");
        String id = input.nextLine();
        System.out.print("Enter student name: ");
        String name = input.nextLine();
        System.out.println("Create password: ");
        String pass = input.nextLine();
        System.out.print("Enter your email address: ");
        String email = input.nextLine();

        Student student = new Student(id, name, pass, email);
        studentDAO.addStudent(student);
        System.out.println("Student account created successfully!");
    }
    static void studentLogin(){
        System.out.println("ENTER YOUR DETAILS BELOW");
        System.out.print("Enter your student ID: ");
        String id = input.nextLine();
        System.out.print("Enter your password: ");
        String pass = input.nextLine();

        Student student = loginDAO.studentLogin(id, pass);

        if (student != null){
            System.out.println("Login successfully!");
            StudentMenu studentMenu = new StudentMenu();
            studentMenu.showMenu(student);

        }else {
            System.out.println("Invalid student ID or password");
        }
    }
}