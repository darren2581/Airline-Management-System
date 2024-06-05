public class DSAListNode 
{
    private Object value; // Value of the node
    private DSAListNode next; // Reference to the next node
    private DSAListNode prev; // Reference to the previous node
    
    public DSAListNode(Object inValue) // Constructor
    {
        value = inValue;
        next = null;
        prev = null;
    }
    
    public Object getValue() // Accessor Get the value of the node
    {
        return value;
    }

    public void setValue(Object newValue) // Mutator Set the value of the node
    {
        value = newValue;
    }
    
    public DSAListNode getNext() // Accessor Get the next node
    {
        return next;
    }
    
    public void setNext(DSAListNode newNext) // Mutator Set the next node
    { 
        next = newNext;
    }

    public DSAListNode getPrev() // Accessor Get the previous node
    {
        return prev;
    }

    public void setPrev(DSAListNode newPrev) // Mutator Set the previous node
    {
        prev = newPrev;
    }
}
