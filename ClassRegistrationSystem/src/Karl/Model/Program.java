package Karl.Model;

public class Program {
    Integer programID;
    String programName;
    Integer requiredCredits;

    public Integer getProgramID() {
        return programID;
    }

    public void setProgramID(Integer programID) {
        this.programID = programID;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public Integer getRequiredCredits() {
        return requiredCredits;
    }

    public void setRequiredCredits(Integer requiredCredits) {
        this.requiredCredits = requiredCredits;
    }

    @Override
    public String toString() {
        return "Program{" +
                "programID=" + programID +
                ", programName='" + programName + '\'' +
                ", requiredCredits=" + requiredCredits +
                '}';
    }
}
