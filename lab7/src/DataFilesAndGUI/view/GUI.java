package DataFilesAndGUI.view;

import java.awt.*;
import javax.swing.*;

public class GUI {
    private JFrame frame;
    private JPanel panel;
    private JLabel readFileNameHint;  //  hint for user
    private JLabel writeFileNameHint;  //  hint for user
    private JLabel writeFileTypeHint;  //  hint for user
    private JTextField readFileName;  //  annual.csv
    private JTextField writeFileName;  //  input area for name of producing file
    private JTextArea readFileContent;  //  content of origin file
    private JTextArea writeFileContent;  //  content of producing file
    private JButton read;  //  button to read file
    private JButton write;  //  button to write file

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

    public JLabel getReadFileNameHint() {
        return readFileNameHint;
    }

    public void setReadFileNameHint(JLabel readFileNameHint) {
        this.readFileNameHint = readFileNameHint;
    }

    public JLabel getWriteFileNameHint() {
        return writeFileNameHint;
    }

    public void setWriteFileNameHint(JLabel writeFileNameHint) {
        this.writeFileNameHint = writeFileNameHint;
    }

    public JLabel getWriteFileTypeHint() {
        return writeFileTypeHint;
    }

    public void setWriteFileTypeHint(JLabel writeFileTypeHint) {
        this.writeFileTypeHint = writeFileTypeHint;
    }

    public JTextField getReadFileName() {
        return readFileName;
    }

    public void setReadFileName(JTextField readFileName) {
        this.readFileName = readFileName;
    }

    public JTextField getWriteFileName() {
        return writeFileName;
    }

    public void setWriteFileName(JTextField writeFileName) {
        this.writeFileName = writeFileName;
    }

    public JTextArea getReadFileContent() {
        return readFileContent;
    }

    public void setReadFileContent(JTextArea readFileContent) {
        this.readFileContent = readFileContent;
    }

    public JTextArea getWriteFileContent() {
        return writeFileContent;
    }

    public void setWriteFileContent(JTextArea writeFileContent) {
        this.writeFileContent = writeFileContent;
    }

    public JButton getRead() {
        return read;
    }

    public void setRead(JButton read) {
        this.read = read;
    }

    public JButton getWrite() {
        return write;
    }

    public void setWrite(JButton write) {
        this.write = write;
    }

    //  constructor
    public GUI() {
        //  initialize Gui
        JFrame.setDefaultLookAndFeelDecorated(true);
        this.frame = new JFrame("DataFiles");
        this.panel=new JPanel();
        this.readFileNameHint = new JLabel("Reading File Name");
        this.writeFileNameHint = new JLabel("File Name to Write");
        this.writeFileTypeHint  = new JLabel(".csv");
        this.readFileName = new JTextField("annual.csv");
        this.read = new JButton("Read");
        this.writeFileName = new JTextField();
        this.readFileContent = new JTextArea();
        this.writeFileContent = new JTextArea();
        this.write = new JButton("Write");


        panel.setLayout(null);
        readFileNameHint.setBounds(50,20,200,50);
        readFileNameHint.setFont(new Font("Times New Roman",Font.TYPE1_FONT,24));
        panel.add(readFileNameHint);
        readFileName.setFont(new Font("Times New Roman",Font.TYPE1_FONT,24));
        readFileName.setBounds(275,25,120,40);
        readFileName.setDisabledTextColor(Color.red);
        readFileName.setEnabled(false);  //  user can not input in this text
        panel.add(readFileName);
        read.setForeground(new Color(255,0,0));
        read.setBounds(415,25,120,40);
        read.setFont(new Font("Times New Roman",Font.TYPE1_FONT,24));
        panel.add(read);
        readFileContent.setBounds(40,75,920,425);
        readFileContent.setEnabled(false); //  user can not input in this text
        panel.add(readFileContent);
        writeFileNameHint.setBounds(50,500,200,50);
        writeFileNameHint.setFont(new Font("Times New Roman",Font.TYPE1_FONT,24));
        panel.add(writeFileNameHint);
        writeFileName.setFont(new Font("Times New Roman",Font.TYPE1_FONT,24));
        writeFileName.setBounds(275,505,120,40);
        panel.add(writeFileName);
        writeFileTypeHint.setFont(new Font("Times New Roman",Font.TYPE1_FONT,24));
        writeFileTypeHint.setBounds(405,500,60,50);
        panel.add(writeFileTypeHint);
        write.setForeground(new Color(255,0,0));
        write.setBounds(465,505,120,40);
        write.setFont(new Font("Times New Roman",Font.TYPE1_FONT,24));
        panel.add(write);
        writeFileContent.setBounds(40,550,920,400);
        writeFileContent.setEnabled(false); //  user can not input in this text
        panel.add(writeFileContent);

        frame.setSize(1000,1000);
        frame.setLocation(460, 40);
        frame.add(panel);
        frame.setResizable(false);  // do NOT allow user to change the size of GUI
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
