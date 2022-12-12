package Karl.Dao;

import Karl.Model.Program;
import Karl.Model.Student;
import Karl.Util.DatabaseConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProgramDao {
    private Connection conn;
    public Program selectProgramByProgramID(Integer programID){
        Program program = new Program();
        conn = DatabaseConnector.getConnection();
        try {
            PreparedStatement prep = conn.prepareStatement(
                    "select * from Program where programID=?");
            prep.setInt(1, programID);
            ResultSet rs = prep.executeQuery();
            if(rs.next()){
                program.setProgramID(rs.getInt("programID"));
                program.setProgramName(rs.getString("programName"));
                program.setRequiredCredits(rs.getInt("requiredCredits"));
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
        return program;
    }

}
