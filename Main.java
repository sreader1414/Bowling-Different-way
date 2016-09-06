// Stephen Reader
// 10552526

// Import
import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;


// Main class
public class Main
{
    // Function to get the parts of the file into the array list
    public static ArrayList<Integer> readFile (String theFile)throws IOException
    {
        // Create file
        File setf = new File(theFile);

        // Use scanner to get into file
        Scanner scanner = new Scanner(setf);

        // ArrayList to hold the numbers in the file
        ArrayList numArray = new ArrayList();

        // Loop to insert into the ArrayList
        while (scanner.hasNextInt())
        {
            // Add int to arraylist
            numArray.add(scanner.nextInt());
        }
        // Done with scanner
        scanner.close();

        // Return array
        return numArray;
    }// End readFile function


    // Main function
    public static void main(String[] args)
    {
        // Variables
        int score = 0;
        int frame = 0;
        int for_tenth = 0;

        // Initialize ArrayList
        ArrayList numArray = new ArrayList();

        // Get file name from user
        Scanner fileInput = new Scanner(System.in);
        System.out.print("Please enter your .txt file (Example: b1.txt): ");
        String theFile = fileInput.next(); // Scans the next token of the input as an int.
        fileInput.close();

        // Try and get the array list using readFile function
        try
        {
            numArray = readFile(theFile);
        }
        catch(IOException exc)
        {
            System.out.println("I/O Error: " + exc);
        }

        // Loop through numArray
        for(int i = 0; i < numArray.size(); i++)
        {
            // Make sure that the frame is 1-9
            if(frame < 9)
            {
                // If throw is a strike
                if((Integer)numArray.get(i)==10)
                {
                    // Set score using Strike Class
                    score = Strike.roll(score,numArray,i);
                    frame++;
                    for_tenth++;
                }
                // If throws are spare
                else if((Integer)numArray.get(i) != 0 && (Integer)numArray.get(i+1) != 0 && (Integer)numArray.get(i) + (Integer)numArray.get(i+1) == 10 && frame < 10)
                {
                    // Set score using Spare Class
                    score = Spare.roll(score,numArray,i);
                    frame++;
                    i++;
                    for_tenth = for_tenth + 2;

                }
                // If throws are OpenFrame
                else
                {
                    // Set score using OpenFrame Class
                    score = OpenFrame.roll(score,numArray,i);
                    frame++;
                    i++;
                    for_tenth = for_tenth + 2;
                }
            }
        }// End for loop (frame 1-9)


        // 10th frame
        // Not every file has enough ints.  Catch is used at the end to assume there is a 0 at the end.
        try
        {
            score = score + (Integer) numArray.get(for_tenth) + (Integer) numArray.get(for_tenth + 1) + (Integer) numArray.get(for_tenth + 2);

        }
        catch (IndexOutOfBoundsException e)
        {
            score = score + (Integer) numArray.get(for_tenth) + (Integer) numArray.get(for_tenth + 1);
        }

        // Print out final score
        System.out.println("\nThe final score is: " + score);
    }// End main
}// End class Main
