package Karl.Controller;

import Karl.Dao.CourseDao;
import Karl.Dao.StudentCourseDao;
import Karl.Util.EnrolledCourseTable;
import Karl.Util.RegisteredCourseTable;

import java.util.Vector;

public class RegisteredCourseController {
    private StudentCourseDao studentCourseDao = new StudentCourseDao();
    private CourseDao courseDao = new CourseDao();

    public Vector initialRegisteredCourses(Integer studentID){
        Vector<RegisteredCourseTable> vector = studentCourseDao.selectRegisteredCourseByStudentID(studentID);
        for(int i=0;i<vector.size();i++){
            vector.elementAt(i).setRemainedSeats(courseDao.calculateRemainedSeats(vector.elementAt(i).getCRN()));
        }
        return vector;
    }

    public void dropCourse(Integer studentID,Integer courseID){
        studentCourseDao.dropCourse(studentID,courseID);
    }

}
