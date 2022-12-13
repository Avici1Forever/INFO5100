package Karl.Controller;

import Karl.Dao.CourseDao;
import Karl.Dao.StudentCourseDao;
import Karl.Util.EnrolledCourseTable;
import Karl.Util.RegisteredCourseTable;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class RegisteredCourseController {
    private StudentCourseDao studentCourseDao = new StudentCourseDao();
    private CourseDao courseDao = new CourseDao();

    public Vector initialRegisteredCourses(Integer studentID){
        // select user's registered classes from database
        Vector<RegisteredCourseTable> vector = studentCourseDao.selectRegisteredCourseByStudentID(studentID);
        for(int i=0;i<vector.size();i++){
            // process data so that it fits table format
            vector.elementAt(i).setRemainedSeats(courseDao.calculateRemainedSeats(vector.elementAt(i).getCRN()));
        }
        return vector;
    }

    public void dropCourse(Integer studentID,Integer courseID){
        // show confirm message to user
        int opt = JOptionPane.showConfirmDialog(null,"Are you sure to drop this class?","Drop",JOptionPane.YES_NO_OPTION);
        if(opt == JOptionPane.YES_OPTION){ // confirm drop
            // delete row from database
            studentCourseDao.dropCourse(studentID,courseID);
            // show success message to user
            JOptionPane.showMessageDialog(null,"Successfully dropped！","Success",JOptionPane.PLAIN_MESSAGE);
        }
    }

}
