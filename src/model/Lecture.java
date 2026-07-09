package model;

public class Lecture extends Person{
    Role role;
    public Lecture(String userId, String username, String password, String email){
        super(userId, username, password, email);
        role = Role.LECTURE;
    }

    @Override
    public void personDetails(){
        System.out.println("ID: " + getUserId());
        System.out.println("Name: " + getUsername());
        System.out.println("Email: " + getEmail());
        System.out.println(Role.valueOf("LECTURER"));
    }
}
