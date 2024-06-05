public class DSAHashTable 
{
    private DSAHashEntry[] hashArray; // Array of DSAHashEntry objects
    private int count;
    private static final double UPPER_THRESHOLD = 0.75; // Load factor to check how full the table is
    private static final double LOWER_THRESHOLD = 0.25; 

    public DSAHashTable(int tableSize) // Constructor
    {
        int actualSize = nextPrime(tableSize); // Find the next prime number
        hashArray = new DSAHashEntry[actualSize]; // Create an array of DSAHashEntry objects
        for (int i = 0; i < actualSize; i++)  // Loop through the array
        {
            hashArray[i] = new DSAHashEntry(); // Create a new DSAHashEntry object
        }
        count = 0;
    }

    private int nextPrime(int startVal) // Find the next prime number
    {
        int primeVal = startVal; // Start from the given value
        boolean isPrime = false; // Assume the number is not prime
        while (!isPrime) // Loop until a prime number is found
        {
            primeVal++; // Increment the value
            isPrime = true; // Assume the number is prime
            int sqrtPrimeVal = (int) Math.sqrt(primeVal); // Find the square root of the number
            for (int i = 2; i <= sqrtPrimeVal; i++) // Loop through the numbers
            {
                if (primeVal % i == 0) // Check if the number is divisible by another number
                {
                    isPrime = false; // The number is not prime
                    break;
                }
            }
        }
        return primeVal;
    }

    public int hashFunction(String key) // Hash function to generate a hash value
    {
        int hashValue = 0; // Initialize the hash value
        int multiplier = 31; // Multiplier to generate the hash value
        for (int i = 0; i < key.length(); i++) // Loop through the characters of the key
        {
            hashValue = (multiplier * hashValue + key.charAt(i)) % hashArray.length; // Generate the hash value using the multiplier
        }
        return hashValue;
    }

    public int linearProbe(int hashIdx, String key) // Linear probing to resolve collisions
    {
        int currentIndex = hashIdx; // Initialize the current index
        while (hashArray[currentIndex].getState() == 1 && !hashArray[currentIndex].getKey().equals(key)) // Loop until an empty slot is found
        {
            currentIndex = (currentIndex + 1) % hashArray.length; // Move to the next slot
        }
        return currentIndex;
    }

    public void put(String key, Object value) // Insert a key-value pair into the hash table
    {
        int hashIdx = hashFunction(key); // Generate the hash value
        int newIdx = linearProbe(hashIdx, key); // Resolve collisions using linear probing
        if (hashArray[newIdx].getState() != 1) // Check if the slot is empty
        {
            hashArray[newIdx].setKey(key); // Set the key
            hashArray[newIdx].setValue(value); // Set the value
            hashArray[newIdx].setState(1); // Set the state to active
            count++;  
            checkAndResize(); // Check and resize the table if necessary
        } 
        else 
        {
            hashArray[newIdx].setValue(value); // Update the value if key already exists
        }
    }

    public Object get(String key) // Retrieve the value associated with a key
    {
        int hashIdx = hashFunction(key); // Generate the hash value
        int newIdx = linearProbe(hashIdx, key); // Resolve collisions using linear probing
        if (hashArray[newIdx].getState() == 1 && hashArray[newIdx].getKey().equals(key)) // Check if the key exists
        {
            return hashArray[newIdx].getValue(); // Return the value
        } 
        else 
        {
            return null;
        }
    }

    public void remove(String key) // Remove a key-value pair from the hash table
    {
        int hashIdx = hashFunction(key); // Generate the hash value
        int newIdx = linearProbe(hashIdx, key); // Resolve collisions using linear probing
        if (hashArray[newIdx].getState() == 1 && hashArray[newIdx].getKey().equals(key)) // Check if the key exists
        {
            hashArray[newIdx].setState(2); // Set the state to deleted
            count--;
            checkAndResize(); // Check and resize the table if necessary
        }
    }

    public void resize(int newSize) // Resize the hash table
    {
        DSAHashEntry[] oldArray = hashArray; // Store the old array
        hashArray = new DSAHashEntry[nextPrime(newSize)]; // Create a new array with a new size
        for (int i = 0; i < hashArray.length; i++) // Initialize the new array
        {
            hashArray[i] = new DSAHashEntry(); // Create a new DSAHashEntry object
        }
        int oldCount = count; // Store the old count
        count = 0; // Reset the count

        for (int i = 0; i < oldArray.length; i++) // Loop through the old array
        {
            DSAHashEntry entry = oldArray[i]; // Get the entry at the current index
            if (entry.getState() == 1) // Check if the entry is active (state 1)
            {
                // Rehash the entry into the new array directly
                int hashIdx = hashFunction(entry.getKey()); // Generate the hash value
                int newIdx = linearProbe(hashIdx, entry.getKey()); // Resolve collisions using linear probing
                hashArray[newIdx].setKey(entry.getKey()); // Set the key
                hashArray[newIdx].setValue(entry.getValue()); // Set the value
                hashArray[newIdx].setState(1); // Set the state to active
                count++; // Increase the count
            }
        }

        // Set the count to the correct value after rehashing
        count = oldCount;
    }

    public void checkAndResize() // Check if the table needs to be resized
    {
        double loadFactor = (double) count / hashArray.length; // Calculate the load factor
        if (loadFactor > UPPER_THRESHOLD) // Check if the load factor exceeds the upper threshold
        {
            resize(hashArray.length * 2); // Resize the table
        } 
        else if (loadFactor < LOWER_THRESHOLD && hashArray.length > 10) // Check if the load factor is below the lower threshold
        { 
            resize(hashArray.length / 2); // Resize the table and make sure it doesn't resize too small
        }
    }

    public void displayAll() // Display all key-value pairs in the hash table
    {
        for (int i = 0; i < hashArray.length; i++) // Loop through the array
        {
            DSAHashEntry info = hashArray[i]; // Get the entry at the current index
            if (info.getState() == 1) // Check if the entry is active
            {
                System.out.println("Airport Code: " + info.getKey() + ", " + info.getValue()); // Display the key-value pair
            }
        }
    }    
}
