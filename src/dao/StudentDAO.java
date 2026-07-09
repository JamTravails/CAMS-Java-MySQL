package dao;

import database.DatabaseConnection;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAO {
    public void addStudent(Student student){
        String sql = "INSERT INTO student(student_id, student_name, student_pass, email) VALUES(?,?,?,?)";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pts = conn.prepareStatement(sql)) {
            pts.setString(1, student.getUserId());
            pts.setString(2, student.getUsername());
            pts.setString(3, student.getPassword());
            pts.setString(4, student.getEmail());
            pts.executeUpdate();
            System.out.println("Student added successfully!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Student> getAllStudent(){
        ArrayList<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM student";
        try(Connection conn = DatabaseConnection.getConnection();
           PreparedStatement pts = conn.prepareStatement(sql);
            ResultSet rs = pts.executeQuery()) {
            while(rs.next()){
                Student s = new Student(rs.getString("student_id"), rs.getString("student_name"), rs.getString("student_pass"), rs.getString("email"));
                students.add(s);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    public Student searchById(Student student){
        String sql = "SELECT * FROM student WHERE student_id = ?";

        try(Connection conn = DatabaseConnection.getConnection();
           PreparedStatement pts = conn.prepareStatement(sql)) {
            pts.setString(1, student.getUserId());
            ResultSet rs = pts.executeQuery();
            if (rs.next()){
                return new Student(rs.getString("student_id"), rs.getString("student_name"), null, rs.getString("email"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
