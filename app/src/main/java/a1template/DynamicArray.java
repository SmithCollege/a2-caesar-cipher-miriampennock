// Do not change the line below. It lets Gradle find your 
// Classes to build the project
package a1template;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DynamicArray<T> implements IndexAccess<T>{
    
    //Instance Variables
    private Object[] array;
    private int size;

    //Constructor to make a new DynamicArray Object from an array
    public DynamicArray() {
        this.array = new Object[10]; //Default initial capacity, this changed later
        this.size = 0;
    }

    /**
     * Doubles the capacity of the internal array when it reaches full capacity.
     */
    public void grow() {
        int newCapacity = array.length * 2;
        array = Arrays.copyOf(array, newCapacity);
    }

    /**
     * Adds a new element to the end of the dynamic array.
     * If the array is full, it grows to accommodate more elements.
     *
     * @param val The value to add to the array.
     */
    public void add(T val) {
        if (size == array.length) {
            grow();
        }
        array[size++] = val;
    }

    /**
     * Retrieves the element at the specified index.
     *
     * @param i The index of the element to retrieve.
     * @return The element at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    @SuppressWarnings("unchecked")
    public T get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return (T) array[i];
    }

    /**
     * Retrieves the element at an index offset from a given position.
     *
     * @param i The starting index.
     * @param offset The offset from the starting index.
     * @return The element at the computed index.
     */
    @SuppressWarnings("unchecked")
    public T get(int i, int offset) {
        int newIndex = (i + offset) % size;
        if (newIndex < 0) newIndex += size; // Handle negative indices
        return (T) array[newIndex];
    }

    /**
     * Sets the value at the specified index.
     *
     * @param i The index to set the value at.
     * @param val The new value to store at the index.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public void set(int i, T val) {
        if (i < 0 || i >= size) throw new IndexOutOfBoundsException("Index out of bounds");
        array[i] = val;
    }

    /**
     * Returns the number of elements currently stored in the dynamic array.
     *
     * @return The size of the dynamic array.
     */
    public int size() {
        return size;
    }
}