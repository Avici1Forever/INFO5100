package Karl.View;

import Karl.Controller.RegisterForCourseController;
import Karl.Controller.SearchForClassesController;
import Karl.Util.SystemMenuBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchForClasses {
    private static  Integer ID = null;
    private JTable table;
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private SystemMenuBar jb = new SystemMenuBar();
    private SearchForClassesController searchForClassesController = new SearchForClassesController();
    JLabel courseCodeHint;
    JLabel courseNameHint;
    JLabel courseIDHint;
    JTextField courseCode;
    JTextField courseName;
    JTextField courseID;

    public SearchForClasses(Integer id){
        JFrame.setDefaultLookAndFeelDecorated(true);
        ID=id;
        frame.setTitle("Search for Classes");
        frame.setSize(680, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


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
        jb.setBounds(0,0,680,30);
        frame.add(jb);



        courseCodeHint = new JLabel("Course Code");
        courseNameHint = new JLabel("Title");
        courseIDHint = new JLabel("CRN");
        courseCode = new JTextField();
        courseName = new JTextField();
        courseID = new JTextField();

        JPanel searchPanel = new JPanel();
        searchPanel.setBackground(new Color(255,255,255));
        searchPanel.setLayout(null);

        courseCodeHint.setBounds(160,80,150,50);
        courseCodeHint.setFont(new Font("Times New Roman",Font.TYPE1_FONT,18));
        searchPanel.add(courseCodeHint);
        courseCode.setBounds(320,80,200,50);
        courseCode.setFont(new Font("Times New Roman",Font.TYPE1_FONT,18));
        searchPanel.add(courseCode);
        courseNameHint.setBounds(160,155,150,50);
        courseNameHint.setFont(new Font("Times New Roman",Font.TYPE1_FONT,18));
        searchPanel.add(courseNameHint);
        courseName.setBounds(320,155,200,50);
        courseName.setFont(new Font("Times New Roman",Font.TYPE1_FONT,18));
        searchPanel.add(courseName);
        courseIDHint.setBounds(160,230,150,50);
        courseIDHint.setFont(new Font("Times New Roman",Font.TYPE1_FONT,18));
        searchPanel.add(courseIDHint);
        courseID.setBounds(320,230,200,50);
        courseID.setFont(new Font("Times New Roman",Font.TYPE1_FONT,18));
        searchPanel.add(courseID);


        JButton selectAllButton = new JButton("Search");
        selectAllButton.setBounds(300,300,80,50);
        searchPanel.add(selectAllButton);
        selectAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String CRN= courseID.getText();
                String title=courseName.getText();
                String code=courseCode.getText();
                frame.dispose();
                // search classes according to user inputs
                // open RegisterForCourse page using search results
                new RegisterForCourse(id,searchForClassesController.searchForClasses(code,title,CRN));
            }
        });
        frame.add(searchPanel);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);  // do NOT allow user to change the size of GUI
    }
}
