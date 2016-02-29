package exceptions.classFiles;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class StatisticsCalcTester {

	public static void main(String[] args) throws IOException, FileFormatException{
		Scanner in = new Scanner(new FileReader("test_num_error_2.txt"));

		StatisticsCalc calc = new StatisticsCalc (in);			
		
		System.out.printf("Average: %.2f\n", calc.getMean());
		System.out.printf("Standard Deviation: %.2f\n", calc.getStdDev ());
		System.out.printf("Min: %d\n", calc.getMin ());
		System.out.printf("Max: %d\n", calc.getMax ());
		System.out.printf("Median: %.2f\n", calc.getMedian ());
		System.out.printf("Range: %d\n", calc.getRange ());
		
  		System.out.println ("Program successfully completed.");
	}

}
