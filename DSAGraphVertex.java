public class DSAGraphVertex 
{
    private String label;
    private Object value;
    private boolean isVisited;
    private DSALinkedList edges;

    public DSAGraphVertex(String inLabel, Object inValue) // Constructor
    {
        label = inLabel;
        value = inValue;
        isVisited = false;
        edges = new DSALinkedList();
    }

    public String getLabel() // Accessor
    {
        return label;
    }

    public Object getValue() // Accessor
    {
        return value;
    }

    public DSALinkedList getAdjacent() // Accessor
    {
        DSALinkedList adjacentVertices = new DSALinkedList(); // List to store adjacent vertices
        for (int i = 0; i < edges.getCount(); i++) // Loop through all edges
        {
            DSAGraphEdge edge = (DSAGraphEdge) edges.peek(i); // Get the edge
            adjacentVertices.insertLast(edge.getAdjacentVertex()); // Add the adjacent vertex to the list
        }
        return adjacentVertices;
    }

    public DSALinkedList getEdges() // Accessor
    {
        return edges;
    }

    public boolean getIsVisited() // Accessor
    {
        return isVisited;
    }

    public void addEdge(DSAGraphVertex vertex, int weight) // Mutator
    {
        edges.insertLast(new DSAGraphEdge(vertex, weight)); // Add an edge to the vertex
    }

    public void setIsVisited(boolean inIsVisited) // Mutator
    {
        isVisited = inIsVisited;
    }

    public String displayWeigthEdge() // Display Edge Weight method
    {
        String adjacentList = ""; // String to store the adjacent vertices
        for (int i = 0; i < edges.getCount(); i++) 
        { // Loop through all edges
            DSAGraphEdge edge = (DSAGraphEdge) edges.peek(i); // Get the edge
            DSAGraphVertex adjVertex = edge.getAdjacentVertex(); // Get the adjacent vertex
            int weight = edge.getWeight(); // Get the weight
            adjacentList += "(" + this.getLabel() + " to " + adjVertex.getLabel() + ", Distance: " + weight + "KM) "; // Output the adjacent vertex
        }
        return adjacentList;
    }    
    
    public void removeEdge(DSAGraphVertex vertex) // Mutator
    {
        DSALinkedList edgesToRemove = new DSALinkedList(); // Temporary list to store edges to remove
        for (int i = 0; i < edges.getCount(); i++) // loop through all edges
        {
            DSAGraphEdge edge = (DSAGraphEdge) edges.peek(i); // Get the edge
            if (edge.getAdjacentVertex().equals(vertex)) // If the edge is connected to the vertex to remove
            {
                edgesToRemove.insertLast(edge); // Mark the edge for removal
            }
        }
        for (int i = 0; i < edgesToRemove.getCount(); i++) // loop through all edges to remove
        {
            DSAGraphEdge edge = (DSAGraphEdge) edgesToRemove.peek(i); // Get the edge
            edges.remove(edge); // Remove the edge
        }        
    }
}
