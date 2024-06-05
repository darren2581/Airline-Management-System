public class DSAGraphEdge 
{
    private DSAGraphVertex adjacentVertex;
    private int weight;

    public DSAGraphEdge(DSAGraphVertex vertex, int inWeight) // Constructor
    {
        adjacentVertex = vertex;
        weight = inWeight;
    }

    public DSAGraphVertex getAdjacentVertex() // Accessor methods
    {
        return adjacentVertex;
    }

    public int getWeight() // Accessor methods
    {
        return weight;
    }
}
