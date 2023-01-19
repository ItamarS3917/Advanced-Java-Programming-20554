import java.util.ArrayList;
import java.util.Iterator;

public class MyPriorityQueue <E> {

    private ArrayList<ArrayList<E>> myQueueArray; // 2D array to hold the elements in the priority queue
    private int pqSize; // variable to hold the current size of the priority queue

    private int queueInitSize; // variable to hold the initial size of the priority queue
    private int highestPriorityIndex; // variable to hold the index of the highest priority element in the priority queue

    private final int MAX_QUEUE_SIZE = 9; // constant to hold the maximum size of the priority queue

    // constructor to initialize the priority queue with a given size
    public MyPriorityQueue(int size) {

        pqSize = 0;
        highestPriorityIndex = -1;
        queueInitSize = size - 1;
        myQueueArray = new ArrayList<ArrayList<E>>();

        // creates 'size' number of ArrayList<E> objects
        for (int i = 0; i < size; i++) {
            myQueueArray.add(new ArrayList<E>());
        }
    }

    // method to add an element to the priority queue with a given priority
    public void add(E key, int priority) {
        int tempPriority = priority - 1;
        if (highestPriorityIndex == -1)
            highestPriorityIndex = tempPriority;

        else if(highestPriorityIndex > tempPriority)
            highestPriorityIndex = tempPriority;

        if(tempPriority > queueInitSize)
            myQueueArray.get(queueInitSize).add(key);
        else
            myQueueArray.get(tempPriority).add(key);
        pqSize += 1;
    }

    // method to get the current size of the priority queue
    public int getPqSize() {
        return pqSize;
    }

    // method to remove the highest priority element from the priority queue
    public E poll() {
        if (highestPriorityIndex == -1)
            return null;
        E tmp = myQueueArray.get(highestPriorityIndex).get(0);
        myQueueArray.get(highestPriorityIndex).remove(0);
        highestPriorityIndex = setHighestPriorityIndex();
        pqSize -= 1;
        return (E) tmp.toString();
    }

    // method to check if the priority queue contains a given element
    public boolean contains(E key) {
        boolean flag = false;
        for (ArrayList<E> es : myQueueArray) {
            for (int j = 0; j < es.size(); j++) {
                if (es.get(j).equals(key)) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    // helper method to set the index of the highest priority element in the priority queue
    private int setHighestPriorityIndex() {

        for (int i = 0; i < myQueueArray.size(); i++) {
            if(myQueueArray.get(i).size() > 0) {
                highestPriorityIndex = i;
                return highestPriorityIndex;
            }
        }

        // method to remove the highest priority element from the priority queue and print it
        public boolean remove() {
            if(highestPriorityIndex == -1)
                return false;
            System.out.println(this.myQueueArray.get(highestPriorityIndex).remove(0));
            pqSize -= 1;
            return true;
        }

        // method to print the current elements in the priority queue
        public void getList() {
            System.out.println(myQueueArray);
        }

        // method to return an iterator for the elements in the priority queue
        public Iterator <E> iterator() {
            ArrayList<E> aList = new ArrayList<E>();
            for (ArrayList<E> es : myQueueArray) {
                aList.addAll(es);
            }
            return aList.iterator();
        }

        // override the toString method
        @Override
        public String toString() {
            return super.toString();
        }
    }
