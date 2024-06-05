import java.util.Scanner;

public class Ques1 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        DSAGraph graph = new DSAGraph(); // Create a new graph object
        
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

        graph.displayList(); // Display the adjacent list

        System.out.println("\n\nPlease enter your origin airport and destination airport!");
        System.out.print("Enter the the Origin Aiport: ");
        String origin = sc.nextLine();
        System.out.print("Enter the Destination Aiport: ");
        String destination = sc.nextLine();

        System.out.println("\nBreadth First Search:");
        graph.BFS(origin, destination); // Display the trip route after sorting
    }
}
