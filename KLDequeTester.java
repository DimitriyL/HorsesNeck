//Kristin Lin
//APCS2 pd01
//HW#29 Stress is the Best
//2017-04-04

/*=================================
  KLDequeTester class -
  driver file for Deque interface inplementations.

  how to use: 
  Replace DDeque with name of appropriate Deque implementation.
  Replace method calls with method chosen by implementer (ex. add vs offer)
  =================================*/

public class KLDequeTester {

    public static void main (String [] args) {

	//creates a new instance of DDeque
	Deque<String> tester = new DLDeque<String> ();
	System.out.println("\nDeque: " + tester + "\tsize : " + tester.size()); 

	//=================TESTING ADD/OFFER FUNCTIONS=====================

	System.out.println("\nTesting Add/Offer Functions: ");

	/*--------------
	  Results: 
	  potato; size = 1 - success
	  null/Exception - addFront does not link _head to new node
	  ---------------*/
	System.out.println("ADDFRONT/OFFERFRONT: potato");
	tester.offerFirst("potato");
	System.out.println("Deque: " + tester + "\tsize : " + tester.size());

	/*--------------
	  Results: 
	  potato, tomato; size = 2 - success
	  potato - did not link new node to last node
	  size != 2 - size was not increased
	  ---------------*/
	System.out.println("ADDLAST/OFFERLAST: tomato");
	tester.offer("tomato");
	System.out.println("Deque: " + tester + "\tsize : " + tester.size());

	/*--------------
	  Results: 
	  celery, potato, tomato; size = 3 - success
	  potato, tomato - does not reset _head
	  potato, celery, tomato - set _head's next instead of prev as new node
	  size != 3 - size was not increased
	  ---------------*/
	System.out.println("ADDFRONT/OFFERFRONT: celery");
	tester.offerFirst("celery");
	System.out.println("Deque: " + tester + "\tsize : " + tester.size());

	/*--------------
	  Results: 
	  celery-->potato-->tomato-->avocado; size = 4 - success
	  celery-->potato-->tomato - _tail's set next was not called
	  celery-->potato-->avocado-->tomato - tail's set prev instead of set next
	  size != 4 - size was not increased
	  ---------------*/
	System.out.println("ADDLAST/OFFERLAST: avocado");
	tester.offer("avocado");
	System.out.println("Deque: " + tester + "\tsize : " + tester.size());


	//=================TESTING REMOVE/POLL FUNCTIONS=====================

	System.out.println("\nTesting Remove/Poll Functions: ");

	/*--------------
	  Results: 
	  potato-->tomato-->avocado; size = 3 - success
	  celery-->potato-->tomato-->avocado - check if _head is linked to _head's next
	  celery-->potato-->tomato - tail was removed instead of head
	  size != 3 - size does not decrease
	  ---------------*/
	System.out.println("REMOVEFIRST/POLLFIRST: ");
	System.out.println(tester.poll());
	System.out.println("Deque: " + tester + "\tsize : " + tester.size());

	/*--------------
	  Results: 
	  potato-->tomato; size = 2 - success
	  potato-->tomato-->avocado - tail was not set to tail's prev
	  tomato-->avocado - head was removed instead of tail
	  size != 2 - size does not decrease
	  ---------------*/
	System.out.println("REMOVELAST/POLLLAST: ");
	System.out.println(tester.pollLast());
	System.out.println("Deque: " + tester + "\tsize : " + tester.size());

	/*--------------
	  Results: 
	  tomato; size = 1 - success
	  potato-->tomato - head was not set to head's next node
	  potato - tail was removed instead of head
	  size != 1 - size does not decrease
	  ---------------*/
	System.out.println("REMOVEFIRST/POLLFIRST: ");
	System.out.println(tester.poll());
	System.out.println("Deque: " + tester + "\tsize : " + tester.size());

	/*--------------
	  Results: 
	  <empty> - sucess
	  potato - tail was not set to null
	  null - created a node with null value
	  ---------------*/
	System.out.println("REMOVELAST/POLLLAST: ");
	System.out.println(tester.pollLast());
	System.out.println("Deque: " + tester + "\tsize : " + tester.size());

	/*--------------
	  Results: 
	  NoSuchElementException (if remove) - success
	  null (if poll) - success
	  potato - head was not set to null
	  ---------------*/	
	System.out.println("REMOVEFIRST/POLLFIRST: ");
	System.out.println(tester.poll());
	System.out.println("Deque: " + tester + "\tsize : " + tester.size());

	/*--------------
	  Results: 
	  NoSuchElementException (if remove) - sucess
	  null (if poll) - success
	  potato - tail was not set to null
	  ---------------*/
	System.out.println("REMOVELAST/POLLLAST: ");
	System.out.println(tester.pollLast());
	System.out.println("Deque: " + tester + "\tsize : " + tester.size());



	//=================TESTING CONTAINS FUNCTIONS=====================

	//System.out.println("\nTesting contains method: ");

	/*--------------
	  Results: 
	  returns false - success
	  returns true - check contains if it compares values accurately
	  ---------------*/
	System.out.println("Contains: potato");
	System.out.println(tester.contains("potato"));
	System.out.println("Deque: " + tester + "\tsize : " + tester.size());

	tester.offerFirst("potato");
	System.out.println("Deque is now: " + tester + "\tsize : " + tester.size());

	/*--------------
	  Results: 
	  returns true - success 
	  returns false - check addFirst or check if contains actually traverses
	  ---------------*/
	System.out.println("Contains: potato");
	System.out.println(tester.contains("potato"));
	System.out.println("Deque: " + tester + "\tsize : " + tester.size());

	/*--------------
	  Results: 
	  returns false - success
	  returns true - remove null node from deque
	  ---------------*/
	System.out.println("Contains: null");
	System.out.println(tester.contains(null));
	System.out.println("Deque: " + tester + "\tsize : " + tester.size());


	//=================TESTING GET/PEEK FUNCTIONS=====================

	System.out.println("\nTesting Get/Peek Functions: ");

	tester.poll();
	System.out.println("Deque is now: " + tester + "\tsize : " + tester.size());

	/*--------------
	  Results: 
	  NoSuchElementException (get) - success
	  null (peek) - success
	  <an element> - error can be in remove/poll or get/peek
	  ---------------*/
	System.out.println("GETFIRST/PEEKFIRST");
	System.out.println(tester.peek());

	/*--------------
	  Results: 
	  NoSuchElementException (get) - success
	  null (peek) - success
	  <an element> - error can be in remove/poll or get/peek
	  ---------------*/
	System.out.println("GETLAST/PEEKLAST");
	System.out.println(tester.peekLast());

	tester.offer("grapes");
	System.out.println("Deque is now: " + tester + "\tsize : " + tester.size());

	/*--------------
	  Results: 
	  grapes - success
	  null - add/offer may not link both _head and _tail to single element
	  when deque was previously empty
	  ---------------*/
	System.out.println("GETFIRST/PEEKFIRST");
	System.out.println(tester.peek());

	/*--------------
	  Results: 
	  grapes - success
	  null - add/offer may not link both _head and _tail to single element
	  when deque was previously empty
	  ---------------*/
	System.out.println("GETLAST/PEEKLAST");
	System.out.println(tester.peekLast());

	tester.offer("bananas");
	tester.offer("grapes");
	tester.offer("pineapple");
	tester.offer("grapes");
	tester.offer("oranges");
	tester.offerFirst("cherries");
	System.out.println("Deque is now: " + tester + "\tsize : " + tester.size());

	/*--------------
	  Results: 
	  cherries - success
	  null - check addFirst/offerFirst
	  <other element> - check addFirst/offerFirst
	  ---------------*/
	System.out.println("GETFIRST/PEEKFIRST");
	System.out.println(tester.peek());

	/*--------------
	  Results: 
	  oranges - success
	  null - check addLast/offerLast
	  <other element> - check addLast/offerLast
	  ---------------*/
	System.out.println("GETLAST/PEEKLAST");
	System.out.println(tester.peekLast());


	//=================TESTING REMOVE OCCURRENCE FUNCTIONS=================

	System.out.println("\nTesting Remove Occurrences Functions: ");

	/*--------------
	  Results: 
	  cherries,bananas,grapes,pineapple,grapes,oranges; size = 6 - success
	  cherries,grapes,bananas,grapes,pineapple,oranges - check removeFirst, which removed last occurrence. 
	  cherries,grapes,bananas,grapes,pineapple,grapes, oranges - check removeFirst to see if it actually relinked nodes appropriately
	  size != 6 - check removeFirst if decreases size
	  ---------------*/
	System.out.println("REMOVEFIRSTOCCURENCE: grapes");
	System.out.println(tester.removeFirstOccurrence("grapes"));
	System.out.println("Deque: " + tester + "\tsize : " + tester.size());

	/*--------------
	  Results: 
	  cherries,bananas,grapes,pineapple,oranges; size = 5 - success
	  cherries,bananas,grapes,pineapple,grapes,oranges - check removeFirst to see if it actually relinked nodes appropriately
	  size != 5 - check removeFirst if decreases size
	  ---------------*/
	System.out.println("REMOVELASTOCCURRENCE: grapes");
	System.out.println(tester.removeLastOccurrence("grapes"));
	System.out.println("Deque: " + tester + "\tsize : " + tester.size());

	/*--------------
	  Results: 
	  bananas-->grapes-->pineapple-->oranges; size = 4 - success
	  cherries-->bananas-->grapes-->pineapple-->oranges - check if removeFO relinks _head's prev to null
	  size != 4 - check if removeFirstOccurrence decreases size when appropriate
	  ---------------*/
	System.out.println("REMOVEFIRSTOCCURRENCE: cherries ");
	System.out.println(tester.removeFirstOccurrence("cherries"));
	System.out.println("Deque: " + tester + "\tsize : " + tester.size());

	/*--------------
	  Results: 
	  bananas, grapes, pineapple; size = 3 - success
	  bananas, grapes, pineapple, oranges - check if removeLO relinks _tail's next to null
	  size != 3 - check if removeLO decreases size when appropriate
	  ---------------*/
	System.out.println("REMOVELASTOCCURRENCE: oranges");
	System.out.println(tester.removeLastOccurrence("oranges"));
	System.out.println("Deque: " + tester + "\tsize : " + tester.size());

	/*--------------
	  Results: 
	  returns false - success
	  returns true - removeFirstOccurrence() has issues; or past error
	  ---------------*/	
	  System.out.println("REMOVEFIRSTOCCURRENCE: blueberries ");
	  System.out.println(tester.removeFirstOccurrence("blueberries"));
	  System.out.println("Deque: " + tester + "\tsize : " + tester.size());

	/*--------------
	  Results: 
	  returns false - success
	  returns true - removeLastOccurrence() has issues; or past error
	  ---------------*/	
	  System.out.println("REMOVELASTOCCURRENCE: blueberries ");
	  System.out.println(tester.removeLastOccurrence("blueberries"));
	  System.out.println("Deque: " + tester + "\tsize : " + tester.size());


    }

}
