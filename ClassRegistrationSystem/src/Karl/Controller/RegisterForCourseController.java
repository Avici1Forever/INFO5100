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
        Vector<RegisteredCourseTable> vector = courseDao.selectCourseForRegistration();
        for(int i=0;i<vector.size();i++){
            vector.elementAt(i).setRemainedSeats(courseDao.calculateRemainedSeats(vector.elementAt(i).getCRN()));
        }
        return vector;
    }

    public void registerCourse(Integer studentID,Integer courseID){
        if(studentCourseDao.ifRegistered(studentID,courseID)){
            Toolkit.getDefaultToolkit().beep(); // remove icon
            JOptionPane.showMessageDialog(null, "You already registered this class!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        studentCourseDao.registerCourse(studentID,courseID);
        JOptionPane.showMessageDialog(null,"Successfully registered！","Success",JOptionPane.PLAIN_MESSAGE);
    }

}
