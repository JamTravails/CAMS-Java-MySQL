package dao;

import database.DatabaseConnection;
import model.Lecture;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginDAO {

    public Lecture loginLecturer(String lecturerID, String password){
        String sql = "SELECT * FROM lecturers WHERE lecturer_id = ? AND lecturer_pass = ?";

        try(Connection conn = DatabaseConnection.getConnection();
           PreparedStatement pts = conn.prepareStatement(sql)) {
            pts.setString(1, lecturerID);
            pts.setString(2, password);

            ResultSet rs = pts.executeQuery();

            if (rs.next()){
                return new Lecture(rs.getString("lecturer_id"), rs.getString("lecture_name"), rs.getString("lecturer_pass"), rs.getString("email"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Student studentLogin(String id, String password){
        String sql = "SELECT * FROM student WHERE student_id = ? AND student_pass = ?";

        try(Connection conn = DatabaseConnection.getConnection();
           PreparedStatement pts = conn.prepareStatement(sql)) {
            pts.setString(1, id);
            pts.setString(2, password);

            ResultSet rs = pts.executeQuery();
            if (rs.next()){
                return new Student(rs.getString("student_id"), rs.getString("student_name"), rs.getString("student_pass"), rs.getString("email"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
