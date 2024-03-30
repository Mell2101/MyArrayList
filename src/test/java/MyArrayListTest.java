import org.junit.jupiter.api.Test;
import java.util.Arrays;
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

}