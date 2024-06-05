import java.util.*;

public class MainMenu
{
    public static void main(String[] args)
    {
        DSAGraph graph = new DSAGraph(); // Create a new graph object
        DSAHashTable hashTable = new DSAHashTable(10); // Create a new hash table object
        DSAHeap heap = new DSAHeap(10); // Create a new heap object
        Scanner sc = new Scanner(System.in); 
        int choice = -1; 

        while (choice != 0) // Loop until the user chooses to exit
        {
            System.out.println("\nWelcome to Airline Management System.");
            System.out.println("1. Add New Airport");
            System.out.println("2. Add New Route");
            System.out.println("3. Remove Airport");
            System.out.println("4. Remove Route");
            System.out.println("5. Display Routes");
            System.out.println("6. Display All Airports Information");
            System.out.println("7. Insert New Airport Information");
            System.out.println("8. Search Airport Information");
            System.out.println("9. Delete Airport Information");
            System.out.println("0. Exit");
            System.out.print("Please select an option: ");
            choice = sc.nextInt(); // Get the user's choice
            switch (choice)
            {
                case 1:
                {
                    AddNewAirport(graph, hashTable); // Add a new airport
                    break;
                }
                case 2:
                {
                    AddNewRoute(graph); // Add a new route
                    break;
                }
                case 3:
                {
                    RemoveAirport(graph, hashTable); // Remove an airport
                    break;
                }
                case 4:
                {
                    RemoveRoute(graph); // Remove a route
                    break;
                }
                case 5:
                {
                    DisplayRoute(graph); // Display all routes
                    break;
                }
                case 6:
                {
                    DisplayAirport(hashTable); // Display all airport information
                }
                case 7:
                {
                    AddNewAirport(graph, hashTable); // Add a new airport
                    break;
                }
                case 8:
                {
                    SearchAirport(hashTable); // Search for an airport
                    break;
                }
                case 9:
                {
                    RemoveAirport(graph, hashTable); // Remove an airport
                    break;
                }
                case 0:
                {
                    System.out.println("Exiting Program...");
                    break;
                }
                default:
                {
                    System.out.println("Invalid Option. Please try again.");
                    break;
                }
            }
        }
    }

    public static void AddNewAirport(DSAGraph graph, DSAHashTable hashTable) // Add a new airport
    {
        Scanner newAirport = new Scanner(System.in);
        System.out.println("\nAdd New Airport");
        System.out.print("Enter Airport Code: ");
        String airportCode = newAirport.nextLine(); // Get the airport code
        System.out.print("Enter Airport Name: ");
        String airportName = newAirport.nextLine(); // Get the airport name
        if (graph.hasVertex(airportCode) == true) // Check if the airport code already exists
        {
            System.out.println("Airport code already exists.");
        }
        else
        {
            graph.addVertex(airportCode, airportName); // Add the airport to the graph
            hashTable.put(airportCode, airportName); // Add the airport to the hash table
            System.out.println("Airport Code: " + airportCode + ", " + hashTable.get(airportCode) + " has been added.");
        }
    }

    public static void AddNewRoute(DSAGraph graph) // Add a new route
    {
        Scanner newRoute = new Scanner(System.in);
        System.out.println("\nAdd New Route");
        System.out.print("Enter Origin Airport Code: ");
        String sourceAirport = newRoute.nextLine(); // Get the origin airport code
        System.out.print("Enter Destination Airport Code: ");
        String destinationAirport = newRoute.nextLine(); // Get the destination airport code
        System.out.print("Enter Distance: ");
        int distance = newRoute.nextInt(); // Get the distance between the airports
        if (graph.hasVertex(sourceAirport) == false || graph.hasVertex(destinationAirport) == false) // Check if the airports exist
        {
            System.out.println("Airport code not found.");
        }
        else
        {
            if (graph.hasEdge(sourceAirport, destinationAirport)) // Check if the route already exists
            {
                System.out.println("Route from " + sourceAirport + " to " + destinationAirport + " already exists.");
            }
            else
            {
                graph.addEdge(sourceAirport, destinationAirport, distance); // Add the route to the graph
                System.out.println("Route from " + sourceAirport + " to " + destinationAirport + " with distance " + distance + "KM has been added.");
            }
        }
    }

    public static void RemoveAirport(DSAGraph graph, DSAHashTable hashTable) // Remove an airport
    {
        Scanner removeAirport = new Scanner(System.in); // Create a new scanner object
        System.out.println("\nRemove Airport"); 
        System.out.print("Enter Airport Code: ");
        String airportCode = removeAirport.nextLine(); // Get the airport code
        if (graph.hasVertex(airportCode) == false) // Check if the airport exists
        {
            System.out.println("Airport code not found.");
        }
        else
        {
            graph.removeVertex(airportCode); // Remove the airport from the graph
            hashTable.remove(airportCode); // Remove the airport from the hash table
            System.out.println("Airport " + airportCode + " has been removed.");
        }
    }

    public static void RemoveRoute(DSAGraph graph) // Remove a route
    {
        Scanner removeRoute = new Scanner(System.in); // Create a new scanner object

        System.out.println("\nRemove Route");
        System.out.print("Enter Origin Airport Code: ");
        String originAirport = removeRoute.nextLine(); // Get the origin airport code
        System.out.print("Enter Destination Airport Code: ");
        String destinationAirport = removeRoute.nextLine(); // Get the destination airport code
        if (graph.hasVertex(originAirport) == false || graph.hasVertex(destinationAirport) == false) // Check if the airports exist
        {
            System.out.println("Airport code not found.");
        }
        else
        {
            if (graph.hasEdge(originAirport, destinationAirport)) // Check if the route exists
            {
                graph.removeEdge(originAirport, destinationAirport); // Remove the route from the graph
                System.out.println("Route from " + originAirport + " to " + destinationAirport + " has been removed.");
            }
            else
            {
                System.out.println("Route from " + originAirport + " to " + destinationAirport + " does not exist.");
            }
        }
    }

    public static void DisplayRoute(DSAGraph graph) // Display all routes
    {
        Scanner displayRoute = new Scanner(System.in);
        System.out.println("\nDisplay All Routes");
        System.out.print("Origin Airport Code: ");
        String originAirport = displayRoute.nextLine(); // Get the origin airport code
        System.out.print("Destination Airport Code: ");
        String destinationAirport = displayRoute.nextLine(); // Get the destination airport code

        if (graph.hasVertex(originAirport) == false || graph.hasVertex(destinationAirport) == false) // Check if the airports exist
        {
            System.out.println("Airport code not found.");
        }
        else
        {
            if (graph.hasEdge(originAirport, destinationAirport)) // Check if the route exists
            {
                graph.BFS(originAirport, destinationAirport); // Sort the routes
            }
            else
            {
                System.out.println("Route from " + originAirport + " to " + destinationAirport + " does not exist.");
            }
        }
    }

    public static void DisplayAirport(DSAHashTable hashTable) // Display all airport information
    {
        System.out.println("\nDisplay Airport Information");
        hashTable.displayAll(); // Display all airport information
    }

    public static void SearchAirport(DSAHashTable hashTable) // Search for an airport
    {
        Scanner searchAirport = new Scanner(System.in); // Create a new scanner object
        System.out.println("\nSearch Airport Information");
        System.out.print("Enter Airport Code: ");
        String airportCode = searchAirport.nextLine(); // Get the airport code
        if (hashTable.get(airportCode) != null) // Check if the airport code exists
        {
            System.out.println("Airport Code: " + airportCode + ", " + hashTable.get(airportCode));
        } 
        else 
        {
            System.out.println("Airport code not found.");
        }
    }
}