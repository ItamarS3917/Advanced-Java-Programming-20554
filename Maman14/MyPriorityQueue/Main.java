import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        MyPriorityQueue <String> a  = new MyPriorityQueue<>(7);

        //tests for String type
        System.out.println("Testing empty queue\n");
        System.out.println(a.remove()); // test removing an element from an empty queue
        System.out.println(a.poll()); // test polling an element from an empty queue
        System.out.println(a.contains("abc")); // test checking if an element is in an empty queue
        System.out.println("size " +a.getPqSize()); // test getting the size of an empty queue
        System.out.println("-----------------------------------------------------------\n");
        System.out.println("Adding values to queue\n");
        a.add("1 Entrance",4 ); // test adding elements with different priorities
        a.add("2 Entrance", 1);
        a.add("3 Entrance",1 );
        a.add("4 Entrance",9 );
        a.add("5 Entrance",1 );
        a.add("6 Entrance",3 );
        a.add("7 Entrance",4 );
        a.add("8 Entrance",2 );
        a.add("9 Entrance",5 );
        a.add("10 Entrance",5 );
        a.add("11 Entrance",1 );
        System.out.println("size " +a.getPqSize()); // test getting the size of the queue after adding elements
        System.out.println("\nTesting class methods\n");
        System.out.println(a.contains("11 Entrance")); // test checking if an element is in the queue
        System.out.println(a.poll()); // test polling elements with different priorities
        System.out.println(a.poll());
        System.out.println(a.poll());
        System.out.println(a.poll());
        System.out.println(a.poll());
        System.out.println(a.contains("abc")); // test checking if an element is in the queue after polling elements
        System.out.println("size " +a.getPqSize()); // test getting the size of the queue after polling elements

        System.out.println("\nIterator test");
        Iterator<String> iterator = a.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            System.out.println(s); // test iterating through the elements in the queue
        }
        System.out.println("-----------------------------------------------------------\n");
        System.out.println("\nTesting Customer Class\n");

        MyPriorityQueue <CustomerInquiries> b = new MyPriorityQueue<>(7);
        CustomerInquiries t = new CustomerInquiries("Tim", "Deposit", 2020);
        CustomerInquiries u = new CustomerInquiries("Itamar", "Deposit", 2020);
        CustomerInquiries v = new CustomerInquiries("Moshe", "Withdraw", 2020);
        CustomerInquiries w = new CustomerInquiries("Danny", "Check balance", 2020);
        CustomerInquiries x = new CustomerInqu
        // tests for CustomerInquiries type
        System.out.println(b.remove()); // test removing an element from an empty queue
        System.out.println(b.poll()); // test polling an element from an empty queue
        System.out.println("size " +b.getPqSize()); // test getting the size of an empty queue
        System.out.println("Adding values to queue\n");
        b.add(t, 1); // test adding elements with different priorities
        b.add(u, 3);
        b.add(v, 9);
        System.out.println(b.contains(z)); // test checking if an element is in the queue
        b.add(w, 3);
        b.add(x, 5);
        b.add(y, 1);
        b.add(z, 2);
        System.out.println("size " +b.getPqSize()); // test getting the size of the queue after adding elements
        System.out.println("\nequals method\n");
        System.out.println(t.equals(u)); // test the equals method for the CustomerInquiries class
        System.out.println(t.equals(z));
        System.out.println(b.poll()); // test polling elements with different priorities
        System.out.println(b.poll());
        System.out.println(b.remove());
        System.out.println("size " +b.getPqSize()); // test getting the size of the queue after polling elements

        System.out.println("\nIterator test");
        Iterator<CustomerInquiries> inquiriesIterator = b.iterator();
        while (inquiriesIterator.hasNext()) {
            String s = String.valueOf(inquiriesIterator.next());
            System.out.println(s); // test iterating through the elements in the queue
        }
    }
}
