package dao;

import database.DatabaseConnection;
import model.Course;
import model.Lecture;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LectureDAO {
    public void addLecturer(Lecture lecture){
        String sql = "INSERT INTO lecturers (lecturer_id, lecture_name, lecturer_pass, email) VALUES(?,?,?,?)";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pts = conn.prepareStatement(sql)) {
            pts.setString(1, lecture.getUserId());
            pts.setString(2, lecture.getUsername());
            pts.setString(3, lecture.getPassword());
            pts.setString(4, lecture.getEmail());
            pts.executeUpdate();
            System.out.println("Lecturer added!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
