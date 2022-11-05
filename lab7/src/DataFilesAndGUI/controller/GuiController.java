package DataFilesAndGUI.controller;

import DataFilesAndGUI.model.DataFiles;
import DataFilesAndGUI.view.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiController {
    DataFiles dataFiles;
    GUI gui;

    public DataFiles getDataFiles() {
        return dataFiles;
    }

    public void setDataFiles(DataFiles dataFiles) {
        this.dataFiles = dataFiles;
    }

    public GUI getGui() {
        return gui;
    }

    public void setGui(GUI gui) {
        this.gui = gui;
    }

    public void setReadingFileName(){
        this.gui.getReadFileName().setText(dataFiles.getInputFileName());
    }

    public GuiController(DataFiles dataFiles, GUI gui) {
        this.dataFiles = dataFiles;
        this.gui = gui;
    }

    // read button listener
    public void addReadListener(){
        gui.getRead().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dataFiles.ReadFile();
                String fileContent="";
                // header
                fileContent+=String.join(" ",dataFiles.getFileContent().get(0));
                fileContent+="\n";
                // first 5 rows
                for (int i=1;i<6;i++){
                    fileContent+=String.join(", ",dataFiles.getFileContent().get(i));
                    fileContent+="\n";
                }
                gui.getReadFileContent().setText(fileContent);
                System.out.println(fileContent);
            }
        });
    }

    // write button listener
    public void addWriteListener(){
        gui.getWrite().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dataFiles.setOutputFileName(gui.getWriteFileName().getText()+".csv");
                dataFiles.WriteFile();
                // refresh fileContent
                dataFiles.ReadFile(dataFiles.getOutputFileName());
                String fileContent="";
                // header
                fileContent+=String.join(" ",dataFiles.getFileContent().get(0));
                fileContent+="\n";
                // first 5 rows
                // the file only have 3 columns
                for (int i=1;i<6;i++){
                    fileContent+=String.join(", ",dataFiles.getFileContent().get(i));
                    fileContent+="\n";
                }
                gui.getWriteFileContent().setText(fileContent);
                System.out.println(fileContent);
            }
        });
    }

}
