import java.util.LinkedList;

public class ExtendWeightedGrades {

    private Integer totalAssignments = 0; // Number of Total Assignments

    private LinkedList<Double> pointTotal = new LinkedList<Double>(); // Point Total

    private LinkedList<Double> earnedPoints = new LinkedList<Double>(); // Earned Points

    private LinkedList<Double> assignmentPercentage = new LinkedList<Double>(); // Assignment Percentage

    private double totalWeightedGrade = 0; // Total Weighted Grade

    // constructor
    public ExtendWeightedGrades() {

    }

    public Integer getTotalAssignments() {
        return totalAssignments;
    }

    public void setTotalAssignments(Integer totalAssignments) {
        this.totalAssignments = totalAssignments;
    }

    public LinkedList<Double> getPointTotal() {
        return pointTotal;
    }

    public void setPointTotal(LinkedList<Double> pointTotal) {
        this.pointTotal = pointTotal;
    }

    public LinkedList<Double> getEarnedPoints() {
        return earnedPoints;
    }

    public void setEarnedPoints(LinkedList<Double> earnedPoints) {
        this.earnedPoints = earnedPoints;
    }

    public LinkedList<Double> getAssignmentPercentage() {
        return assignmentPercentage;
    }

    public void setAssignmentPercentage(LinkedList<Double> assignmentPercentage) {
        this.assignmentPercentage = assignmentPercentage;
    }

    public double getTotalWeightedGrade() {
        return totalWeightedGrade;
    }

    public void setTotalWeightedGrade(double totalWeightedGrade) {
        this.totalWeightedGrade = totalWeightedGrade;
    }

    // calculation method
    public void calculateGrades(){

        // calculate every weighted grade for every class and add them to total
        for (int i=0 ; i < totalAssignments ; i++) {
            totalWeightedGrade += earnedPoints.get(i) / pointTotal.get(i) * assignmentPercentage.get(i);
        }

    }

}
