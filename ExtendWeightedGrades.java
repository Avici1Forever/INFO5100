public class ExtendWeightedGrades {

    private double[] pointTotal = new double[8]; // Point Total

    private double[] earnedPoints = new double[8]; // Earned Points

    private double[] assignmentPercentage = new double[8]; // Assignment Percentage

    private double totalWeightedGrade = 0; // Total Weighted Grade

    // constructor
    public ExtendWeightedGrades() {

    }

    public double[] getPointTotal() {
        return pointTotal;
    }

    public void setPointTotal(double[] pointTotal) {
        this.pointTotal = pointTotal;
    }

    public double[] getEarnedPoints() {
        return earnedPoints;
    }

    public void setEarnedPoints(double[] earnedPoints) {
        this.earnedPoints = earnedPoints;
    }

    public double[] getAssignmentPercentage() {
        return assignmentPercentage;
    }

    public void setAssignmentPercentage(double[] assignmentPercentage) {
        this.assignmentPercentage = assignmentPercentage;
    }

    public double getTotalWeightedGrade() {
        return totalWeightedGrade;
    }

    public void setTotalWeightedGrade(double totalWeightedGrade) {
        this.totalWeightedGrade = totalWeightedGrade;
    }

    public void calculateGrades(){

        // calculate every weighted grade for every class and add them to total
        for (int i=0 ; i < 8 ; i++) {
            totalWeightedGrade += earnedPoints[i] / pointTotal[i] * assignmentPercentage[i];
        }

    }

}
