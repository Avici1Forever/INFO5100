package Karl.View;

import Karl.Controller.RegisterForCourseController;
import Karl.Controller.RegisteredCourseController;
import Karl.Util.RegisteredCourseTable;
import Karl.Util.SystemMenuBar;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class RegisterForCourse {
    private static  Integer ID = null;
    private JTable table;
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private SystemMenuBar jb = new SystemMenuBar();
    private RegisterForCourseController registerForCourseController = new RegisterForCourseController();

    public RegisterForCourse(Integer id) {
        ID = id;
        frame.setTitle("Register for Classes");
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
        jb.getUserItem1().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Sign out");
                frame.dispose();
                new Login();
            }
        });
        frame.add(jb,BorderLayout.NORTH);

        // initial table values
        String[] columnNames = { "Title", "Subject Description", "Course Code", "CRN", "Hours", "Instructor", "Term", "Meeting Time", "Remained Seats", "Total Seats"};
        Vector columnNameV = new Vector();
        for (int column = 0; column < columnNames.length; column++) {
            columnNameV.add(columnNames[column]);
        }
        // get data from database
        Vector<RegisteredCourseTable> course = registerForCourseController.initialCourses(ID);
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
            rowV.add(course.elementAt(i).getRemainedSeats());
            rowV.add(course.elementAt(i).getTotalSeats());
            tableValues.add(rowV);
        }
        table = new JTable(tableValues, columnNameV);
        DefaultTableModel defaultTableModel = new DefaultTableModel(tableValues,columnNameV);
        table = new JTable(defaultTableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setBounds(0, 0, 1020, 570);

        final JScrollPane scrollPane = new JScrollPane(table);

//        scrollPane.setViewportView(panel);
        frame.getContentPane().add(scrollPane,BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        JButton selectAllButton = new JButton("Register");
        selectAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerForCourseController.registerCourse(ID,(Integer) table.getValueAt(table.getSelectedRow(),3));
                defaultTableModel.getDataVector().clear();
                defaultTableModel.setDataVector(refreshData(),columnNameV);
                table.updateUI();
            }
        });
        buttonPanel.add(selectAllButton);


        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public Vector refreshData(){
        Vector<RegisteredCourseTable> course = registerForCourseController.initialCourses(ID);
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
            rowV.add(course.elementAt(i).getRemainedSeats());
            rowV.add(course.elementAt(i).getTotalSeats());
            tableValues.add(rowV);
        }
        return tableValues;
    }

}
