package Karl.View;

import Karl.Controller.RegisteredCourseController;
import Karl.Util.EnrolledCourseTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class RegisteredCourse {
    private static  Integer ID = null;
    private JTable table;
    private JFrame frame = new JFrame();
    private RegisteredCourseController registeredCourseController = new RegisteredCourseController();

    public RegisteredCourse(Integer id) {
        ID = id;
        frame.setTitle("Enrolled Courses");
        frame.setBounds(100, 100, 1020, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JScrollPane scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        String[] columnNames = { "Title", "Subject Description", "Course Code", "CRN", "Hours", "Instructor", "Term", "Meeting Time", "Remained Seats", "Total Seats"};
        Vector columnNameV = new Vector();
        for (int column = 0; column < columnNames.length; column++) {
            columnNameV.add(columnNames[column]);
        }
        Vector<EnrolledCourseTable> course = registeredCourseController.initialRegisteredCourses(ID);
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
//        table.setRowSelectionInterval(1, 3);
//        table.addRowSelectionInterval(5, 5);
        scrollPane.setViewportView(table);

        JPanel buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        JButton selectAllButton = new JButton("全部选择");
        selectAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                table.selectAll();// 选中所有行
            }
        });
        buttonPanel.add(selectAllButton);

        JButton clearSelectionButton = new JButton("取消选择");
        clearSelectionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                table.clearSelection();// 取消所有选中行的选择状态
            }
        });
        buttonPanel.add(clearSelectionButton);


        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        System.out.println(ID);
        System.out.println(registeredCourseController.initialRegisteredCourses(ID));
    }
}
