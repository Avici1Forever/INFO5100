package DataFilesAndGUI.model;

import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DataFiles {
    String inputFileName = "annual.csv";
    String outputFileName;
    ArrayList<String[]> fileContent = new ArrayList<>();

    public String getInputFileName() {
        return inputFileName;
    }

    public void setInputFileName(String inputFileName) {
        this.inputFileName = inputFileName;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public void setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    public ArrayList<String[]> getFileContent() {
        return fileContent;
    }

    public void setFileContent(ArrayList<String[]> fileContent) {
        this.fileContent = fileContent;
    }

    // read default file
    public void ReadFile(){
        if (fileContent.size()!=0){
            fileContent = new ArrayList<>();
        }
        try (BufferedReader myReader = Files.newBufferedReader(Paths.get(inputFileName))){
            String line;
            while((line=myReader.readLine())!=null){
                String[] columns = line.split(",");
                fileContent.add(columns);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    // read specified file
    public ArrayList<String[]> ReadFile(String fileName){
        if (fileContent.size()!=0){
            fileContent = new ArrayList<>();
        }
        try (BufferedReader myReader = Files.newBufferedReader(Paths.get(fileName))){
            String line;
            while((line=myReader.readLine())!=null){
                String[] columns = line.split(",");
                fileContent.add(columns);
            }
            return null;
        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // write to new file
    public void WriteFile(){
        // if we never read origin file, read it first
        if(fileContent.size()==0){
            this.ReadFile();
        }
        File csvfile = new File(outputFileName);
        OutputStreamWriter csvout;
        try{
            csvout= new OutputStreamWriter(new FileOutputStream(csvfile), "utf-8");
            BufferedWriter bufferedWriter = new BufferedWriter(csvout);
            // header and first 5 rows
            for(int i=0;i<6;i++){
                String value="";
                // first 3 columns
                for (int j=0;j<3;j++){
                    value+=fileContent.get(i)[j];
                    if(j!=2) value+=",";
                }
                bufferedWriter.write(value+"\n");
            }
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
