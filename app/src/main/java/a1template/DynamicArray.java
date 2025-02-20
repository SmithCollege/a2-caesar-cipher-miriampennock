// Do not change the line below. It lets Gradle find your 
// Classes to build the project
package a1template;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DynamicArray<T> implements IndexAccess<T>{
    
    // What instance variables do you need?
    private Object[] array;
    private int size;
    // Write a constructor to make a new DynamicArray Object from an array
    public DynamicArray() {
        this.array = new Object[10]; //Default initial capacity
        this.size = 0;
    }

    public void grow() {
        int newCapacity = array.length * 2;
        array = Arrays.copyOf(array, newCapacity);
    }

    public void add(T val) {
        if (size == array.length) {
            grow();
        }
        array[size++] = val;
    }
    @SuppressWarnings("unchecked")
    public T get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return (T) array[i];
    }

    @SuppressWarnings("unchecked")
    public T get(int i, int offset) {
        int newIndex = (i + offset) % size;
        if (newIndex < 0) newIndex += size; // Handle negative indices
        return (T) array[newIndex];
    }

    public void set(int i, T val) {
        if (i < 0 || i >= size) throw new IndexOutOfBoundsException("Index out of bounds");
        array[i] = val;
    }

    public int size() {
        return size;
    }
    // Now implement the methods from IndexAccess?

}