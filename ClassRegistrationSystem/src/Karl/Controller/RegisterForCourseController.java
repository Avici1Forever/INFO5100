package Karl.Controller;

import Karl.Dao.CourseDao;
import Karl.Dao.StudentCourseDao;
import Karl.Util.RegisteredCourseTable;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class RegisterForCourseController {
    private StudentCourseDao studentCourseDao = new StudentCourseDao();
    private CourseDao courseDao = new CourseDao();

    public Vector initialCourses(Integer studentID){
        // select classes that user is eligible to register for
        Vector<RegisteredCourseTable> vector = courseDao.selectCourseForRegistration();
        for(int i=0;i<vector.size();i++){
            // process data so that it fits table format
            vector.elementAt(i).setRemainedSeats(courseDao.calculateRemainedSeats(vector.elementAt(i).getCRN()));
        }
        return vector;
    }

    public void registerCourse(Integer studentID,Integer courseID){
        // check if user is eligible to register for the very class
        if(studentCourseDao.ifRegistered(studentID,courseID)){// user are not eligible for some reasons
            Toolkit.getDefaultToolkit().beep(); // remove icon
            // show user error message
            JOptionPane.showMessageDialog(null, "You have either registered for, completed, or are currently taking the course!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (courseDao.calculateRemainedSeats(courseID)==0){ // the class is full
            Toolkit.getDefaultToolkit().beep(); // remove icon
            // show user error message
            JOptionPane.showMessageDialog(null, "The class is full!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // user is eligible and class is available
        studentCourseDao.registerCourse(studentID,courseID);
        // show user success message
        JOptionPane.showMessageDialog(null,"Successfully registered！","Success",JOptionPane.PLAIN_MESSAGE);
    }

}
