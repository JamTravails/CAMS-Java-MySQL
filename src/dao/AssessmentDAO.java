package dao;

import database.DatabaseConnection;
import model.Assessment;
import model.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AssessmentDAO {

    public void addAssessment(String studentId, Assessment assessment){
        String sql = "INSERT INTO assessment(student_id, course_code, quiz1, quiz2, assignment, test1, test2, total) VALUES(?,?,?,?,?,?,?,?)";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pts = conn.prepareStatement(sql)) {
            pts.setString(1, studentId);
            pts.setString(2, assessment.getCourse().getCourseCode());
            pts.setDouble(3, assessment.getQuiz1());
            pts.setDouble(4, assessment.getQuiz2());
            pts.setDouble(5, assessment.getAssignment());
            pts.setDouble(6, assessment.getTest1());
            pts.setDouble(7, assessment.getTest2());
            pts.setDouble(8, assessment.getTotal());
            pts.executeUpdate();
            System.out.println("Assessment added!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAssessment(String studentId, String courseId){
        String sql = "DELETE FROM assessment WHERE student_id = ? AND course_code = ?";

        try(Connection conn = DatabaseConnection.getConnection();
           PreparedStatement pts = conn.prepareStatement(sql)) {
            pts.setString(1, studentId);
            pts.setString(2, courseId);
            int row = pts.executeUpdate();
            if (row > 0){
                System.out.println("Assessment deleted successfully!");
            }else{
                System.out.println("Assessment not found!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateAssessment(String studentId, String courseId, double q1, double q2, double ass, double t1, double t2, double total){
        String sql = "UPDATE assessment SET quiz1 = ?, quiz2 = ?, assignment = ?, test1 = ?, test2 = ?, total = ? WHERE student_id = ? AND course_code = ?";

        try(Connection conn = DatabaseConnection.getConnection();
           PreparedStatement pts = conn.prepareStatement(sql)) {
            pts.setDouble(1, q1);
            pts.setDouble(2, q2);
            pts.setDouble(3, ass);
            pts.setDouble(4, t1);
            pts.setDouble(5, t2);
            pts.setDouble(6, total);
            pts.setString(7, studentId);
            pts.setString(8, courseId);
            int rows = pts.executeUpdate();
            if (rows > 0){
                System.out.println("update successful");
            }else{
                System.out.println("no assessment found");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<Assessment> getAssessmentByStudent(String studentId){
        ArrayList<Assessment> assessments = new ArrayList<>();

        String sql = "SELECT a.quiz1, a.quiz2, a.assignment, a.test1, a.test2, a.total, c.course_code, c.course_name FROM assessment a JOIN course c ON a.course_code = c.course_code WHERE a.student_id = ?";

        try(Connection conn = DatabaseConnection.getConnection();
           PreparedStatement pts = conn.prepareStatement(sql)) {
            pts.setString(1, studentId);
            ResultSet rs = pts.executeQuery();
            while (rs.next()){
                Course course = new Course(rs.getString("course_code"), rs.getString("course_name"));
                Assessment assessment = new Assessment(course, rs.getDouble("quiz1"), rs.getDouble("quiz2"), rs.getDouble("assignment"), rs.getDouble("test1"), rs.getDouble("test2"), rs.getDouble("total"));
                assessments.add(assessment);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return assessments;
    }
}
