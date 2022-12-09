package Karl.Controller;

import Karl.Dao.ProgramDao;
import Karl.Dao.StudentDao;
import Karl.Model.Program;
import Karl.Model.Student;

public class StudentController {
    private StudentDao studentDao = new StudentDao();
    private ProgramDao programDao = new ProgramDao();

    public void login(String email, String password){
        Student student = studentDao.selectStudentByEmail(email,password);
        if(student.getStudentID()!=null){// correct email and password
            System.out.println(student.toString());
            Program program = programDao.selectProgramByProgramID(student.getProgramID());
            System.out.println(program.toString());
        }else{// incorrect email or password
            System.out.println("Incorrect email or password!");
        }

    }

}
