package Karl.Dao;

import Karl.Model.Student;

import Karl.Util.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao {
    private Connection conn= DatabaseConnector.getConnection();

    public Student selectStudentByStudentID(Integer studentID){
        Student student = new Student();
        try {
            PreparedStatement prep = conn.prepareStatement(
                    "select * from Student where studentID=?");
            prep.setInt(1, studentID);
            ResultSet rs = prep.executeQuery();
            if(rs.next()){
                student.setStudentID(rs.getInt("studentID"));
                student.setEmail(rs.getString("email"));
                student.setPassword(rs.getString("password"));
                student.setFirstName(rs.getString("firstName"));
                student.setLastName(rs.getString("lastName"));
                student.setProgramID(rs.getInt("programID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public Student selectStudentByEmail(String email, String password){
        Student student = new Student();
        try {
            PreparedStatement prep = conn.prepareStatement(
                    "select * from Student where email=? and password=?");
            prep.setString(1, email);
            prep.setString(2, password);
            ResultSet rs = prep.executeQuery();
            if(rs.next()){
                student.setStudentID(rs.getInt("studentID"));
                student.setEmail(rs.getString("email"));
                student.setPassword(rs.getString("password"));
                student.setFirstName(rs.getString("firstName"));
                student.setLastName(rs.getString("lastName"));
                student.setProgramID(rs.getInt("programID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }


}
