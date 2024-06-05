import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO 
{
    private DSAHeap heap; 

    public FileIO() // Constructor
    {
        heap = new DSAHeap(10); // Create a new DSAHeap object
    }

    public void writeToFile(DSALinkedList path, int layover, int distance) // Write the results of the BFS to a file
    {
        String fileName = "HeapSort.txt"; // Name of the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) // Open the file for writing
        {
            for (int i = 0; i < path.getCount(); i++)  // Loop through the elements in the path
            {
                writer.write(path.peek(i).toString()); // Convert object to string
                if (i < path.getCount() - 1) // Check if the element is not the last element
                {
                    writer.write(" --> ");
                }
            }
            writer.write(", " + layover + ", " + distance + "\n");
        } 
        catch (IOException e) 
        {
            System.err.println("Error writing BFS results to file: " + e.getMessage()); // Error message
        }
    }

    public void readFromFile(int choice) // Read the results of the BFS from a file
    {
        String fileName = "HeapSort.txt"; // Name of the file
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) // Open the file for reading
        {
            String line;
            while ((line = br.readLine()) != null) // Loop through the lines in the file
            {
                String[] parts = line.split(",");
                String route = parts[0].trim(); // Get the route
                int layover = Integer.parseInt(parts[1].trim()); // Get the layover
                int distance = Integer.parseInt(parts[2].trim()); // Get the distance
                if (choice == 1) // Check if the user wants to display the trip routes for the shortest distance
                {
                    heap.add(distance, route); // Add the distance and route to the heap
                } 
                if (choice == 2) // Check if the user wants to display the trip routes for the lesser layovers
                {
                    heap.add(layover, route); // Add the layover and route to the heap
                }
            }
        }
        catch (IOException | NumberFormatException e) // Catch exceptions
        {
            e.printStackTrace();
        }
    }

    public DSAHeap getHeap() // Accessor Get the heap
    {
        return heap;
    }
}