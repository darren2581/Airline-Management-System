public class DSAGraph 
{
    DSALinkedList vertices; // List of vertices

    public DSAGraph() // Constructor of DSAGraph
    {
        vertices = new DSALinkedList(); // Create a new list of vertices
    }

    public void addVertex(String label, Object value) // Add a vertex to the graph
    {
        if (label == null) // If the label is null
        {
            throw new IllegalArgumentException("Label cannot be empty");
        }
        else
        {
            if(!hasVertex(label)) //if no such vertex found in list
            {
                DSAGraphVertex vertex = new DSAGraphVertex(label, value); // Create a new vertex to accesss DSAGraphVertex class
                vertices.insertLast(vertex); // Insert the vertex to the list
            }
        }
    }

    public boolean hasVertex(String label) // Check if the vertex exists
    {
        boolean found = false; // Set found to false
        DSAGraphVertex vertex; // Create a new vertex
        for (int i = 0; i < vertices.getCount(); i++) // Loop through the vertices list
        {
            vertex = (DSAGraphVertex)vertices.peek(i); // Get the vertex at the index
            if (vertex.getLabel().equals(label)) // If the vertex's label is the same as the label
            {
                found = true; // Set found to true
                break;
            }
        }
        return found; 
    }

    public void addEdge(String label1, String label2, int weight) // Add an edge between two vertices
    {
        if(!hasVertex(label1) || !hasVertex(label2)) // If the vertices do not exist
        {
            throw new IllegalArgumentException("Vertex not found");
        }
        else
        {
            DSAGraphVertex vertex1 = getVertex(label1); // Get the first vertex
            DSAGraphVertex vertex2 = getVertex(label2); // Get the second vertex
            vertex1.addEdge(vertex2, weight); // Add an edge between the two vertices
            vertex2.addEdge(vertex1, weight); 
        }
    }

    public boolean hasEdge(String label1, String label2) // Check if an edge exists between two vertices
    {
        boolean found = false; // Set found to false
        DSAGraphVertex vertex1 = getVertex(label1); // Get the first vertex
        DSAGraphVertex vertex2 = getVertex(label2); // Get the second vertex
        DSALinkedList adjacent = vertex1.getAdjacent(); // Get the adjacent vertices of the first vertex
        for (int i = 0; i < adjacent.getCount(); i++) // Loop through the adjacent vertices
        {
            if (adjacent.peek(i).equals(vertex2)) // If the adjacent vertex is the same as the second vertex
            {
                found = true; // Set found to true
                break;
            }
        }
        return found;
    }

    public DSAGraphVertex getVertex(String label) // Get a vertex by its label
    {
        DSAGraphVertex vertex = null; // Set vertex to null
        for (int i = 0; i < vertices.getCount(); i++) // Loop through the vertices list
        {
            vertex = (DSAGraphVertex)vertices.peek(i); // Get the vertex at the index
            if (vertex.getLabel().equals(label)) //if the vertex's label is same
            {
                break; 
            }
        }
        return vertex;
    }

    public DSALinkedList getAdjacent(String label) // Get the adjacent vertices of a vertex
    {
        DSAGraphVertex vertex = null; // Set vertex to null
        DSALinkedList Adjacent = null; // Set Adjacent to null
        for (int i = 0; i < vertices.getCount(); i++) // Loop through the vertices list
        {
            vertex = (DSAGraphVertex)vertices.peek(i); // Get the vertex at the index
            if (vertex.getLabel().equals(label)) // If the vertex's label is the same as the label
            {
                Adjacent = vertex.getAdjacent(); // Get the adjacent vertices of the vertex
                break;
            }
        }
        return Adjacent;
    }

    public boolean isAdjacent(String label1, String label2) // Check if two vertices are adjacent
    {
        boolean found = false; // Set found to false
        DSAGraphVertex vertex1 = getVertex(label1); // Get the first vertex
        DSAGraphVertex vertex2 = getVertex(label2); // Get the second vertex
        DSALinkedList adjacent = vertex1.getAdjacent(); // Get the adjacent vertices of the first vertex
        for (int i = 0; i < adjacent.getCount(); i++) // Loop through the adjacent vertices
        {
            if (adjacent.peek(i).equals(vertex2)) // If the adjacent vertex is the same as the second vertex
            {
                found = true; // Set found to true
                break;
            }
        }
        return found;
    }

    public void displayList() // Display the list of vertices
    {
        DSAGraphVertex vertex; // Create a new vertex
        if (vertices.getCount() == 0) // If the list is empty
        {
            System.out.println("Empty List for vertices.");
        } 
        else 
        {
            for (int i = 0; i < vertices.getCount(); i++) // Loop through the vertices list
            {
                vertex = (DSAGraphVertex) vertices.peek(i); // Get the vertex at the index
                System.out.println(); // Print a new line
                System.out.println(vertex.getLabel() + " " + vertex.getValue() + " : \n" + vertex.displayWeigthEdge()); // Display the vertex's label, value and adjacent vertices with weights
            }
        }
    }    

    public void removeVertex(String label) // Remove a vertex from the graph
    {
        if (!hasVertex(label)) // If the vertex does not exist
        {
            throw new IllegalArgumentException("Vertex not found");
        }
        else
        {
            DSAGraphVertex vertex = getVertex(label); // Get the vertex
            DSAGraphVertex temp; // Create a new vertex
            for (int i = 0; i < vertices.getCount(); i++) // Loop through the vertices list
            {
                temp = (DSAGraphVertex)vertices.peek(i); // Get the vertex at the index
                temp.removeEdge(vertex); // Remove the edge between the vertex and the adjacent vertices
            }
            vertices.remove(vertex); // Remove the vertex from the list
        }
    }

    public void removeEdge(String label1, String label2) // Remove an edge between two vertices
    {
        if (!hasVertex(label1) || !hasVertex(label2)) // If the vertices do not exist
        {
            throw new IllegalArgumentException("Vertex not found");
        }
        else
        {
            DSAGraphVertex vertex1 = getVertex(label1); // Get the first vertex
            DSAGraphVertex vertex2 = getVertex(label2); // Get the second vertex

            removeEdgeBetweenVertices(vertex1, vertex2); // Remove the edge between the two vertices
            removeEdgeBetweenVertices(vertex2, vertex1); 
        }
    }

    private void removeEdgeBetweenVertices(DSAGraphVertex vertex1, DSAGraphVertex vertex2) // Remove an edge between two vertices
    {
        DSALinkedList edgesToRemove = new DSALinkedList(); // Create a new list of edges to remove
        for (int i = 0; i < vertex1.getEdges().getCount(); i++) // Loop through the edges of the first vertex
        {
            DSAGraphEdge edge = (DSAGraphEdge) vertex1.getEdges().peek(i); // Get the edge at the index
            if (edge.getAdjacentVertex().equals(vertex2))  // If the adjacent vertex is the same as the second vertex
            {
                edgesToRemove.insertLast(edge); // Mark the edge for removal
            }
        }
        for (int i = 0; i < edgesToRemove.getCount(); i++)  // Loop through the edges to remove
        {
            DSAGraphEdge edge = (DSAGraphEdge) edgesToRemove.peek(i); // Get the edge at the index
            vertex1.getEdges().remove(edge); // Remove the edge from the list of edges
        }
    }

    private int getEdgeWeight(DSAGraphVertex vertex1, DSAGraphVertex vertex2) // Get the weight of an edge between two vertices
    {
        for (int i = 0; i < vertex1.getEdges().getCount(); i++)  // Loop through the edges of the first vertex
        {
            DSAGraphEdge edge = (DSAGraphEdge) vertex1.getEdges().peek(i); // Get the edge at the index
            if (edge.getAdjacentVertex().equals(vertex2)) // If the adjacent vertex is the same as the second vertex
            {
                return edge.getWeight(); // Return the weight of the edge
            }
        }
        return -1; // Return -1 if the edge does not exist
    }

    public void BFS(String startLabel, String endLabel) // Breadth-first search
    {
        if (!hasVertex(startLabel) || !hasVertex(endLabel)) // If the start or end vertex does not exist
        {
            throw new IllegalArgumentException("Start or end vertex not found");
        }
        DSAGraphVertex startVertex = getVertex(startLabel); // Get the start vertex
        DSAGraphVertex endVertex = getVertex(endLabel); // Get the end vertex
        DSALinkedList queue = new DSALinkedList(); // Create a new queue
        FileIO file = new FileIO(); // Create a new file
        queue.insertLast(new Node(startVertex, new DSALinkedList(), 0, -1)); // Insert the start vertex into the queue
        System.out.println("BFS starting from vertex: " + startLabel + " to vertex: " + endLabel + " with max 2 layovers"); 
        boolean routeFound = false; // Set routeFound to false
        while (!queue.isEmpty()) // Loop while the queue is not empty
        {
            Node node = (Node)queue.removeFirst(); // Remove the first node from the queue
            DSAGraphVertex currentVertex = node.vertex; // Get the current vertex
            DSALinkedList path = node.path; // Get the path
            int distance = node.distance; // Get the distance
            int layovers = node.layovers; // Get the layovers
            path.insertLast(currentVertex.getLabel()); // Insert the current vertex into the path
            if (currentVertex.equals(endVertex)) // If the current vertex is the same as the end vertex
            {
                routeFound = true; // Set routeFound to true
                file.writeToFile(path, layovers, distance); // Write the path to the file
                displayRoute(path, distance, layovers); // Display the path
            }
            if (layovers < 2) // If the number of layovers is less than 2 (maximum 2 layovers)
            {
                DSALinkedList adjacentList = currentVertex.getAdjacent(); // Get the adjacent vertices
                for (int i = 0; i < adjacentList.getCount(); i++) // Loop through the adjacent vertices
                {
                    DSAGraphVertex adjacentVertex = (DSAGraphVertex) adjacentList.peek(i); // Get the adjacent vertex
                    int edgeWeight = getEdgeWeight(currentVertex, adjacentVertex); // Get the weight of the edge between the current vertex and the adjacent vertex
                    if (!path.contains(adjacentVertex.getLabel())) // If the path does not contain the adjacent vertex
                    {
                        DSALinkedList newPath = new DSALinkedList(); // Create a new path
                        for (int j = 0; j < path.getCount(); j++) // Loop through the path
                        {
                            newPath.insertLast(path.peek(j)); // Insert the vertex into the new path
                        }
                        queue.insertLast(new Node(adjacentVertex, newPath, distance + edgeWeight, layovers + 1)); // Insert the adjacent vertex into the queue
                    }
                }
            }
        }
        if (!routeFound) // If the route is not found
        {
            System.out.println("\nNo route found between " + startLabel + " and " + endLabel + " with a maximum of 2 layovers.");
        }
    }

    private void displayRoute(DSALinkedList path, int distance, int layovers) // Display the route
    {
        System.out.print("Trip Route: ");
        for (int i = 0; i < path.getCount(); i++)  // Loop through the path
        {
            System.out.print(path.peek(i)); // Print the vertex
            if (i < path.getCount() - 1) // If the vertex is not the last vertex
            {
                System.out.print(" --> "); 
            }
        }
        System.out.println(", Layovers: " + layovers + ", Distance: " + distance + "KM"); // Print the number of layovers and the distance
    }

    private class Node // Breadth-first search node
    {
        DSAGraphVertex vertex;
        DSALinkedList path;
        int distance;
        int layovers;

        Node(DSAGraphVertex vertex, DSALinkedList path, int distance, int layovers)  // Constructor of BFSNode
        {
            this.vertex = vertex;
            this.path = path;
            this.distance = distance;
            this.layovers = layovers;
        }
    }
}

