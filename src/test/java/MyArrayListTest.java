import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    @Test
    void add() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        int index = 0;
        for( ; index < 1000; index++ ){
            myArrayList.add(index);
        }
        assertEquals(myArrayList.size(), index);
    }

    @Test
    void remove() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        int index = 0;
        for( ; index < 1000; index++ ){
            myArrayList.add(index);
        }

        assertTrue(myArrayList.remove(58));

    }

    @Test
    void removeAtIndex() {

        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        int index = 0;
        for( ; index < 1000; index++ ){
            myArrayList.add(index);
        }

        assertEquals(myArrayList.removeAtIndex(5), 5);

    }

    @Test
    void clear() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        int index = 0;
        for( ; index < 1000; index++ ){
            myArrayList.add(index);
        }

        myArrayList.clear();

        assertEquals(myArrayList.size(), 0);

    }

    @Test
    void sort() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        Object[] array = new Object[1000];

        for(int index = 0 ; index < 1000; index++ ){
            int random = 1 + (int) (Math.random() * 1000);
            array[index] = random ;
            myArrayList.add(random);
        }

        Arrays.sort(array,0,1000);
        myArrayList.sort();

        assertArrayEquals(myArrayList.toArray(), array);

    }

    @Test
    void get() {

        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        int index = 0;
        for( ; index < 1000; index++ ){
            myArrayList.add(index);
        }

        // Returns the element at the specified position
        // in this list element == 5
        assertEquals(myArrayList.get(5),5);

    }

    @Test
    void testToString() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        Object[] array = new Object[1000];

        for(int index = 0 ; index < 1000; index++ ) {

            array[index] = index;
            myArrayList.add(index);
        }

        // String builder fot array
        StringBuilder arrayString = new StringBuilder("[");
        for (int i = 0; i < 1000; i++) {
            arrayString.append(array[i]);
            if (i != 999) {
                arrayString.append(", ");
            }
        }
        arrayString.append("]");

        String myArrayListString = myArrayList.toString();

        // String myArrayListString == arrayString
        assertEquals(myArrayListString, arrayString.toString());

    }

    @Test
    void toArray() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        Object[] array = new Object[1000];

        for(int index = 0 ; index < 1000; index++ ){
            int random = 1 + (int) (Math.random() * 1000);
            array[index] = random ;
            myArrayList.add(random);
        }

        //myArrayList like array == array;
        assertArrayEquals(myArrayList.toArray(), array);
    }

    @Test
    void quickSort() {

        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        Object[] array = new Object[1000];

        Comparator<Object> comparator = null;

        for(int index = 0 ; index < 1000; index++ ){
            int random = 1 + (int) (Math.random() * 1000);
            array[index] = random;
            myArrayList.add(random);
        }


        Arrays.sort(array);
        myArrayList.quickSort(comparator);

        assertArrayEquals(myArrayList.toArray(), array);

    }
}