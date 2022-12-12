package Karl.Dao;

import Karl.Util.DatabaseConnector;
import Karl.Util.RegisteredCourseTable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class CourseDao {
    private Connection conn;

    public Integer calculateRemainedSeats(Integer courseID){
        Integer remainedSeats = -1;
        conn = DatabaseConnector.getConnection();
        try {
            PreparedStatement prep = conn.prepareStatement(
                    "select totalSeats - (select COUNT(studentID) from StudentCourse where courseID=? and status=\"registered\") as \"remainedSeats\" from Course where courseID =? ");
            prep.setInt(1, courseID);
            prep.setInt(2, courseID);
            ResultSet rs = prep.executeQuery();
            if(rs.next()){
                remainedSeats=rs.getInt("remainedSeats");
            }
            if(rs!=null){
                rs.close();
            }
            if(prep!=null){
                prep.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try{
            if (conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return remainedSeats;
    }

    public Vector<RegisteredCourseTable> selectCourseForRegistration(){
        Vector vector = new Vector();
        conn = DatabaseConnector.getConnection();
        try {
            PreparedStatement prep = conn.prepareStatement(
                    "select A.*,B.firstName,B.lastName,C.programName from Course as A,Professor as B,Program as C where A.courseID IN(select courseID from Course where semester=\"Spring 2023\") and A.professorID=B.professorID and A.programID=C.programID");
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                RegisteredCourseTable item = new RegisteredCourseTable();
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
            if(rs!=null){
                rs.close();
            }
            if(prep!=null){
                prep.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try{
            if (conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vector;
    }
}
