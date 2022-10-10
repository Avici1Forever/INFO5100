import java.util.LinkedList;
import java.util.Scanner;

public class main {

    public static void main (String args[])
    {

        ExtendWeightedGrades extendWeightedGrades;
        extendWeightedGrades =  new ExtendWeightedGrades();
        Scanner input = new Scanner(System.in);
        LinkedList<Double> pointTotal, earnedPoints, assignmentPercentage;
        Integer totalAssignments;
        double totalWeightedGrade;
        String letterGrade;

        // new LinkedLists
        pointTotal = new LinkedList<Double>();
        earnedPoints = new LinkedList<Double>();
        assignmentPercentage = new LinkedList<Double>();

        // user inputs the totalAssignments
        System.out.println("Please input the number of total assignments ( Integer ) :");
        totalAssignments = input.nextInt();
        extendWeightedGrades.setTotalAssignments(totalAssignments);

        // user inputs the pointTotal
        System.out.println("Please input the pointTotal :");
        for (int i = 0; i < totalAssignments ; i++ ){
            pointTotal.add(i,input.nextDouble());
        }
        extendWeightedGrades.setPointTotal(pointTotal);

        // user inputs the earnedPoints
        System.out.println("Please input the earnedPoints :");
        for (int i = 0; i < totalAssignments ; i++ ){
            earnedPoints.add(i,input.nextDouble());
        }
        extendWeightedGrades.setEarnedPoints(earnedPoints);

        // user inputs the assignmentPercentage
        System.out.println("Please input the assignmentPercentage ( numbers without %, 35% is 35) :");
        for (int i = 0; i < totalAssignments ; i++ ){
            assignmentPercentage.add(i,input.nextDouble());
        }
        extendWeightedGrades.setAssignmentPercentage(assignmentPercentage);

        // calculation
        extendWeightedGrades.calculateGrades();

        // get the result
        totalWeightedGrade = extendWeightedGrades.getTotalWeightedGrade();

        // output totalWeightedGrade
        System.out.println("The total weighted grade is :" + totalWeightedGrade);

        // judge the letter grade
        if ( totalWeightedGrade >= 90 && totalWeightedGrade <= 100 ){
            letterGrade = "A";
        } else if (totalWeightedGrade >= 80 ) {
            letterGrade = "B";
        } else if (totalWeightedGrade >= 70 ) {
            letterGrade = "C";
        } else if (totalWeightedGrade >= 60 ) {
            letterGrade = "D";
        } else {
            letterGrade = "F";
        }

        //output the letter grade
        System.out.println("The letter grade is :" + letterGrade);

    }

}
