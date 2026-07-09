package model;

import dao.AssessmentDAO;
import dao.CourseDAO;
import dao.StudentDAO;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class LectureMenu {
    Scanner input = new Scanner(System.in);
    CourseDAO courseDAO = new CourseDAO();
    StudentDAO studentDAO = new StudentDAO();
    AssessmentDAO assessmentDAO = new AssessmentDAO();
    public void showMenu(Lecture lecture){
        int choice = 0;

        do {
            System.out.println("=======LECTURER MENU==========\n");
            System.out.println("Welcome " + lecture.getUsername() + "(" + Role.LECTURE + ")");
            System.out.println("""
                    1. View Profile
                    2. Manage Courses
                    3. Enter CA Marks
                    4. Update CA Marks
                    5. View Students
                    6. Change Password
                    7. Logout""");
            System.out.println("=============================");
            System.out.print("Option: ");
            int option = input.nextInt();
            input.nextLine();

            switch (option){
                case 1 :
                    viewProfile(lecture);
                    break;

                case 2 :
                    manageCourses();
                    break;

                case 3 :
                    caMarks();
                    break;

                case 4 :
                    updateCa();
                    break;

                case 5 :
                    viewStudent();
                    break;
            }
        }while (choice != 4);
    }

    private void viewProfile(Lecture lecture){
        System.out.println("LECTURER PROFILE");
        System.out.println("============================\n");
        System.out.println("ID: " + lecture.getUserId());
        System.out.println("Full Name: " + lecture.getUsername());
        System.out.println("Email: " + lecture.getEmail());
        System.out.println(Role.LECTURE);
    }
    private void manageCourses(){
        boolean okay = true;
        while(okay){
            System.out.println("COURSE MANAGEMENT");
            System.out.println("""
                1. Add Course
                2. Update Course
                3. Delete Course
                4. View All Courses
                5. back""");
            System.out.print("Option: ");
            int option = input.nextInt();
            input.nextLine();

            switch (option){
                case 1 :
                    System.out.print("Enter course code: ");
                    String courseCode = input.nextLine();
                    System.out.print("Enter course name: ");
                    String courseName = input.nextLine();
                    Course course = new Course(courseCode, courseName);
                    courseDAO.addCourse(course);
                    break;

                case 2 :
                    System.out.print("Enter course_code: ");
                    String code = input.nextLine();
                    System.out.print("Enter New Course Name: ");
                    String name = input.nextLine();
                    Course course1 = new Course(code, name);
                    courseDAO.updateCourse(course1);
                    break;

                case 3 :
                    System.out.print("Enter course_code for the course you want to delete: ");
                    String code_code = input.nextLine();
                    courseDAO.deleteCourse(code_code);
                    break;

                case 4 :
                    ArrayList<Course> courses = courseDAO.getAllCourses();

                    if (courses.isEmpty()){
                        System.out.println("no course found!");
                        break;
                    }
                    for (Course c : courses){
                        System.out.println(c.getCourseName() + " - code: " + c.getCourseCode());
                    }
                    break;

                case 5 :
                    okay = false;
            }
        }

    }
    private void caMarks(){
        ArrayList<Student> students = studentDAO.getAllStudent();
        ArrayList<Course> courses = courseDAO.getAllCourses();

        if (students.isEmpty()){
            System.out.println("no student found!");
        }

        System.out.println("STUDENT\n");
        for (int i = 0; i < students.size(); i++){
            System.out.println(i + 1 + ". " + students.get(i).getUsername() + " - " + students.get(i).getUserId());
        }
        System.out.print("Select Student: ");
        int studentChoice = input.nextInt();
        input.nextLine();

        if (studentChoice < 1 || studentChoice > students.size()){
            System.out.println("Invalid option");
        }

        Student selectStudent = students.get(studentChoice - 1);

        System.out.println("COURSES\n");
        for (int i = 0; i < courses.size(); i++){
            System.out.println(i + 1 + ". " + courses.get(i).getCourseName() + " - " + courses.get(i).getCourseCode());
        }
        System.out.print("Select course: ");
        int choice = input.nextInt();
        input.nextLine();
        if (choice < 1 || choice > courses.size()){
            System.out.println("Invalid choice!");
        }

        Course selectCourse = courses.get(choice - 1);

        System.out.print("Enter quiz 1 marks: ");
        double q1 = input.nextDouble();
        System.out.print("Enter quiz 2 marks: ");
        double q2 = input.nextDouble();
        System.out.print("Enter assignment marks: ");
        double ass = input.nextDouble();
        System.out.print("Enter test 1 marks: ");
        double t1 = input.nextDouble();
        System.out.print("Enter test 2 marks: ");
        double t2 = input.nextDouble();

        double total = q1 + q2 + ass + t1 + t2;

        Assessment assessment = new Assessment(selectCourse, q1, q2, ass, t1, t2, total);

        assessmentDAO.addAssessment(selectStudent.getUserId(), assessment);

    }
    private void updateCa(){
        System.out.print("Enter student ID: ");
        String id = input.nextLine();
        System.out.print("Enter course code: ");
        String code = input.nextLine();

        System.out.print("Enter quiz 1 New marks: ");
        double q1 = input.nextDouble();
        System.out.print("Enter quiz 2 New marks: ");
        double q2 = input.nextDouble();
        System.out.print("Enter assignment New marks: ");
        double ass = input.nextDouble();
        System.out.print("Enter test 1 New marks: ");
        double t1 = input.nextDouble();
        System.out.print("Enter test 2 New marks: ");
        double t2 = input.nextDouble();

        double total = q1 + q2 + ass + t1 + t2;

        assessmentDAO.updateAssessment(id, code, q1, q2, ass, t1, t2, total);

    }
    private void viewStudent(){
        ArrayList<Student> students = studentDAO.getAllStudent();

        if (students.isEmpty()){
            System.out.println("no student found!");
        }
        for (int i = 0; i < students.size(); i++){
            System.out.println(i + 1 + ". " + students.get(i).getUsername() + " - " + students.get(i).getUserId());
        }
        System.out.print("Select student: \n");
        int choice = input.nextInt();
        input.nextLine();

        Student selectStudent = students.get(choice - 1);

        Student searchStudent = studentDAO.searchById(selectStudent);

        if (searchStudent != null){
            System.out.println("=====STUDENT DETAILS=====\n");
            System.out.println("===========================================");
            System.out.println("ID: " + searchStudent.getUserId());
            System.out.println("NAME: " + searchStudent.getUsername());
            System.out.println("EMAIL: \n" + searchStudent.getEmail());
            System.out.println("===========================================");
        }else{
            System.out.println("no student found!");
        }

        System.out.println("=====ASSESSMENT RESULT=====");
        AssessmentDAO assessmentDAO1 = new AssessmentDAO();
        ArrayList<Assessment> assessments = assessmentDAO1.getAssessmentByStudent(selectStudent.getUserId());
        for (Assessment a : assessments){
            System.out.println(a.getCourse().getCourseName()
                    + " - " + a.getCourse().getCourseCode()
                    + "\n | quiz 1: " + a.getQuiz1()
                    + " | quiz 2: " + a.getQuiz2()
                    + "\n | assignment: " + a.getAssignment()
                    + "\n | test 1: " + a.getTest1()
                    + " | test2: " + a.getTest2()
                    + "\n | total: " + a.getTotal() );
        }





    }
}
