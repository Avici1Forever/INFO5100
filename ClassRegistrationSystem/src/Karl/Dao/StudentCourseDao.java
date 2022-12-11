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
    private Connection conn = DatabaseConnector.getConnection();

    public Vector<EnrolledCourseTable> selectEnrolledCourseByStudentID(Integer studentID) {
        Vector vector = new Vector();
        try {
            PreparedStatement prep = conn.prepareStatement(
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
                professorName = rs.getString("firstName")+", "+rs.getString("lastName");
                item.setInstructor(professorName);
                item.setSubjectDescription(rs.getString("programName"));
                item.setTerm(rs.getString("semester"));
                String meetingTime;
                meetingTime = rs.getString("classTime");
                if(rs.getString("classTime2")!=null){
                    meetingTime +=" ";
                    meetingTime += rs.getString("classTime2");
                }
                item.setMeetingTime(meetingTime);
                item.setTotalSeats(rs.getInt("totalSeats"));
                vector.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vector;
    }

    public Vector<RegisteredCourseTable> selectRegisteredCourseByStudentID(Integer studentID){
        Vector vector = new Vector();
        try {
            PreparedStatement prep = conn.prepareStatement(
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
                professorName = rs.getString("firstName")+", "+rs.getString("lastName");
                item.setInstructor(professorName);
                item.setSubjectDescription(rs.getString("programName"));
                item.setTerm(rs.getString("semester"));
                String meetingTime;
                meetingTime = rs.getString("classTime");
                if(rs.getString("classTime2")!=null){
                    meetingTime +=" ";
                    meetingTime += rs.getString("classTime2");
                }
                item.setMeetingTime(meetingTime);
                item.setTotalSeats(rs.getInt("totalSeats"));
                vector.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vector;
    }

}
