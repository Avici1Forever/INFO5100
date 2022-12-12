package Karl.Dao;

import Karl.Util.DatabaseConnector;
import Karl.Util.EnrolledCourseTable;
import Karl.Util.RegisteredCourseTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class StudentCourseDao {
    private Connection conn;
    private PreparedStatement prep;

    public Vector<EnrolledCourseTable> selectEnrolledCourseByStudentID(Integer studentID) {
        Vector vector = new Vector();
        conn = DatabaseConnector.getConnection();
        try {
            prep = conn.prepareStatement(
                    "select A.*,B.firstName,B.lastName,C.programName from Course as A,Professor as B,Program as C where A.courseID IN(select courseID from StudentCourse where studentID=? and status=\"enrolled\") and A.professorID=B.professorID and A.programID=C.programID");
            prep.setInt(1, studentID);
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                EnrolledCourseTable item = new EnrolledCourseTable();
                item.setTitle(rs.getString("courseName"));
                item.setCourseCode(rs.getString("courseCode"));
                item.setCRN(rs.getInt("courseID"));
                item.setHours(rs.getInt("courseCredits"));
                String professorName;
                professorName = rs.getString("firstName") + ", " + rs.getString("lastName");
                item.setInstructor(professorName);
                item.setSubjectDescription(rs.getString("programName"));
                item.setTerm(rs.getString("semester"));
                String meetingTime;
                meetingTime = rs.getString("classTime");
                if (rs.getString("classTime2") != null) {
                    meetingTime += " ";
                    meetingTime += rs.getString("classTime2");
                }
                item.setMeetingTime(meetingTime);
                item.setTotalSeats(rs.getInt("totalSeats"));
                vector.add(item);
            }
            if (rs != null) {
                rs.close();
            }
            if (prep != null) {
                prep.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vector;
    }

    public Vector<RegisteredCourseTable> selectRegisteredCourseByStudentID(Integer studentID) {
        Vector vector = new Vector();
        conn = DatabaseConnector.getConnection();
        try {
            prep = conn.prepareStatement(
                    "select A.*,B.firstName,B.lastName,C.programName from Course as A,Professor as B,Program as C where A.courseID IN(select courseID from StudentCourse where studentID=? and status=\"registered\") and A.professorID=B.professorID and A.programID=C.programID");
            prep.setInt(1, studentID);
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                RegisteredCourseTable item = new RegisteredCourseTable();
                item.setTitle(rs.getString("courseName"));
                item.setCourseCode(rs.getString("courseCode"));
                item.setCRN(rs.getInt("courseID"));
                item.setHours(rs.getInt("courseCredits"));
                String professorName;
                professorName = rs.getString("firstName") + ", " + rs.getString("lastName");
                item.setInstructor(professorName);
                item.setSubjectDescription(rs.getString("programName"));
                item.setTerm(rs.getString("semester"));
                String meetingTime;
                meetingTime = rs.getString("classTime");
                if (rs.getString("classTime2") != null) {
                    meetingTime += " ";
                    meetingTime += rs.getString("classTime2");
                }
                item.setMeetingTime(meetingTime);
                item.setTotalSeats(rs.getInt("totalSeats"));
                vector.add(item);
            }
            try {
                if (rs!=null){
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                if (conn!=null){
                    conn.close();
                }
                if(prep!=null){
                    prep.close();
                    System.out.println("prep closed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return vector;
    }

    public void dropCourse(Integer studentID, Integer courseID) {
        conn = DatabaseConnector.getConnection();
        try {
            prep = conn.prepareStatement(
                    "delete from StudentCourse where studentID=? and courseID=?");
            prep.setInt(1, studentID);
            prep.setInt(2, courseID);
            prep.execute();
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
    }

    public void registerCourse(Integer studentID, Integer courseID) {
        conn = DatabaseConnector.getConnection();
        try {
            prep = conn.prepareStatement(
                    "insert into StudentCourse values(?,?,\"registered\")");
            prep.setInt(1, studentID);
            prep.setInt(2, courseID);
            prep.execute();
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
    }

    public boolean ifRegistered(Integer studentID, Integer courseID) {

        try {
            conn = DatabaseConnector.getConnection();
            prep = conn.prepareStatement(
                    "select * from StudentCourse where studentID=? and courseID=? and status=\"registered\"");
            prep.setInt(1, studentID);
            prep.setInt(2, courseID);
            ResultSet rs = prep.executeQuery();
            if (rs.next()) {// already registered
                rs.close();
                return true;
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

        return false;
    }

}
