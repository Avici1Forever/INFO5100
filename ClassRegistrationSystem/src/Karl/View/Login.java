package Karl.View;

import Karl.Controller.LoginController;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

// Login View
public class Login {
    private JFrame frame;
    private JPanel panel;
    private JLabel emailHint;  //  hint for user
    private JLabel passwordHint;  //  hint for user
    private JTextField email;  //  input area for email
    private JPasswordField password;  //  input area for password
    private JButton login;  //  button to login
    private LoginController loginController = new LoginController();

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JLabel getEmailHint() {
        return emailHint;
    }

    public void setEmailHint(JLabel emailHint) {
        this.emailHint = emailHint;
    }

    public JLabel getPasswordHint() {
        return passwordHint;
    }

    public void setPasswordHint(JLabel passwordHint) {
        this.passwordHint = passwordHint;
    }

    public JTextField getEmail() {
        return email;
    }

    public void setEmail(JTextField email) {
        this.email = email;
    }

    public JPasswordField getPassword() {
        return password;
    }

    public void setPassword(JPasswordField password) {
        this.password = password;
    }

    public JButton getLogin() {
        return login;
    }

    public void setLogin(JButton login) {
        this.login = login;
    }

    public void addListener(){
        this.login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Email = email.getText();
                String Password = String.valueOf(password.getPassword());
                System.out.println(Email);
                System.out.println(Password);
                Integer id = loginController.studentLogin(Email,Password);
                if(id!=null) {// login method
                    frame.dispose();
                    new EnrolledCourse(id);
                }
            }
        });
    }

    //  constructor
    public Login(){
        //  initialize components
        JFrame.setDefaultLookAndFeelDecorated(true);
        this.frame = new JFrame("Login");
        this.panel=new JPanel();
        this.emailHint = new JLabel("Email");
        this.passwordHint = new JLabel("Password");
        this.email = new JTextField();
        this.password = new JPasswordField();
        this.login = new JButton("Login");

        frame.setSize(750,400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);  // do NOT allow user to change the size of GUI
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setLayout(null);
        emailHint.setBounds(200,100,80,50);
        emailHint.setFont(new Font("Times New Roman",Font.TYPE1_FONT,18));
        panel.add(emailHint);
        email.setBounds(300,100,250,40);
        email.setFont(new Font("Times New Roman",Font.TYPE1_FONT,18));
        panel.add(email);
        passwordHint.setBounds(200,160,80,50);
        passwordHint.setFont(new Font("Times New Roman",Font.TYPE1_FONT,18));
        panel.add(passwordHint);
        password.setBounds(300,160,250,40);
        password.setFont(new Font("Times New Roman",Font.TYPE1_FONT,18));
        panel.add(password);
        login.setBounds(315,250,100,50);
        login.setFont(new Font("Times New Roman",Font.TYPE1_FONT,18));
        panel.add(login);
        frame.add(panel);

        frame.setVisible(true);

        addListener();// add listener for login button
    }

}