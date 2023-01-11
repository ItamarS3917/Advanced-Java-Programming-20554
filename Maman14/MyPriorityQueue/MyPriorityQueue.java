
import java.util.ArrayList;
import java.util.Iterator;

public class MyPriorityQueue <E> {

    private ArrayList<ArrayList<E>> myQueueArray;
    private int pqSize;

    private int queueInitSize;
    private int highestPriorityIndex;

    private final int MAX_QUEUE_SIZE = 9;

    public MyPriorityQueue(int size) {

        pqSize = 0;
        highestPriorityIndex = -1;
        queueInitSize = size - 1;
        myQueueArray = new ArrayList<ArrayList<E>>();

        for (int i = 0; i < size; i++) {
            myQueueArray.add(new ArrayList<E>());
        }
    }


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

    public int getPqSize() {
        return pqSize;
    }

    public E poll() {
        if (highestPriorityIndex == -1)
            return null;
        E tmp = myQueueArray.get(highestPriorityIndex).get(0);
        myQueueArray.get(highestPriorityIndex).remove(0);
        highestPriorityIndex = setHighestPriorityIndex();
        pqSize -= 1;
        return (E) tmp.toString();
    }

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

    private int setHighestPriorityIndex() {

        for (int i = 0; i < myQueueArray.size(); i++) {
            if(myQueueArray.get(i).size() > 0) {
                highestPriorityIndex = i;
                return highestPriorityIndex;
            }
        }
        return -1; //the priority queue is empty
    }

    public boolean remove() {
        if(highestPriorityIndex == -1)
            return false;
        System.out.println(this.myQueueArray.get(highestPriorityIndex).remove(0));
        pqSize -= 1;
        return true;
    }

    public void getList() {
        System.out.println(myQueueArray);
    }

    public Iterator <E> iterator() {
        ArrayList<E> aList = new ArrayList<E>();
        for (ArrayList<E> es : myQueueArray) {
            aList.addAll(es);
        }
        return aList.iterator();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

