package dao;

import database.DatabaseConnection;
import model.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseDAO {
    public void addCourse(Course course){
        String sql = "INSERT INTO course(course_code, course_name) VALUES(?,?)";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pts = conn.prepareStatement(sql);) {
            pts.setString(1, course.getCourseCode());
            pts.setString(2, course.getCourseName());
            pts.executeUpdate();
            System.out.println("Course added!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateCourse(Course course){
        String sql = "UPDATE course SET course_name = ? WHERE course_code = ?";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pts = conn.prepareStatement(sql)) {
            pts.setString(1, course.getCourseName());
            pts.setString(2, course.getCourseCode());
            int rows = pts.executeUpdate();
            if (rows > 0){
                System.out.println("Course Updated successfully!");
            }else{
                System.out.println("No course found!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteCourse(String courseCode){
        String sql = "DELETE FROM course WHERE course_code = ?";

        try(Connection conn = DatabaseConnection.getConnection();
           PreparedStatement pts = conn.prepareStatement(sql)) {
            pts.setString(1, courseCode);
            int rows = pts.executeUpdate();
            if (rows > 0){
                System.out.println("Course deleted successfully!");
            }else {
                System.out.println("No course found!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Course> getAllCourses(){
        ArrayList<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM course";
        try(Connection conn = DatabaseConnection.getConnection();
           PreparedStatement pts = conn.prepareStatement(sql);
           ResultSet rs = pts.executeQuery()) {
            while (rs.next()){
                Course c = new Course(rs.getString("course_code"), rs.getString("course_name"));
                courses.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return courses;
    }

}
