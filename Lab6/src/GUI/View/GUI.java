package GUI.View;

import java.awt.*;
import javax.swing.*;

public class GUI {
    private JFrame frame;
    private JPanel panel;
    private JLabel totalAssignmentPointsHint;  //  hint for user
    private JLabel earnedPointsHint;  //  hint for user
    private JLabel percentageOfClassHint;  //  hint for user
    private JLabel weightedScoreHint;  //  hint for user
    private JTextField weightedScore;  //  calculation result
    private JTextField totalAssignmentPoints;  //  input area for totalAssignmentPoints
    private JTextField earnedPoints;  //  input area for earnedPoints
    private JTextField percentageOfClass;  //  input area for percentageOfClass
    private JButton calculateScore;  //  button to calculate score

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JLabel getTotalAssignmentPointsHint() {
        return totalAssignmentPointsHint;
    }

    public void setTotalAssignmentPointsHint(JLabel totalAssignmentPointsHint) {
        this.totalAssignmentPointsHint = totalAssignmentPointsHint;
    }

    public JLabel getEarnedPointsHint() {
        return earnedPointsHint;
    }

    public void setEarnedPointsHint(JLabel earnedPointsHint) {
        this.earnedPointsHint = earnedPointsHint;
    }

    public JLabel getPercentageOfClassHint() {
        return percentageOfClassHint;
    }

    public void setPercentageOfClassHint(JLabel percentageOfClassHint) {
        this.percentageOfClassHint = percentageOfClassHint;
    }

    public JLabel getWeightedScoreHint() {
        return weightedScoreHint;
    }

    public void setWeightedScoreHint(JLabel weightedScoreHint) {
        this.weightedScoreHint = weightedScoreHint;
    }

    public JTextField getWeightedScore() {
        return weightedScore;
    }

    public void setWeightedScore(JTextField weightedScore) {
        this.weightedScore = weightedScore;
    }

    public JTextField getTotalAssignmentPoints() {
        return totalAssignmentPoints;
    }

    public void setTotalAssignmentPoints(JTextField totalAssignmentPoints) {
        this.totalAssignmentPoints = totalAssignmentPoints;
    }

    public JTextField getEarnedPoints() {
        return earnedPoints;
    }

    public void setEarnedPoints(JTextField earnedPoints) {
        this.earnedPoints = earnedPoints;
    }

    public JTextField getPercentageOfClass() {
        return percentageOfClass;
    }

    public void setPercentageOfClass(JTextField percentageOfClass) {
        this.percentageOfClass = percentageOfClass;
    }

    public JButton getCalculateScore() {
        return calculateScore;
    }

    public void setCalculateScore(JButton calculateScore) {
        this.calculateScore = calculateScore;
    }

    //  constructor
    public GUI() {
        //  initialize Gui
        JFrame.setDefaultLookAndFeelDecorated(true);
        this.frame = new JFrame("WeightedScore");
        this.panel=new JPanel();
        panel.setLayout(null);
        this.totalAssignmentPointsHint = new JLabel("Total Assignment Points");
        this.earnedPointsHint = new JLabel("Earned Points");
        this.percentageOfClassHint = new JLabel("Percentage of Class");
        this.weightedScoreHint = new JLabel("Weighted Score");
        this.weightedScore = new JTextField();
        weightedScore.setEnabled(false);  //  user can not input in this text
        this.totalAssignmentPoints = new JTextField();
        this.earnedPoints = new JTextField();
        this.percentageOfClass = new JTextField();
        this.calculateScore = new JButton("Calculate");
        //  set button color
        this.calculateScore.setForeground(new Color(255,0,0));
        //  set position
        totalAssignmentPointsHint.setBounds(40,20,150,25);
        panel.add(totalAssignmentPointsHint);
        totalAssignmentPoints.setBounds(200,20,75,25);
        panel.add(totalAssignmentPoints);
        earnedPointsHint.setBounds(40,60,150,25);
        panel.add(earnedPointsHint);
        earnedPoints.setBounds(200,60,75,25);
        panel.add(earnedPoints);
        percentageOfClassHint.setBounds(40,100,150,25);
        panel.add(percentageOfClassHint);
        percentageOfClass.setBounds(200,100,75,25);
        panel.add(percentageOfClass);
        calculateScore.setBounds(100,145,120,40);
        panel.add(calculateScore);
        weightedScoreHint.setBounds(40,205,150,25);
        panel.add(weightedScoreHint);
        weightedScore.setBounds(200,205,75,25);
        panel.add(weightedScore);


        frame.add(panel);
        frame.setSize(320,400);
        frame.setLocation(800, 400);
        frame.setResizable(true);  // allow user to change the size of GUI
        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
