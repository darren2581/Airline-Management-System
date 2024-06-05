import java.util.*;

public class Ques3 {
    public static void main(String[] args) 
    {
        DSAGraph graph = new DSAGraph(); // Create a new graph object
        FileIO file = new FileIO(); // Create a new file object
        DSAHeap heap = file.getHeap(); // Get the populated heap and display its contents

        // Inserting airport information
        graph.addVertex("MEL", "Melbourne Tullamarine (MEL) Airport");
        graph.addVertex("JFK", "John F. Kennedy International Airport");
        graph.addVertex("LAX", "Los Angeles International Airport");
        graph.addVertex("LHR", "London Heathrow Airport");
        graph.addVertex("BKK", "Bangkok Suvarnabhumi Airport");

        // Inserting routes
        graph.addEdge("MEL", "JFK", 300);
        graph.addEdge("MEL", "LHR", 200);
        graph.addEdge("JFK", "BKK", 700);
        graph.addEdge("JFK", "LAX", 500);
        graph.addEdge("BKK", "LAX", 200);
        graph.addEdge("LAX", "LHR", 100);

        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to sort the edge according:");
        System.out.println("1. Distance");
        System.out.println("2. Layover");
        System.out.print("Enter your Selection: ");
        int choice = sc.nextInt(); // Get the user's choice for sorting
        switch (choice)
        {
            case 1:
            {
                Scanner distance = new Scanner(System.in);
                System.out.print("Enter the origin airport: ");
                String origin = distance.nextLine(); // Get the origin airport
                System.out.print("Enter the destination airport: ");
                String destination = distance.nextLine(); // Get the destination airport
                System.out.println("\nTrip Route before Sorting: \n");
                graph.BFS(origin, destination); // Display the trip route before sorting
                file.readFromFile(1); // Read the file and populate the heap
                break;
            }
            case 2:
            {
                Scanner layover = new Scanner(System.in);
                System.out.print("Enter the origin airport: ");
                String origin = layover.nextLine(); // Get the origin airport
                System.out.print("Enter the destination airport: ");
                String destination = layover.nextLine(); // Get the destination airport
                System.out.println("\nTrip Route before Sorting: \n");
                graph.BFS(origin, destination); // Display the trip route before sorting
                file.readFromFile(2); // Read the file and populate the heap
                break;
            }
            default:
            {
                System.out.println("Invalid choice");
                break;
            }
        }
        System.out.println("\nTrip Route after Sorting: ");
        heap.heapSort(); // Sort the heap
        heap.heapify(); // Heapify the heap
        if (choice == 1) // Display the trip route after sorting accorind to distance
        {
            heap.display(1);
        }
        if (choice == 2) // Display the trip route after sorting according to layovers
        {
            heap.display(2);
        }
        System.out.println("\nYour trip has been sorted according to the selected option.\n");
    }
}
