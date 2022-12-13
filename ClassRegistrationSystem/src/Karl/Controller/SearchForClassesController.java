package Karl.Controller;

import Karl.Dao.CourseDao;
import Karl.Dao.StudentCourseDao;
import Karl.Util.RegisteredCourseTable;

import java.util.Vector;

public class SearchForClassesController {
    private StudentCourseDao studentCourseDao = new StudentCourseDao();
    private CourseDao courseDao = new CourseDao();

    public Vector<RegisteredCourseTable> searchForClasses(String courseCode, String courseName, String courseID){
        Vector<RegisteredCourseTable> vector = new Vector<>();
        // search for classes from database according to user inputs
        vector = courseDao.searchForClasses(courseCode,courseName,courseID);
        for(int i=0;i<vector.size();i++){
            // process data so that it fits table format
            vector.elementAt(i).setRemainedSeats(courseDao.calculateRemainedSeats(vector.elementAt(i).getCRN()));
        }
        return vector;
    }
}
