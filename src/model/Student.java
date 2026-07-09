package model;

public class Student extends Person{
    public Student(String studentId, String username, String password, String email){
        super(studentId, username, password, email);
    }

    @Override
    public void personDetails(){
        System.out.println("ID: " + getUserId());
        System.out.println("Name: " + getUsername());
        System.out.println("Email: " + getEmail());
        System.out.println(Role.valueOf("STUDENT"));
    }
}
