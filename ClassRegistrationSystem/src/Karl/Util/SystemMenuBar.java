package Karl.Util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SystemMenuBar extends JMenuBar {
    // create a new menu
    private JMenu classes = new JMenu("Course");
    private JMenu user = new JMenu("User");
    // create menu items
    private JMenuItem classesItem1 = new JMenuItem("Enrolled Classes");
    private JMenuItem classesItem2 = new JMenuItem("Registered Classes");
    private JMenuItem classesItem3 = new JMenuItem("Register for Classes");
    private JMenuItem classesItem4 = new JMenuItem("Search for Classes");
    private JMenuItem userItem1 = new JMenuItem("Sign Out");

    public SystemMenuBar(){
        this.setBounds(0, 0, 1020, 30);

        this.add(classes);
        this.add(user);

        classes.add(classesItem1);
        classes.add(classesItem2);
        classes.add(classesItem3);
        classes.add(classesItem4);

        user.add(userItem1);

    }

    public JMenu getClasses() {
        return classes;
    }

    public void setClasses(JMenu classes) {
        this.classes = classes;
    }

    public JMenu getUser() {
        return user;
    }

    public void setUser(JMenu user) {
        this.user = user;
    }

    public JMenuItem getClassesItem1() {
        return classesItem1;
    }

    public void setClassesItem1(JMenuItem classesItem1) {
        this.classesItem1 = classesItem1;
    }

    public JMenuItem getClassesItem2() {
        return classesItem2;
    }

    public void setClassesItem2(JMenuItem classesItem2) {
        this.classesItem2 = classesItem2;
    }

    public JMenuItem getClassesItem3() {
        return classesItem3;
    }

    public void setClassesItem3(JMenuItem classesItem3) {
        this.classesItem3 = classesItem3;
    }

    public JMenuItem getClassesItem4() {
        return classesItem4;
    }

    public void setClassesItem4(JMenuItem classesItem4) {
        this.classesItem4 = classesItem4;
    }

    public JMenuItem getUserItem1() {
        return userItem1;
    }

    public void setUserItem1(JMenuItem userItem1) {
        this.userItem1 = userItem1;
    }
}
