import java.util.Scanner;

public class Ques2 
{
    public static void main(String[] args)
    {
        DSAHashTable hash = new DSAHashTable(10); // Create a new hash table object

        // Inserting airport information
        hash.put("MEL", "Melbourne Tullamarine (MEL) Airport");
        hash.put("JFK", "John F. Kennedy International Airport");
        hash.put("LAX", "Los Angeles International Airport");
        hash.put("LHR", "London Heathrow Airport");
        hash.put("BKK", "Bangkok Suvarnabhumi Airport");

        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while (choice != 5) // Loop until the user chooses to exit
        {
            System.out.println("\nAirport Information System");
            System.out.println("1. INSERT airport information");
            System.out.println("2. SEARCH airport information");
            System.out.println("3. DELETE airport information");
            System.out.println("4. ALL airport information");
            System.out.println("5. EXIT");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt(); // Get the user's choice
            sc.nextLine();
            switch (choice)
            {
                case 1:
                    System.out.print("\nEnter airport code: ");
                    String code = sc.nextLine(); // Get the airport code
                    System.out.print("Enter airport name: ");
                    String name = sc.nextLine(); // Get the airport name
                    hash.put(code, name); // Insert the airport information
                    System.out.println();
                    break;
                case 2:
                    System.out.print("\nEnter airport code: ");
                    code = sc.nextLine(); // Get the airport code
                    System.out.println("Airport Code: " + code + ", " + hash.get(code)); // Display the airport information
                    System.out.println();
                    break;
                case 3:
                    System.out.print("\nEnter airport code: "); // Get the airport code
                    code = sc.nextLine();
                    hash.remove(code); // Remove the airport information
                    System.out.println("Airport Code: " + code + " and its information has been deleted"); // Display the airport information
                    System.out.println();
                    break;
                case 4:
                    System.out.println("\nAll airport information:");
                    hash.displayAll(); // Display all the airport information
                    System.out.println();
                    break;
                case 5:
                    System.out.println("\nThank you for using our program! Exiting..."); // Exit the program
                    System.out.println();
                    break;
                default:
                    System.out.println("\nInvalid choice");
                    System.out.println();
            }
        }
        sc.close();
    }
}
