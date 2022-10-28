package GUI.Controller;

import GUI.Model.WeightedScore;
import GUI.View.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiController {
    private GUI gui;
    private WeightedScore weightedScore;

    public GuiController(GUI gui, WeightedScore weightedScore){
        this.gui=gui;
        this.weightedScore=weightedScore;
    }

    public GUI getGui() {
        return gui;
    }

    public void setGui(GUI gui) {
        this.gui = gui;
    }

    public WeightedScore getWeightedScore() {
        return weightedScore;
    }

    public void setWeightedScore(WeightedScore weightedScore) {
        this.weightedScore = weightedScore;
    }

    // add listener for the button
    public void addListener(){
        gui.getCalculateScore().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weightedScore.setPointTotal(Double.valueOf(gui.getTotalAssignmentPoints().getText()));
                weightedScore.setEarnedPoints(Double.valueOf(gui.getEarnedPoints().getText()));
                weightedScore.setAssignmentPercentage(Double.valueOf(gui.getPercentageOfClass().getText()));
                weightedScore.calculateGrades();
                System.out.println(weightedScore.toString()); // test
                gui.getWeightedScore().setText(String.valueOf(weightedScore.getTotalWeightedGrade()));
            }
        });
    }

}
