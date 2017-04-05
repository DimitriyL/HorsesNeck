//Michael Ruvinshteyn [Horse's Neck]
//APCS2 pd 1
//HW 29 -- Stress is the Best
//2017 - 4 - 4

/*
  DequeDriver: tests methods implemented from interface Deque

  Methods tested:offer(),contains(),poll(),offerFirst(),pollLast()

  Instructions: M-shift-5 -> DLDeque -> <whatever you named your implementation of Deque>
*/

public class DequeTester{

    public static void main(String[] args){

	//tests offer() and poll()
	DLDeque<String> test = new DLDeque<String>(5);
	System.out.println("Upon initialization: size = " + test.size());

	System.out.println("\nTesting offer()...");
	//adding elements until capacity of 5
	System.out.println("one: " + test.offer("one"));
        System.out.println("two: " + test.offer("two"));
	System.out.println("three: " + test.offer("three"));
	System.out.println("four: " + test.offer("four"));
	System.out.println("five: " + test.offer("five"));
	System.out.println("six: " + test.offer("six") + "-past capacity");

	System.out.println("\nTesting toString()...");
	System.out.println(test);
	System.out.println("size = " + test.size());

	System.out.println("\nTesting contains()...");
	System.out.println(test.contains("one"));
	System.out.println(test.contains("two"));
	System.out.println(test.contains("three"));
	System.out.println(test.contains("four"));
	System.out.println(test.contains("five"));
	//"six" does not exist
	System.out.println(test.contains("six" + "- 'six' was never inserted"));

	System.out.println("\nTesting poll()...");
	//removes elements one by one
	System.out.println(test.poll());
	System.out.println(test.poll());
	System.out.println(test.poll());
	System.out.println(test.poll());
	System.out.println(test.poll());
	//polling an empty Dequeue
	System.out.println(test.poll() + "-list empty");

	System.out.println("\nEnd of test 1\n");

	//tests offerFirst() and pollLast()
	DLDeque<String> test2 = new DLDeque<String>(5);
	System.out.println("Upon initialization: size = " + test2.size());

	System.out.println("\nTesting offerFirst()...");
	System.out.println("one: " + test2.offerFirst("one"));
        System.out.println("two: " + test2.offerFirst("two"));
	System.out.println("three: " + test2.offerFirst("three"));
	System.out.println("four: " + test2.offerFirst("four"));
	System.out.println("five: " + test2.offerFirst("five"));
	//should not work, as the Dequeue is to capacity
	System.out.println("six: " + test2.offerFirst("six"));

	System.out.println("\nTesting toString()...");
	System.out.println(test2);
	//elements are backwards, as they were added to the front (stacky?)
	System.out.println("size = " + test2.size());

	System.out.println("\nTesting contains()...");
	System.out.println(test2.contains("one"));
	System.out.println(test2.contains("two"));
	System.out.println(test2.contains("three"));
	System.out.println(test2.contains("four"));
	System.out.println(test2.contains("five"));
	System.out.println(test2.contains("six") + "-never inserted 'six'");

	System.out.println("\nTesting pollLast()...");
	//"last" elements were actually the first to be inserted
	System.out.println(test2.pollLast());
	System.out.println(test2.pollLast());
	System.out.println(test2.pollLast());
	System.out.println(test2.pollLast());
	System.out.println(test2.pollLast());
	System.out.println(test2.pollLast() + "-past capacity");

	//tests removeFirstOccurrence() and removeLastOccurrence()
	DLDeque<String> test3 = new DLDeque<String>(5);
	System.out.println("Upon initialization: size = " + test3.size());

	System.out.println("\nNow adding elements...");
	//adds some elements (3 of them are repeating to test methods mentioned above)
	test3.offer("hello");
	test3.offer("howdy");
	test3.offer("hi");
	test3.offer("hello");
	test3.offer("hello");

	System.out.println("\nCurrent state of test3...");
	System.out.println(test3);

	System.out.println("\nNow testing removeFirstOccurrence()..."); 
	System.out.println(test3.removeFirstOccurrence("hello")); //should remove first occurrence of "hello" (in this case at position 0)

	System.out.println("\nCurrent state of test3...");
	System.out.println(test3);

	System.out.println("\nNow testing removeLastOccurrence()..."); 
	System.out.println(test3.removeLastOccurrence("hello")); //should remove last occurrence of "hello" (in this case at position 3)

	System.out.println("\nCurrent state of test3...");
	System.out.println(test3);
    }

}
