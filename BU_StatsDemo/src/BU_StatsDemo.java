
import java.util.Scanner;
// TASK #3 Add the file I/O import statement here
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
   This class reads numbers from a file, calculates the
   mean and standard deviation, and writes the results
   to a file.
   * 
   * This program will ask the user to input the name of the file to be read 
   * after the name of the file is given it will read the file and 
   * calculate the mean and standard deviation
   * those results will be written in a new file called Results.txt
   * 
   *  Modified by : BHUWAN UPADHYAYA
   * DATE : 2/10/2024
   * 
*/
public class BU_StatsDemo
{
   // TASK #3 Add the throws clause
   public static void main(String[] args) throws FileNotFoundException
   {
      double sum = 0;      // The sum of the numbers
      int count = 0;       // The number of numbers added
      double mean = 0;     // The average of the numbers
      double stdDev = 0;   // The standard deviation
      String line;         // To hold a line from the file
      double difference;   // The value and mean difference

      // Create an object of the Scanner class.
      Scanner keyboard = new Scanner (System.in);
      String filename;     // The user input file name

      // Prompt the user and read in the file name
      System.out.println("This program calculates statistics from a file " +
                         "containing a series of numbers.");
      System.out.print("Enter filenmae of the file containing the numbers: ");
      filename = keyboard.nextLine();

      // ADD LINES FOR TASK #4 HERE
      // Create a File object passing it the filename.
      File inputFile = new File(filename);
      // Create a Scanner object passing it the File object.
      Scanner input = new Scanner(inputFile);
      // Loop until you are at the end of the file.
       while (input.hasNext()) 
      {
         line = input.nextLine();
      // Convert the line to a double value and add the value to sum.
      double value = Double.parseDouble(line);
      // Increment the counter.
       sum += value;
         count++;
      }
      // Read a new line from the file.
      // Close the input file.
      input.close();
      // Store the calculated mean.
       mean = sum / count ;

       // ADD LINES FOR TASK #5 HERE
      // Reconnect the Scanner object you created in Task #4
      input = new Scanner(inputFile); // Reconnect to the file
      // by passing it the File object.
      sum = 0; // Reinitialize the sum
      // Reinitialize the sum of the numbers.
      count = 0; // Reinitialize the count
      // Reinitialize the number of numbers processed.

      // Loop until you are at the end of the file.
      while (input.hasNext()) 
      {
         line = input.nextLine();
         // Convert the line into a double value and subtract the mean.
         double value = Double.parseDouble(line);
         // Increment the counter.
         difference = value - mean;

         // Add the square of the difference to the sum.
         sum += difference * difference;
         count++;
      }
      // Add the square of the difference to the sum.

      // Close the input file.
      input.close();
      // Store the calculated standard deviation.
      double variance = sum / count;
      stdDev = Math.sqrt(variance);


      // ADD LINES FOR TASK #3 HERE
      // Create a PrintWriter object using "Results.txt".
      File outputFile = new File("Results.txt");
      // Print the results to the output file.
      PrintWriter output = new PrintWriter(outputFile);
      // Close the output file.
      output.println("mean = " + String.format("%.3f", mean) + ", standard deviation = " + String.format("%.3f", stdDev));
      output.close();
      // Display the mean and standard deviation on separate lines
      // to the console, formatted to show 3 decimal places.
      System.out.println("mean =  " + String.format("%.3f%n", mean) + "standard deviation = " + String.format("%.3f", stdDev));
   }
}