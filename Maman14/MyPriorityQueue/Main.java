import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        MyPriorityQueue <String> a  = new MyPriorityQueue<>(7);


        //String Tests
        System.out.println("Testing empty queue\n");
        System.out.println(a.remove());
        System.out.println(a.poll());
        System.out.println(a.contains("abc"));
        System.out.println("size " +a.getPqSize());
        System.out.println("-----------------------------------------------------------\n");
        System.out.println("Adding values to queue\n");
        a.add("1 Entrance",4 );
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
        System.out.println("size " +a.getPqSize());
        System.out.println("\nTesting class methods\n");
        System.out.println(a.contains("11 Entrance"));
        System.out.println(a.poll());
        System.out.println(a.poll());
        System.out.println(a.poll());
        System.out.println(a.poll());
        System.out.println(a.poll());
        System.out.println(a.contains("abc"));
        System.out.println("size " +a.getPqSize());

        System.out.println("\nIterator test");
        Iterator<String> iterator = a.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            System.out.println(s);
        }
        System.out.println("-----------------------------------------------------------\n");
        System.out.println("\nTesting Customer Class\n");

        MyPriorityQueue <CustomerInquiries> b = new MyPriorityQueue<>(7);
        CustomerInquiries t = new CustomerInquiries("Tim", "Deposit", 2020);
        CustomerInquiries u = new CustomerInquiries("Itamar", "Deposit", 2020);
        CustomerInquiries v = new CustomerInquiries("Moshe", "Withdraw", 2020);
        CustomerInquiries w = new CustomerInquiries("Danny", "Check balance", 2020);
        CustomerInquiries x = new CustomerInquiries("Lisa", "make an appointment ", 2020);
        CustomerInquiries y = new CustomerInquiries("Ruth", "call", 1039);
        CustomerInquiries z = new CustomerInquiries("Alex", "Deposit", 6254);
        System.out.println(b.remove());
        System.out.println(b.poll());
        System.out.println("size " +b.getPqSize());
        System.out.println("Adding values to queue\n");
        b.add(t, 1);
        b.add(u, 3);
        b.add(v, 9);
        System.out.println(b.contains(z));
        b.add(w, 3);
        b.add(x, 5);
        b.add(y, 1);
        b.add(z, 2);
        System.out.println("size " +b.getPqSize());
        System.out.println("\nequals method\n");
        System.out.println(t.equals(u));
        System.out.println(t.equals(z));
        System.out.println(b.poll());
        System.out.println(b.poll());
        System.out.println(b.remove());
        System.out.println("size " +b.getPqSize());

        System.out.println("\nIterator test");
        Iterator<CustomerInquiries> inquiriesIterator = b.iterator();
        while (inquiriesIterator.hasNext()) {
            String s = String.valueOf(inquiriesIterator.next());
            System.out.println(s);
        }

    }
}