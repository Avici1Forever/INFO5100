package Karl.Controller;

import Karl.Dao.ProgramDao;
import Karl.Dao.StudentDao;
import Karl.Model.Professor;
import Karl.Model.Program;
import Karl.Model.Student;

import javax.swing.*;
import java.awt.*;

public class LoginController {
    private static Integer ID = null;
    private StudentDao studentDao = new StudentDao();
    private ProgramDao programDao = new ProgramDao();

    public Integer studentLogin(String email, String password) {
        Student student = studentDao.selectStudentByEmail(email, password);
        Professor professor = null;
        if (student.getStudentID() != null) {// correct email and password of a student account
            System.out.println(student.toString());
            Program program = programDao.selectProgramByProgramID(student.getProgramID());
            System.out.println(program.toString());
            return student.getStudentID();
        } else {// incorrect email or password
            System.out.println("Incorrect email or password!");
            Toolkit.getDefaultToolkit().beep(); // remove icon
            JOptionPane.showMessageDialog(null, "Incorrect email or password!", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
