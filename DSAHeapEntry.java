public class DSAHeapEntry 
{
    private int priority;
    private Object value;

    public DSAHeapEntry(int inPriority, Object inValue) // Constructor
    {
        priority = inPriority;
        value = inValue;
    }

    public void setPriority(int inPriority) // Mutator Set the priority of the entry
    {
        priority = inPriority;
    }

    public int getPriority() // Accessor Get the priority of the entry 
    {
        return priority;
    }

    public void setValue(Object inValue) // Mutator Set the value of the entry
    {
        value = inValue;
    }

    public Object getValue() // Accessor Get the value of the entry
    {
        return value;
    }
}
