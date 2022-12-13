package Karl.View;

import Karl.Controller.EnrolledCourseController;
import Karl.Util.EnrolledCourseTable;
import Karl.Util.SystemMenuBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class EnrolledCourse{
    private static  Integer ID = null;
    private JTable table;
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private SystemMenuBar jb = new SystemMenuBar();
    private EnrolledCourseController enrolledCourseController = new EnrolledCourseController();

    public EnrolledCourse(Integer id) {
        ID = id;
        frame.setTitle("Enrolled Classes");
        frame.setSize(1020, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());


        // add ActionListener for menu items
        jb.getClassesItem1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("clicked enrolled classes");
                frame.dispose();
                new EnrolledCourse(ID);
            }
        });
        jb.getClassesItem2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("clicked registered classes");
                frame.dispose();
                new RegisteredCourse(ID);
            }
        });
        jb.getClassesItem3().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("clicked register for classes");
                frame.dispose();
                new RegisterForCourse(ID);
            }
        });
        jb.getClassesItem4().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("clicked search for classes");
                frame.dispose();
                new SearchForClasses(ID);
            }
        });
        jb.getUserItem1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Sign out");
                frame.dispose();
                new Login();
            }
        });
        frame.add(jb,BorderLayout.NORTH);

        String[] columnNames = { "Title", "Subject Description", "Course Code", "CRN", "Hours", "Instructor", "Term", "Meeting Time"};
        Vector columnNameV = new Vector();
        for (int column = 0; column < columnNames.length; column++) {
            columnNameV.add(columnNames[column]);
        }
        // select user's enrolled classes from database
        Vector<EnrolledCourseTable> course = enrolledCourseController.initialEnrolledCourses(ID);
        Vector tableValues = new Vector();
        for (int i = 0; i < course.size(); i++) {
            Vector rowV = new Vector();
            rowV.add(course.elementAt(i).getTitle());
            rowV.add(course.elementAt(i).getSubjectDescription());
            rowV.add(course.elementAt(i).getCourseCode());
            rowV.add(course.elementAt(i).getCRN());
            rowV.add(course.elementAt(i).getHours());
            rowV.add(course.elementAt(i).getInstructor());
            rowV.add(course.elementAt(i).getTerm());
            rowV.add(course.elementAt(i).getMeetingTime());
            tableValues.add(rowV);
        }
        table = new JTable(tableValues, columnNameV);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setBounds(0, 0, 1020, 570);

        final JScrollPane scrollPane = new JScrollPane(table);

//        scrollPane.setViewportView(panel);
        frame.getContentPane().add(scrollPane,BorderLayout.CENTER);

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);  // do NOT allow user to change the size of GUI

        System.out.println(ID);
        System.out.println(enrolledCourseController.initialEnrolledCourses(ID));
    }
}