package model;

public class Assessment {
    private Course course;
    private double quiz1;
    private double quiz2;
    private double assignment;
    private double test1;
    private double test2;
    private double total;

    public Assessment(Course course, double quiz1, double quiz2, double assignment, double test1, double test2, double total){
        this.course = course;
        this.quiz1 = quiz1;
        this.quiz2 = quiz2;
        this.assignment = assignment;
        this.test1 = test1;
        this.test2 = test2;
        this.total = total;
    }

    public double getQuiz1() {
        return quiz1;
    }

    public void setQuiz1(double quiz1) {
        this.quiz1 = quiz1;
    }

    public double getQuiz2() {
        return quiz2;
    }

    public void setQuiz2(double quiz2) {
        this.quiz2 = quiz2;
    }

    public double getAssignment() {
        return assignment;
    }

    public void setAssignment(double assignment) {
        this.assignment = assignment;
    }

    public double getTest1() {
        return test1;
    }

    public void setTest1(double test1) {
        this.test1 = test1;
    }

    public double getTest2() {
        return test2;
    }

    public void setTest2(double test2) {
        this.test2 = test2;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
