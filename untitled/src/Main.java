// Java program for the above approach
class GFG{

    // Function to convert string to
// integer without using functions
    public static void convert()
    {
        int rows = 2;

        // outer loop
        for (int k = 1; k <= rows; ++k) {

            for (int i = 1; i <= k; ++i) {
                System.out.println("\t" + i);
            }
            // inner loop to print the numbers
            for (int j = 1; j <= k; ++j) {
                System.out.println("\t" + j);

            }
        }
        }


    // Driver code
    public static void main(String[] args)
    {
        // Given string of number


        // Function Call
        convert();
    }
}

// This code is contributed by divyeshrabadiya07
