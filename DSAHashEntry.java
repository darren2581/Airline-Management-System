public class DSAHashEntry 
{
    private String key;
    private Object value;
    private int state; // 0 = empty, 1 = active, 2 = deleted

    public DSAHashEntry() // Default Constructor
    {
        key = null;
        value = null;
        state = 0; // 0 empty
    }

    public DSAHashEntry(String inKey, Object inValue) // Constructor
    {
        key = inKey;
        value = inValue;
        state = 1; // 1 active
    }

    public void setKey(String inKey) // Mutator
    {
        key = inKey;
    }

    public String getKey() // Accessor
    {
        return key;
    }

    public void setValue(Object inValue) // Mutator
    {
        value = inValue;
    }

    public Object getValue() // Accessor
    {
        return value;
    }

    public void setState(int inState) // Mutator
    {
        state = inState;
    }

    public int getState() // Accessor
    {
        return state;
    }
}
