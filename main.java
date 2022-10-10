import java.util.Scanner;

public class main {

    public static void main (String args[])
    {

        ExtendWeightedGrades extendWeightedGrades;
        extendWeightedGrades =  new ExtendWeightedGrades();
        Scanner input = new Scanner(System.in);
        double[] pointTotal, earnedPoints, assignmentPercentage;
        double totalWeightedGrade;
        String letterGrade;

        // new arrays
        pointTotal = new double[8];
        earnedPoints = new double[8];
        assignmentPercentage = new double[8];

        // user inputs the pointTotal
        System.out.println("Please input the pointTotal ( 8 numbers ) :");
        for (int i = 0; i < 8 ; i++ ){
            pointTotal[i] = input.nextDouble();
        }
        extendWeightedGrades.setPointTotal(pointTotal);

        // user inputs the earnedPoints
        System.out.println("Please input the earnedPoints ( 8 numbers ) :");
        for (int i = 0; i < 8 ; i++ ){
            earnedPoints[i] = input.nextDouble();
        }
        extendWeightedGrades.setEarnedPoints(earnedPoints);

        // user inputs the assignmentPercentage
        System.out.println("Please input the assignmentPercentage ( 8 numbers without %, 35% is 35) :");
        for (int i = 0; i < 8 ; i++ ){
            assignmentPercentage[i] = input.nextDouble();
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
