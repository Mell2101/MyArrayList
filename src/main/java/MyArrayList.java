import java.util.*;

/**
 * This is a simple implementation of a container
 * class that includes the basic methods of the ArrayList class.
 *
 * The add operation runs in amortized constant time,
 * that is, adding n elements requires O(n) time.
 */

public class MyArrayList<E> {
    //Fields
    //====================================================
    /**
     * Default initial capacity
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * Zero capacity used for empty instances
     */
    private static final int ZERO_CAPACITY = 0;
    /**
     * The array buffer into which the elements of the ArrayList are stored.
     * The capacity of the ArrayList is the length of this array buffer.
     */
    private Object[] elements;
    /**
     * The size of the ArrayList (the number of elements it contains)
     */
    private int size;
    //=====================================================

    //Constructors
    //=====================================================

    /**
     * Default constructor. Constructs an empty list with an initial
     * capacity of ten.
     */
    public MyArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = ZERO_CAPACITY;
    }

    /**
     * Constructs an empty list with the specified initial capacity
     * @param initialCapacity - he initial capacity of the list
     */
    public MyArrayList(int initialCapacity){
        if(initialCapacity > 0) {
            this.elements = new Object[initialCapacity];
        } else {
            this.elements = new Object[DEFAULT_CAPACITY];
        }
    }

    /**
     * Constructor of copy.Constructs a list containing the elements of
     * the specified collection, in the order they are returned by the
     * collection's iterator
     * @param collection - the collection whose elements are to be placed into this list
     */
    public MyArrayList(Collection<? extends E> collection){
        Object[] a = collection.toArray();
        if ((size = a.length) != 0) {
            if (collection.getClass() == ArrayList.class) {
                elements = a;
            } else {
                elements = Arrays.copyOf(a, size, Object[].class);
            }
        } else {
            // replace with empty array.
            elements = new Object[ZERO_CAPACITY];
        }
    }
    //==========================================================

    //Methods
    //==========================================================

    /**
     *The method allowing dynamic expansion of the ArrayList capacity.
     */
    private void increaseCapacity() {
        int newCapacity = elements.length * 2;
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(elements, 0, newArray, 0, size);
        elements = newArray;
    }

    /**
     * Appends the specified element to the end of this list.
     * @param element - element to be appended to this list
     */
    public void add(E element) {
        if (size == elements.length) {
            increaseCapacity();
        }
        elements[size++] = element;
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index - index of the element to return
     * @return the element at the specified position in this list
     * Throws: IndexOutOfBoundsException – if the index is out of range (index < 0 || index >= size())
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) elements[index];
    }

    /**
     * Returns the current number of elements in the container.
     * @return the current number of elements in the container
     */
    public int size() {
        return size;
    }

    /**
     * Removing an element from the container by value.
     * @param element - The value of the container element.
     * @return true if element removed, false if element did`t remove
     */
    public boolean remove(E element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                removeAtIndex(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Remove element by index
     * @param index - index of the element to remove
     * @return removed element by index
     * Throws: IndexOutOfBoundsException – if the index is out of range (index < 0 || index >= size())
     */
    public E removeAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        E removedElement = (E) elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null; // Set the last element to null
        return removedElement;
    }

    /**
     * Removing all elements.
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = ZERO_CAPACITY;
    }

    /**
     * Sorting the elements of the container.
     */
    public void sort() {
        Arrays.sort((E[]) elements, 0, size);
    }

    public void quickSort(Comparator<? super E> comparator) {
        quickSort(0, size() - 1, comparator);
    }

    private void quickSort(int low, int high, Comparator<? super E> comparator) {
        if (low < high) {
            int pi = partition(low, high, comparator);
            quickSort(low, pi - 1, comparator);
            quickSort(pi + 1, high, comparator);
        }
    }

    private int partition(int low, int high, Comparator<? super E> comparator) {
        E pivot = (E) elements[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (comparator != null) {
                if (comparator.compare((E) elements[j], pivot) < 0) {
                    i++;
                    swap(i, j);
                }
            } else {
                if (((Comparable<E>) elements[j]).compareTo(pivot) < 0) {
                    i++;
                    swap(i, j);
                }
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    private void swap(int i, int j) {
        Object temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            result.append(elements[i]);
            if (i != size - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }
    //==========================================================

}
