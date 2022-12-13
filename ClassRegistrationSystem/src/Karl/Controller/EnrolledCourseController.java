package Karl.Controller;


import Karl.Dao.CourseDao;
import Karl.Dao.StudentCourseDao;
import Karl.Util.EnrolledCourseTable;

import java.util.Vector;

public class EnrolledCourseController {
    private StudentCourseDao studentCourseDao = new StudentCourseDao();
    private CourseDao courseDao = new CourseDao();

    public Vector initialEnrolledCourses(Integer studentID){
        // select user's enrolled classes from database
        Vector<EnrolledCourseTable> vector = studentCourseDao.selectEnrolledCourseByStudentID(studentID);
        for(int i=0;i<vector.size();i++){
            // process data so that it fits table format
            vector.elementAt(i).setRemainedSeats(courseDao.calculateRemainedSeats(vector.elementAt(i).getCRN()));
        }
        return vector;
    }

}
