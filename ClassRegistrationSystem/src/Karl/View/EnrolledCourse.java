package Karl.View;

import Karl.Controller.EnrolledCourseController;
import Karl.Util.EnrolledCourseTable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class EnrolledCourse{
    private static  Integer ID = null;
    private JTable table;
    private JFrame frame = new JFrame();
    private EnrolledCourseController enrolledCourseController = new EnrolledCourseController();

    public EnrolledCourse(Integer id) {
        ID = id;
        frame.setTitle("Enrolled Courses");
        frame.setBounds(100, 100, 1020, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JScrollPane scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        String[] columnNames = { "Title", "Subject Description", "Course Code", "CRN", "Hours", "Instructor", "Term", "Meeting Time"};
        Vector columnNameV = new Vector();
        for (int column = 0; column < columnNames.length; column++) {
            columnNameV.add(columnNames[column]);
        }
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
        //
//        System.out.println("表格共有" + table.getRowCount() + "行"
//                + table.getColumnCount() + "列");
//        System.out.println("共有" + table.getSelectedRowCount() + "行被选中");
//        System.out.println("第3行的选择状态为：" + table.isRowSelected(2));
//        System.out.println("第5行的选择状态为：" + table.isRowSelected(4));
//        System.out.println("被选中的第一行的索引是：" + table.getSelectedRow());
//        int[] selectedRows = table.getSelectedRows();// 获得所有被选中行的索引
//        System.out.print("所有被选中行的索引是：");
//        for (int row = 0; row < selectedRows.length; row++) {
//            System.out.print(selectedRows[row] + "  ");
//        }
//        System.out.println();
//        System.out.println("列移动前第2列的名称是：" + table.getColumnName(1));
//        System.out.println("列移动前第2行第2列的值是：" + table.getValueAt(1, 1));
//        table.moveColumn(1, 5);// 将位于索引1的列移动到索引5处
//        System.out.println("列移动后第2列的名称是：" + table.getColumnName(1));
//        System.out.println("列移动后第2行第2列的值是：" + table.getValueAt(1, 1));


        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        System.out.println(ID);
        System.out.println(enrolledCourseController.initialEnrolledCourses(ID));
    }
}

