package GUI;

import GUI.Controller.GuiController;
import GUI.Model.WeightedScore;
import GUI.View.GUI;

public class Main {
    public static void main(String[] args) {
        GUI gui = new GUI();  //  view
        WeightedScore weightedScore = new WeightedScore();  //  model
        GuiController guiController = new GuiController(gui,weightedScore);  //  controller
        // add listener for the button
        guiController.addListener();
    }
}
