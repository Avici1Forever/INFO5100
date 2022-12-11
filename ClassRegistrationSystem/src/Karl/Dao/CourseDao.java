package Karl.Dao;

import Karl.Util.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CourseDao {
    private Connection conn= DatabaseConnector.getConnection();

    public Integer calculateRemainedSeats(Integer courseID){
        Integer remainedSeats = -1;
        try {
            PreparedStatement prep = conn.prepareStatement(
                    "select A.totalSeats - COUNT(B.studentID) as \"remainedSeats\" from Course as A,StudentCourse as B where B.courseID=? and status=\"registered\" and A.courseID=B.courseID");
            prep.setInt(1, courseID);
            ResultSet rs = prep.executeQuery();
            if(rs.next()){
                remainedSeats=rs.getInt("remainedSeats");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return remainedSeats;
    }
}
