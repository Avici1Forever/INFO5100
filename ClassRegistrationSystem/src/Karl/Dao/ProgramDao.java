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
    private PreparedStatement prep;

    // select program from database by programID
    public Program selectProgramByProgramID(Integer programID) {
        Program program = new Program();
        conn = DatabaseConnector.getConnection();
        try {
            prep = conn.prepareStatement(
                    "select * from Program where programID=?");
            prep.setInt(1, programID);
            ResultSet rs = prep.executeQuery();
            if (rs.next()) {
                program.setProgramID(rs.getInt("programID"));
                program.setProgramName(rs.getString("programName"));
                program.setRequiredCredits(rs.getInt("requiredCredits"));
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
        return program;
    }

}
