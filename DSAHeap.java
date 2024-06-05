public class DSAHeap 
{
    private DSAHeapEntry[] heapArray; // Array of DSAHeapEntry objects
    private int count; // Number of elements in the heap

    public DSAHeap(int maxSize) // Constructor
    {
        heapArray = new DSAHeapEntry[maxSize]; // Create an array of DSAHeapEntry objects
        count = 0;
    }

    public void add(int priority, Object value) // Add a new element to the heap
    {
        if (count == heapArray.length) // Check if the heap is full
        {
            resizeHeap();
        }
        DSAHeapEntry newEntry = new DSAHeapEntry(priority, value); // Create a new DSAHeapEntry object
        heapArray[count] = newEntry; // Add the new entry to the heap
        trickleUp(count); // Move the new entry up the heap
        count++;
    }

    public Object remove() // Remove the root element from the heap
    {
        if (count == 0) // Check if the heap is empty
        {
            throw new IllegalStateException("Heap is empty");
        }
        DSAHeapEntry root = heapArray[0]; // Get the root element
        count--;
        heapArray[0] = heapArray[count]; // Move the last element to the root
        trickleDown(0); // Move the new root down the heap
        return root.getValue(); // Return the root element
    }

    public void display(int choice) // Display the elements in the heap
    {
        for (int i = 0; i < count; i++) // Loop through the elements in the heap
        {
            if (choice == 1) // Check if the user wants to display the trip routes for the shortest distance
            {
                System.out.println("Trip Route: " + heapArray[i].getValue() + ", Distance " + heapArray[i].getPriority() + "KM");
            }
            if (choice == 2) // Check if the user wants to display the trip routes for the lesser layovers
            {
                System.out.println("Trip Route: " + heapArray[i].getValue() + ", Layover " + heapArray[i].getPriority() + " Stop");
            }
        }
    }

    public void heapify() // Convert the array into a heap
    {
        for (int i = count / 2 - 1; i >= 0; i--) // Loop through the elements in the heap
        {
            trickleDown(i); // Move the element down the heap
        }
    }

    public void heapSort() // Sort the elements in the heap
    {
        int oldCount = count; // Store the number of elements in the heap
        for (int i = oldCount - 1; i > 0; i--) // Loop through the elements in the heap
        {
            DSAHeapEntry temp = heapArray[i]; // Store the current element
            heapArray[i] = heapArray[0]; // Move the root element to the current element
            heapArray[0] = temp; // Move the current element to the root
            count--;
            trickleDown(0); // Move the new root down the heap
        }
        count = oldCount; //   Restore the number of elements in the heap
    }

    public int getCount() // Get the number of elements in the heap
    {
        return count;
    }

    private void trickleUp(int index) // Move an element up the heap
    {
        int parent = (index - 1) / 2; // Calculate the parent index
        DSAHeapEntry bottom = heapArray[index]; // Store the element
        while (index > 0 && heapArray[parent].getPriority() < bottom.getPriority()) // Loop until the element is at the root or the parent is greater than the element
        {
            heapArray[index] = heapArray[parent]; // Move the parent down the heap
            index = parent; // Move the element up the heap
            parent = (parent - 1) / 2; // Calculate the new parent index
        }
        heapArray[index] = bottom; // Add the element to the heap
    }

    public void trickleDown(int index) // Move an element down the heap
    {
        int largerChild; // Index of the larger child
        DSAHeapEntry top = heapArray[index]; // Store the element
        while (index < count / 2) // Loop until the element is a leaf
        {
            int leftChild = 2 * index + 1; // Calculate the left child index
            int rightChild = leftChild + 1; // Calculate the right child index
            if (rightChild < count && heapArray[leftChild].getPriority() < heapArray[rightChild].getPriority()) // Check if the right child is greater than the left child
            {
                largerChild = rightChild;
            } 
            else 
            {
                largerChild = leftChild;
            }
            if (top.getPriority() >= heapArray[largerChild].getPriority()) // Check if the element is greater than the larger child
            {
                break;
            }
            heapArray[index] = heapArray[largerChild]; // Move the larger child up the heap
            index = largerChild; // Move the element down the heap
        }
        heapArray[index] = top; // Add the element to the heap
    }

    public void resizeHeap() 
    {
        DSAHeapEntry[] newArray = new DSAHeapEntry[heapArray.length * 2]; // Create a new array with double the size
        for (int i = 0; i < heapArray.length; i++) // Loop through the elements in the heap
        {
            newArray[i] = heapArray[i]; // Copy the elements to the new array
        }
        heapArray = newArray; //
    }
}
