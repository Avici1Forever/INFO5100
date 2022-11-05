package DataFilesAndGUI;

import DataFilesAndGUI.controller.GuiController;
import DataFilesAndGUI.model.DataFiles;
import DataFilesAndGUI.view.GUI;

public class Main {
    public static void main(String[] args) {
        DataFiles dataFiles = new DataFiles();
        GUI gui = new GUI();
        GuiController guiController = new GuiController(dataFiles,gui);
        // add listener for buttons
        guiController.addReadListener();
        guiController.addWriteListener();
    }
}
