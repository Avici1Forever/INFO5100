package Karl.Dao;

import Karl.Model.Student;

import Karl.Util.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao {
    private Connection conn;
    private PreparedStatement prep;

    public Student selectStudentByStudentID(Integer studentID) {
        Student student = new Student();
        conn = DatabaseConnector.getConnection();
        try {
            prep = conn.prepareStatement(
                    "select * from Student where studentID=?");
            prep.setInt(1, studentID);
            ResultSet rs = prep.executeQuery();
            if (rs.next()) {
                student.setStudentID(rs.getInt("studentID"));
                student.setEmail(rs.getString("email"));
                student.setPassword(rs.getString("password"));
                student.setFirstName(rs.getString("firstName"));
                student.setLastName(rs.getString("lastName"));
                student.setProgramID(rs.getInt("programID"));
            }
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (prep != null) {
                    prep.close();
                    System.out.println("prep closed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return student;
    }

    public Student selectStudentByEmail(String email, String password) {
        Student student = new Student();
        conn = DatabaseConnector.getConnection();
        try {
            prep = conn.prepareStatement(
                    "select * from Student where email=? and password=?");
            prep.setString(1, email);
            prep.setString(2, password);
            ResultSet rs = prep.executeQuery();
            if (rs.next()) {
                student.setStudentID(rs.getInt("studentID"));
                student.setEmail(rs.getString("email"));
                student.setPassword(rs.getString("password"));
                student.setFirstName(rs.getString("firstName"));
                student.setLastName(rs.getString("lastName"));
                student.setProgramID(rs.getInt("programID"));
            }
            try {
                if (rs != null) {
                    rs.close();
                }
                if (prep != null) {
                    prep.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (prep != null) {
                    prep.close();
                    System.out.println("prep closed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return student;
    }


}
