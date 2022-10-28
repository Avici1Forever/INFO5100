package GUI.Model;

public class WeightedScore {
    private double pointTotal; // Point Total

    private double earnedPoints; // Earned Points

    private double assignmentPercentage; // Assignment Percentage

    private double totalWeightedGrade; // Total Weighted Grade

    public double getPointTotal() {
        return pointTotal;
    }

    public void setPointTotal(double pointTotal) {
        this.pointTotal = pointTotal;
    }

    public double getEarnedPoints() {
        return earnedPoints;
    }

    public void setEarnedPoints(double earnedPoints) {
        this.earnedPoints = earnedPoints;
    }

    public double getAssignmentPercentage() {
        return assignmentPercentage;
    }

    public void setAssignmentPercentage(double assignmentPercentage) {
        this.assignmentPercentage = assignmentPercentage;
    }

    public double getTotalWeightedGrade() {
        return totalWeightedGrade;
    }

    public void setTotalWeightedGrade(double totalWeightedGrade) {
        this.totalWeightedGrade = totalWeightedGrade;
    }

    @Override
    public String toString() {
        return "WeightedScore{" +
                "pointTotal=" + pointTotal +
                ", earnedPoints=" + earnedPoints +
                ", assignmentPercentage=" + assignmentPercentage +
                ", totalWeightedGrade=" + totalWeightedGrade +
                '}';
    }

    public void calculateGrades(){

        double pointTotal, earnedPoints, assignmentPercentage;
        double totalWeightedGrade;
        pointTotal = this.getPointTotal();
        earnedPoints = this.getEarnedPoints();
        assignmentPercentage =  this.getAssignmentPercentage();
        totalWeightedGrade = earnedPoints / pointTotal * assignmentPercentage;
        this.setTotalWeightedGrade(totalWeightedGrade);

    }
}
